package dao.clubsdao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.Club;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClubsDaoJdbcTemplateImpl implements ClubsDao {

    private Connection connection;

    //language=SQL
    private static final String SQL_SELECT_LOGO =
            "SELECT club_logo FROM club WHERE club_name = ?";

    //language=SQL
    private static final String SQL_INSERT_CLUB =
            "INSERT INTO club(club_country_id, club_logo, club_name) VALUES (?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_CLUB_BY_ID =
            "SELECT * FROM club WHERE club.id = ?";

    //language=SQL
    private static final String SQL_DELETE_CLUB_BY_ID =
            "DELETE * FROM club WHERE club.id = ?";

    //language=SQL
    private static final String SQL_UPDATE_CLUB =
            "UPDATE club SET club_country_id = ?, country_logo = ?, country_name = ?";

    @Override
    public void save(Club model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_CLUB, new String[]{"id"});
            statement.setLong(1, model.getCountry());
            statement.setString(2, model.getLogo());
            statement.setString(3, model.getName());
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
    public Club find(Long id) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CLUB_BY_ID);
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return Club.builder()
                        .id(rs.getLong(1))
                        .country(rs.getLong(2))
                        .logo(rs.getString(3))
                        .name(rs.getString(4))
                        .build();
            } else {
                throw new IllegalArgumentException("User not found");
            }
        } catch (SQLException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_CLUB_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Club model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_CLUB);
            statement.setLong(1, model.getCountry());
            statement.setString(2, model.getLogo());
            statement.setString(3, model.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getLogo(String clubName) {
        return null;
    }
}
