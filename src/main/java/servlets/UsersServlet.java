package servlets;

import cookies.Cookies;
import cookies.CookiesImpl;
import dao.usersdao.UsersDao;
import dao.usersdao.UsersDoaJdbcTemplateImpl;
import encoders.Encoder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.User;
import sessions.Sessions;
import sessions.SessionsImpl;
import validators.UsersValidator;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

@AllArgsConstructor
@NoArgsConstructor
@WebServlet("/profile")
public class UsersServlet extends HttpServlet {

    private UsersDao usersDao;
    private Connection connection;

    @Override
    public void init() throws ServletException {
        FileInputStream fis = null;
        Properties properties = new Properties();
        String url = "";
        String username = "";
        String password = "";
        try {
            fis = new FileInputStream("/Users/isko/Desktop/Java/wc_proj/src/main/resources/application.properties");
            properties.load(fis);
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        usersDao = new UsersDoaJdbcTemplateImpl(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookies cookies = new CookiesImpl();
        Cookie cookie = cookies.getCookie("login", request, response);
        String login = "";
        if (!cookie.getValue().equals("guest")) {
            login = cookie.getValue();
        } else {
            response.sendRedirect("/worldcup/index.jsp");
        }
        String name = usersDao.getColumnByLogin("name", login) + " " + usersDao.getColumnByLogin("lastname", login);
        String getGender = usersDao.getColumnByLogin("gender", login);
        String gender;
        if (getGender.equals("t")) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String bday = usersDao.getColumnByLogin("bday", login);
        String city = usersDao.getColumnByLogin("city", login);
        String telephone = usersDao.getColumnByLogin("telephone", login);
        String email = usersDao.getColumnByLogin("email", login);
        String image = usersDao.getColumnByLogin("photo", login);

        request.setAttribute("name", name);
        request.setAttribute("gender", gender);
        request.setAttribute("bday", bday);
        request.setAttribute("city", city);
        request.setAttribute("telephone", telephone);
        request.setAttribute("email", email);
        request.setAttribute("image", image);

        request.getRequestDispatcher("/worldcup/profile.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("signin") != null) {
            System.out.println("sign in button was pressed");
            String login = req.getParameter("enterlogin");
            String salt = usersDao.getColumnByLogin("salt", login);
            String password = "";
            try {
                password = Encoder.encrypt(salt + req.getParameter("enterpass"));
            } catch (LoginException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            if (password.equals(usersDao.getColumnByLogin("password", login))) {
                Cookies cookies = new CookiesImpl();
                cookies.addCookie("login", login, resp, 365*24*60*60);
                if (req.getParameter("remember") != null) {
                    Sessions sessions = new SessionsImpl();
                    sessions.addSession("login", login, req);
                }
                System.out.println("password is correct");
//                req.getRequestDispatcher("worldcup/profile.jsp").forward(req, resp);
//                System.out.println("request dispatcher was called");
                resp.sendRedirect("/profile");
                System.out.println("redirect was sent");
            } else {
                System.out.println("fail");
                System.out.println(login);
                System.out.println(password);
                System.out.println(salt);
            }
        } else {
            if (req.getParameter("signup") != null) {
                String login = req.getParameter("login");
                String password = req.getParameter("pass");
                String confirmPassword = req.getParameter("cpassword");
                String name = req.getParameter("name");
                String lastname = req.getParameter("lname");
                String email = req.getParameter("email");
                String telephone = req.getParameter("phone");
                String city = req.getParameter("city");
                boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                java.util.Date parser = null;
                try {
                    parser = simpleDateFormat.parse(req.getParameter("byear")+ req.getParameter("bmon") + req.getParameter("bday"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date bday = new Date(parser.getTime());

                String salt = Encoder.salt();
                if (UsersValidator.isCorrect(login, password, confirmPassword, name, lastname, email, bday, telephone, email)) {
                    try {
                        usersDao.save(User.builder()
                                .login(login)
                                .password(Encoder.encrypt(salt + password))
                                .name(name)
                                .lastname(lastname)
                                .email(email)
                                .telephone(telephone)
                                .city(city)
                                .gender(gender)
                                .bday(bday)
                                .build());
                    }catch (NoSuchAlgorithmException | LoginException ex) {
                        ex.printStackTrace();
                    }
                    resp.sendRedirect("/worldcup/success.jsp");
                } else {
                    req.setAttribute("message", "Input data are not correct.");
                }
            }
        }

    }
}
