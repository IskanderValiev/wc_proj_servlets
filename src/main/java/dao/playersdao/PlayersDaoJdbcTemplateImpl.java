package dao.playersdao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.Player;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PlayersDaoJdbcTemplateImpl implements PlayersDao {

    private Connection connection;

    //language=SQL
    private static final String SQL_INSERT_PLAYER =
            "INSERT INTO players (player_number, player_position, player_name, player_lastname, player_age, player_club, player_country) VALUES (?, ?, ?, ?, ?, ?, ?);";

    //language=SQL
    private static final String SQL_SELECT_ALL_BY_CLUB =
            "SELECT * FROM players WHERE player_club = ?;";

    //language=SQL
    private static final String SQL_SELECT_ALL_BY_COUNTRY =
            "SELECT * FROM players WHERE player_country = ?";

    //language=SQL
    private static final String SQL_SELECT_CLUB =
            "SELECT player_club FROM players WHERE player_club = ?";

    //language=SQL
    private static final String SQL_SELECT_PLAYER_BY_ID =
            "SELECT * FROM players WHERE id = ?";

    //language=SQL
    private static final String SQL_DELETE_PLAYER_BY_ID =
            "DELETE FROM players WHERE id = ?";

    //language=SQL
    private static final String SQL_UPDATE_PLAYER =
            "UPDATE players SET player_age = ?, player_lastname = ?, player_name = ?, player_number = ?, player_position = ?, player_club_id = ?, player_country_id = ?";


    @Override
    public List<Player> findAllByClub(String club) {
        return null;
    }

    @Override
    public List<Player> findAllByCountry(String country) {
        return null;
    }

    @Override
    public String getClub(String club) {
        return null;
    }

    @Override
    public String getColumnByName(String columnName, String name) {
        return null;
    }

    @Override
    public void save(Player model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PLAYER);
            statement.setInt(1, model.getNumber());
            statement.setString(2, model.getPosition());
            statement.setString(3, model.getName());
            statement.setString(4, model.getLastname());
            statement.setInt(5, model.getAge());
            statement.setLong(6, model.getClub());
            statement.setLong(7, model.getCountry());

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
    public Player find(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PLAYER_BY_ID);
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return Player.builder()
                        .id(rs.getLong(1))
                        .age(rs.getInt(2))
                        .lastname(rs.getString(3))
                        .name(rs.getString(4))
                        .position(rs.getString(6))
                        .club(rs.getLong(7))
                        .country(rs.getLong(8))
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
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PLAYER_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Player model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PLAYER);
            statement.setInt(1, model.getAge());
            statement.setString(2, model.getLastname());
            statement.setString(3, model.getName());
            statement.setInt(4, model.getNumber());
            statement.setString(5, model.getPosition());
            statement.setLong(6, model.getClub());
            statement.setLong(7, model.getCountry());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
