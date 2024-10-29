package com.techelevator.dao;

import com.techelevator.model.Driver;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcDriverDao implements IDriverDao {

    JdbcTemplate jdbcTemplate;

    public JdbcDriverDao(BasicDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveDriver(Driver Driver) {

        String sqlInsert = "INSERT INTO Drivers (name, age) VALUES (?, ?) RETURNING id";
        String sqlUpdate = "UPDATE Drivers set name = ?, age = ? WHERE ID = ?";

        if (Driver.getId() == -1) {
            int DriverId = this.jdbcTemplate.queryForObject(sqlInsert, int.class, Driver.getName(), Driver.getAge());
            Driver.setId(DriverId);
        } else
            this.jdbcTemplate.update(sqlUpdate, Driver.getName(), Driver.getAge(), Driver.getId());
    }

    @Override
    public int deleteAllDrivers() {
        String sql = "DELETE FROM Drivers";
        return this.jdbcTemplate.update(sql);
    }

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> Drivers = new ArrayList<>();
        String sql = "SELECT id, name, age FROM Drivers order by Id";

        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Driver Driver = mapRowSetToDriver(results);
            Drivers.add(Driver);
        }
        return Drivers;
    }

    public int deleteDriver(Driver Driver) {
        String sql = "DELETE from Drivers where Id = ?";
        return this.jdbcTemplate.update(sql, Driver.getId());
    }


    public Driver getDriverById(int id) {
        String sql = "SELECT id, name, age from Drivers where Id = ?";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, id);

        try {
            while (results.next()) {
                Driver Driver = mapRowSetToDriver(results);
                return Driver;
            }
        }
        catch (BadSqlGrammarException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    private Driver mapRowSetToDriver(SqlRowSet results) {

        Driver Driver = new Driver(
                results.getInt("id"),
                results.getString("name"),
                results.getInt("age")
        );

        return Driver;
    }
}
