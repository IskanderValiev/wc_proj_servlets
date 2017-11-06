package dao.usersdao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@NoArgsConstructor
public class UsersDoaJdbcTemplateImpl implements UsersDao {

    private Connection connection;

    //language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO users (login, password, name, lastname, gender, bday, city, telephone, email, salt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM users WHERE users.id = ?";

    //language=SQL
    private static final String SQL_DELETE_BY_ID = "DELETE FROM users WHERE user.id = ?";

    //language=SQL
    private static final String SQL_SELECT_PASSWORD_BY_LOGIN = "SELECT password FROM users WHERE login = ?";

    //language=SQL
    private static final String SQL_CHECKING_USER_EXISTENCE =
            "SELECT id FROM users WHERE login = ?";

    //language=SQL
    private static final String SQL_CHECKING_EMAIL_EXISTANCE =
            "SELECT id FROM users WHERE email = ?";

    //language=SQL
    private static final String SQL_SELECT_STATUS =
            "SELECT status FROM users WHERE login = ?";

    //language=SQL
    private static final String SQL_SELECT_LOGIN_BY_PASSWORD =
            "SELECT login FROM users WHERE password = ?";

    //language=SQL
    private static final String SQL_UPDATE_USER =
            "UPDATE users SET bday = ?, city = ?, email = ?, gender = ?, lastname = ?, name = ?, password = ?, photo = ?, telephone = ?";


    @Override
    public String getPasswordByLogin(String login) {
        return null;
    }

    @Override
    public String getColumnByLogin(String columnName, String login) {
        //language=SQL
        String sql = "SELECT "+ columnName + " FROM users WHERE login = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString(1));
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getLoginByEmail(String email) {
        return null;
    }

    @Override
    public boolean exists(String login) {
        return false;
    }

    @Override
    public boolean existingEmail(String email) {
        return false;
    }

    @Override
    public boolean isAdmin(String login) {
        return false;
    }

    @Override
    public void updateUsersData(String login, String changeableColumnName, String value) {

    }

    @Override
    public String getLoginByPassword(String password) {
        return null;
    }

    @Override
    public void save(User model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, new String[]{"id"});
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getName());
            statement.setString(4, model.getLastname());
            statement.setBoolean(5, model.isGender());
            statement.setDate(6, model.getBday());
            statement.setString(7, model.getCity());
            statement.setString(8, model.getTelephone());
            statement.setString(9, model.getEmail());
            statement.setString(10, model.getSalt());
            statement.executeUpdate();
            // получаем указатель на результирующие строки
            // результирующие строки - сгенерированный id
            ResultSet resultSet = statement.getGeneratedKeys();
            // одновременно сдвигаем итератор и проверяем есть там че или нет
            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
                model.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User find(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return User.builder()
                        .id(rs.getLong(1))
                        .bday(rs.getDate(2))
                        .city(rs.getString(3))
                        .email(rs.getString(4))
                        .gender(rs.getBoolean(5))
                        .lastname(rs.getString(6))
                        .login(rs.getString(7))
                        .name(rs.getString(8))
                        .password(rs.getString(9))
                        .salt(rs.getString(10))
                        .telephone(rs.getString(11))
                        .build();
            } else {
                throw new IllegalArgumentException("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER);
            statement.setDate(1, model.getBday());
            statement.setString(2, model.getCity());
            statement.setString(3, model.getEmail());
            statement.setBoolean(4, model.isGender());
            statement.setString(5, model.getLastname());
            statement.setString(6, model.getLogin());
            statement.setString(7,  model.getName());
            statement.setString(8, model.getPassword());
            statement.setString(9, model.getTelephone());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}