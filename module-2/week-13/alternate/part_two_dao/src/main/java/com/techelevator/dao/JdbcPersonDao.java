package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Person;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Person getPersonById(int personId) {
        Person person = null;
        String sql = "SELECT person_id, first_name, last_name, birthdate, deathdate" +
                " FROM person WHERE person_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, personId);
            if (results.next()) {
                person = mapRowToPerson(results);
            }
        } catch (DataAccessException e) {
            throw new DaoException("Error accessing database to get person by ID", e);
        }

        return person;
    }

    @Override
    public Person createPerson(Person newPerson) {
        String sql = "INSERT INTO person (first_name, last_name, birthdate, deathdate) " +
                "VALUES (?, ?, ?, ?) RETURNING person_id;";
        try {
            Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                    newPerson.getFirstName(), newPerson.getLastName(),
                    newPerson.getBirthDate(), newPerson.getDeathDate());

            return getPersonById(newId);
        } catch (DataAccessException e) {
            throw new DaoException("Error adding new person to the database", e);
        }
    }

    @Override
    public int deletePersonById(int personId) {
        try {
            String deleteMovieScreenwriterSql = "DELETE FROM movie_screenwriter WHERE screenwriter_id = ?;";
            jdbcTemplate.update(deleteMovieScreenwriterSql, personId);

            String updateDirectorSql = "UPDATE movie SET director_id = NULL WHERE director_id = ?;";
            jdbcTemplate.update(updateDirectorSql, personId);

            String updateMusicBySql = "UPDATE movie SET music_by_id = NULL WHERE music_by_id = ?;";
            jdbcTemplate.update(updateMusicBySql, personId);

            String deletePersonSql = "DELETE FROM person WHERE person_id = ?;";
            return jdbcTemplate.update(deletePersonSql, personId);
        } catch (DataAccessException e) {
            throw new DaoException("Error deleting person from the database", e);
        }
    }


    private Person mapRowToPerson(SqlRowSet results) {
        Person person = new Person();
        person.setPersonId(results.getInt("person_id"));
        person.setFirstName(results.getString("first_name"));
        person.setLastName(results.getString("last_name"));
        person.setBirthDate(results.getDate("birthdate").toLocalDate());
        if (results.getDate("deathdate") != null) {
            person.setDeathDate(results.getDate("deathdate").toLocalDate());
        }
        return person;
    }
}
