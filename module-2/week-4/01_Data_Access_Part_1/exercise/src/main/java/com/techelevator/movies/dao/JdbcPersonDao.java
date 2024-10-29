package com.techelevator.movies.dao;

import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        String sql = "SELECT * " +
                "FROM person";
        return jdbcTemplate.query(sql, new PersonRowMapper());
    }

    @Override
    public Person getPersonById(int id) {
        String sql = "SELECT * " +
                "FROM person " +
                "WHERE person_id = ?";
        List<Person> persons = jdbcTemplate.query(sql, new PersonRowMapper(), id);
        if (persons.isEmpty()) {
            return null;
        }
        return persons.get(0);
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        String sql;
        String searchName;

        if (useWildCard) {
            sql = "SELECT * " +
                    "FROM person " +
                    "WHERE LOWER(person_name) " +
                    "LIKE LOWER(?)";
            searchName = "%" + name + "%";
        } else {
            sql = "SELECT * " +
                    "FROM person " +
                    "WHERE LOWER(person_name) = LOWER(?)";
            searchName = name;
        }

        return jdbcTemplate.query(sql, new PersonRowMapper(), searchName);
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        String sql;
        String searchName;

        if (useWildCard) {
            sql = "SELECT distinct p.* FROM person p " +
                    "JOIN movie m ON p.person_id = m.director_id " +
                    "JOIN collection c ON m.collection_id = c.collection_id " +
                    "WHERE LOWER(c.collection_name) like LOWER(?)";
            searchName = "%" + collectionName + "%";
        } else {
            sql = "SELECT distinct p.* FROM person p " +
                    "JOIN movie m ON p.person_id = m.director_id " +
                    "JOIN collection c ON m.collection_id = c.collection_id " +
                    "WHERE LOWER(c.collection_name) = LOWER(?)";
            searchName = collectionName;
        }

        return jdbcTemplate.query(sql, new PersonRowMapper(), searchName);
    }

    private static class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("person_id"));
            person.setName(rs.getString("person_name"));
            person.setBirthday(rs.getDate("birthday") != null ? rs.getDate("birthday").toLocalDate() : null);
            person.setBiography(rs.getString("biography"));
            person.setProfilePath(rs.getString("profile_path"));
            person.setHomePage(rs.getString("home_page"));
            return person;
        }
    }
}
