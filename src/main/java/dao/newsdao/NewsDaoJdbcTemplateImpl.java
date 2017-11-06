package dao.newsdao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class NewsDaoJdbcTemplateImpl implements NewsDao {

    private Connection connection;

    //language=SQL
    private static final String SQL_INSERT_NEWS =
            "INSERT INTO news(news_header, news_content, news_image, news_date, news_type) VALUES (?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_NEWS_BY_ID =
            "SELECT * FROM news WHERE news_id = ?";

    //language=SQL
    private static final String SQL_DELETE_NEWS_BY_ID =
            "DELETE FROM news WHERE news_id = ?";

    //language=SQL
    private static final String SQL_UPDATE_NEWS =
            "UPDATE news SET news_content = ?, news_date = ?, news_header = ?, news_image = ?, news_type = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_NEWS =
            "SELECT * FROM news WHERE news_type = :news_type";

    //language=SQL
    private static final String SQL_SELECT_ALL_ARTICLES =
            "SELECT * FROM news WHERE news_type = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_BLOGS =
            "SELECT * FROM news WHERE news_type = ?";

    @Override
    public List<News> getAllNews() {
        return null;
    }

    @Override
    public List<News> getAllArticles() {
        return null;
    }

    @Override
    public List<News> getAllBlogs() {
        return null;
    }

    @Override
    public void save(News model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_NEWS);
            statement.setString(1, model.getHeader());
            statement.setString(2, model.getContent());
            statement.setString(3, model.getImage());
            statement.setDate(4, model.getDate());
            statement.setString(5, model.getType());

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong(1);
                model.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public News find(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_NEWS_BY_ID);
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return News.builder()
                        .id(rs.getLong(1))
                        .content(rs.getString(2))
                        .date(rs.getDate(3))
                        .header(rs.getString(4))
                        .image(rs.getString(5))
                        .type(rs.getString(6))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_NEWS_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(News model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_NEWS);
            statement.setString(1, model.getContent());
            statement.setDate(2, model.getDate());
            statement.setString(3, model.getHeader());
            statement.setString(4, model.getImage());
            statement.setString(5, model.getType());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
