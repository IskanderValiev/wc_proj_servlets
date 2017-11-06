package dao.countriesdao;

import lombok.Getter;
import lombok.Setter;
import models.Club;
import models.Country;
import models.Player;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Getter
@Setter

public class CountriesDaoJdbcTemplateImpl implements CountriesDao {

    private Connection connection;

    //language=SQL
    private static final String SQL_SELECT_COUNTRY_BY_ID =
            "SELECT * FROM country WHERE country.id = ?";
    //language=SQL
    private static final String SQL_SELECT_COUNTRY_BY_NAME =
            "SELECT * FROM country WHERE country_name = ?;";

    //language=SQL
    private static final String SQL_INSERT_COUNTRY =
            "INSERT INTO country(country_name, country_flag) VALUES (?, ?);";

    //language=SQL
    private static final String SQL_SELECT_ALL =
            "SELECT * FROM country;";

    //language=SQL
    private static final String SQL_SELECT_ALL_PLAYERS =
            "SELECT * FROM country LEFT JOIN players ON country.country_name = players.player_country;";

    //language=SQL
    private static final String SQL_DELETE_COUNTRY_BY_ID =
            "DELETE * FROM country WHERE country.id = ?";

    //language=SQL
    private static final String SQL_UPDATE_COUNTRY =
            "UPDATE country SET country_flag = ?, country_name = ?";

    @Override
    public Country findCountryByName(String name) {
        return null;
    }

    @Override
    public List<Country> findALL() {
        return null;
    }

    @Override
    public String getColumnByName(String columnName, String name) {
        return null;
    }

    @Override
    public void save(Country model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_COUNTRY, new String[]{"id"});
            statement.setString(1, model.getFlag());
            statement.setString(2, model.getName());
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
    public Country find(Long id) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_COUNTRY_BY_ID);
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return Country.builder()
                        .id(rs.getLong(1))
                        .flag(rs.getString(2))
                        .name(rs.getString(3))
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
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_COUNTRY_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Country model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_COUNTRY);
            statement.setString(1, model.getFlag());
            statement.setString(2, model.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
