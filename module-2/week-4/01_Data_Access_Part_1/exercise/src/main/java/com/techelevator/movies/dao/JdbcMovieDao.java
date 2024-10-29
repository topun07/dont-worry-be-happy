package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        String sql = "SELECT * " +
                "FROM movie";
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public Movie getMovieById(int id) {
        String sql = "SELECT * " +
                "FROM movie " +
                "WHERE movie_id = ?";
        List<Movie> movies = jdbcTemplate.query(sql, new MovieRowMapper(), id);
        if (movies.isEmpty()) {
            return null;
        }
        return movies.get(0);
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        String sql;
        String searchTitle;

        if (useWildCard) {
            sql = "SELECT * " +
                    "FROM movie " +
                    "WHERE LOWER(title) " +
                    "LIKE LOWER(?)";
            searchTitle = "%" + title + "%";
        } else {
            sql = "SELECT * " +
                    "FROM movie " +
                    "WHERE LOWER(title) = LOWER(?)";
            searchTitle = title;
        }

        return jdbcTemplate.query(sql, new MovieRowMapper(), searchTitle);
    }

    @Override
    public List<Movie> getMoviesByDirectorNameAndBetweenYears(String directorName, int startYear, int endYear, boolean useWildCard) {
        String sql;
        String searchDirectorName;

        if (useWildCard) {
            sql = "SELECT * \n" +
                    "FROM movie m \n" +
                    "JOIN person p \n" +
                    "ON m.director_id = p.person_id \n" +
                    "WHERE LOWER(p.person_name) LIKE LOWER(?) \n" +
                    "AND EXTRACT(YEAR FROM m.release_date) BETWEEN ? AND ? \n" +
                    "ORDER BY m.release_date ASC;";
            searchDirectorName = "%" + directorName + "%";
        } else {
            sql = "SELECT * " +
                    "FROM movie m " +
                    "JOIN person p ON m.director_id = p.person_id " +
                    "WHERE LOWER(p.person_name) = LOWER(?) " +
                    "AND YEAR(m.release_date) " +
                    "BETWEEN ? AND ? " +
                    "ORDER BY m.release_date ASC";
            searchDirectorName = directorName;
        }
        return jdbcTemplate.query(sql, new MovieRowMapper(), searchDirectorName, startYear, endYear);
    }
    private static class MovieRowMapper implements RowMapper<Movie> {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();
            movie.setId(rs.getInt("movie_id"));
            movie.setTitle(rs.getString("title"));
            movie.setOverview(rs.getString("overview"));
            movie.setTagline(rs.getString("tagline"));
            movie.setPosterPath(rs.getString("poster_path"));
            movie.setHomePage(rs.getString("home_page"));
            movie.setReleaseDate(rs.getDate("release_date").toLocalDate());
            movie.setLengthMinutes(rs.getInt("length_minutes"));
            movie.setDirectorId(rs.getInt("director_id"));
            movie.setCollectionId(rs.getInt("collection_id"));
            return movie;
        }
    }
}
