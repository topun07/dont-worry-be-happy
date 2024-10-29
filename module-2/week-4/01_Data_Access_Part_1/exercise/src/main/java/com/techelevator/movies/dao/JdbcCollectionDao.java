package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.util.List;


public class JdbcCollectionDao implements CollectionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        String sql = "SELECT * " +
                "FROM collection";
        return jdbcTemplate.query(sql, new CollectionRowMapper());
    }

    @Override
    public Collection getCollectionById(int id) {
        String sql = "SELECT * " +
                "FROM collection " +
                "WHERE collection_id = ?";
        List<Collection> collections = jdbcTemplate.query(sql, new CollectionRowMapper(), id);
        if (collections.isEmpty()) {
            return null;
        }
        return collections.get(0);
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        String sql;
        String searchName;

        if (useWildCard) {
            sql = "SELECT * " +
                    "FROM collection " +
                    "WHERE LOWER (collection_name) LIKE LOWER (?)"; // Case-insensitive
            searchName = "%" + name + "%"; //wildcard search
        } else {
            sql = "SELECT * " +
                    "FROM collection " +
                    "WHERE LOWER (collection_name) = LOWER(?)";
            searchName = name;
        }
        return jdbcTemplate.query(sql, new CollectionRowMapper(), searchName);
    }

    @Override
    public void save(Collection collection) {
        String sql = "INSERT INTO collection (collection_name) VALUES (?)";
        jdbcTemplate.update(sql, collection.getName());
    }

    @Override
    public void update(Collection collection) {
        String sql = "UPDATE collection SET collection_name = ? WHERE collection_id = ?";
        jdbcTemplate.update(sql, collection.getName(), collection.getId());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM collection WHERE collection_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class CollectionRowMapper implements RowMapper<Collection> {
        @Override
        public Collection mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Collection collection = new Collection();
            collection.setId(rs.getInt("collection_id"));
            collection.setName(rs.getString("collection_name"));
            return collection;
        }
    }
}