package com.techelevator.dao;

import com.techelevator.model.Car;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCarDao implements ICarDao {

    JdbcTemplate jdbcTemplate;

    public JdbcCarDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveCar(Car car) {

        String sqlInsert = "INSERT INTO cars (make, model, year, driver_id) VALUES (?, ?, ?, ?) RETURNING id";
        String sqlUpdate = "UPDATE cars set make = ?, model = ?, year = ?, driver_id = ? WHERE ID = ?";

        if (car.getId() == -1) {
            int carId = this.jdbcTemplate.queryForObject(sqlInsert, int.class, car.getMake(), car.getModel(), car.getYear(), car.getDriverId());
            car.setId(carId);
        } else
            this.jdbcTemplate.update(sqlUpdate, car.getMake(), car.getModel(), car.getYear(), car.getDriverId(), car.getId());
    }

    @Override
    public int deleteAllCars() {
        String sql = "DELETE FROM Cars";
        return this.jdbcTemplate.update(sql);
    }
    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT id, make, model, year, driver_id FROM cars order by Id";

        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Car car = mapRowSetToCar(results);
            cars.add(car);
        }
        return cars;
    }

    public int deleteCar(Car car) {
        String sql = "DELETE from Cars where Id = ?";
        return this.jdbcTemplate.update(sql, car.getId());
    }

    @Override
    public List<Car> getCarsByYear(int from, int to) {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT id, make, model, year, driver_id FROM cars where year >= ? and year <= ? order by Id";

        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, from, to);

        while (results.next()) {
            Car car = mapRowSetToCar(results);
            cars.add(car);
        }
        return cars;
    }

    @Override
    public List<Car> getCarsForDriver(int driverId) {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT id, make, model, year, driver_id FROM cars where driver_id = ? order by Id";

        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, driverId);

        while (results.next()) {
            Car car = mapRowSetToCar(results);
            cars.add(car);
        }
        return cars;
    }

    @Override
    public void unassignDriver(Car car) {
        String sqlUpdate = "UPDATE cars set driver_id = NULL WHERE id = ?";

          int numUpdated = this.jdbcTemplate.update(sqlUpdate, car.getId());
          if(numUpdated > 0)
              car.setDriverId(-1);

    }

    public Car getCarById(int id) {
        String sql = "SELECT id, make, model, year, driver_id from Cars where Id = ?";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, id);

        try {
            while (results.next()) {
                Car car = mapRowSetToCar(results);
                return car;
            }
        }
        catch (BadSqlGrammarException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    private Car mapRowSetToCar(SqlRowSet results) {

        Car car = new Car(
                results.getString("make"),
                results.getString("model"),
                results.getInt("year"),
                results.getInt("driver_id"),
                results.getInt("id")

        );

        //car.setId(results.getInt("id"));

        return car;
    }
}
