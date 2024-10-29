package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.util.List;


public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenres() {
        String sql = "SELECT * " +
                "FROM genre";
        return jdbcTemplate.query(sql, new GenreRowMapper());
    }

    @Override
    public Genre getGenreById(int id) {
        String sql = "SELECT * " +
                "FROM genre " +
                "WHERE genre_id = ?";
        List<Genre> genres = jdbcTemplate.query(sql, new GenreRowMapper(), id);
        if (genres.isEmpty()) {
            return null;
        }
        return genres.get(0);
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        String sql;
        String searchName;

        if (useWildCard) {
            sql = "SELECT * " +
                    "FROM genre " +
                    "WHERE LOWER(genre_name) " +
                    "LIKE LOWER(?)";
            searchName = "%" + name + "%";
        } else {
            sql = "SELECT * " +
                    "FROM genre " +
                    "WHERE LOWER(genre_name) = LOWER(?)";
            searchName = name;
        }

        return jdbcTemplate.query(sql, new GenreRowMapper(), searchName);
    }
    private static class GenreRowMapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Genre genre = new Genre();
            genre.setId(rs.getInt("genre_id"));
            genre.setName(rs.getString("genre_name"));
            return genre;
        }
    }
}
