package com.techelevator.dao;

import com.techelevator.model.Car;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.util.List;

class JdbcCarDaoTest {

    private static final String URL = "jdbc:postgresql://localhost:5432/Transport";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres1";
    private static final String DB_NAME = "transport-test";
    private static SingleConnectionDataSource adminDataSource;
    private static JdbcTemplate adminJdbcTemplate;

    protected SingleConnectionDataSource testDataSource;

    JdbcCarDao carDao;

    public JdbcCarDaoTest() {
        testDataSource = new SingleConnectionDataSource();
        testDataSource.setUrl(URL);
        testDataSource.setUsername(USER);
        testDataSource.setPassword(PASSWORD);
        testDataSource.setAutoCommit(false); //So we can rollback after each test.

        System.out.println("Importing our Test data...");

        try {
            ScriptUtils.executeSqlScript(testDataSource.getConnection(), new ClassPathResource("test-data.sql"));
            System.out.println("Test data successfully imported!");
        } catch (Exception ex) {
            System.out.println("!!!!!! Unable to set-up test data");
        }

        carDao = new JdbcCarDao(testDataSource);
    }

    @BeforeAll
    public static void setupDatabase() {

        System.out.println("Creating Test Database...");
        adminDataSource = new SingleConnectionDataSource();
        adminDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        adminDataSource.setUsername("postgres");
        adminDataSource.setPassword("postgres1");
        adminJdbcTemplate = new JdbcTemplate(adminDataSource);
        adminJdbcTemplate.update("DROP DATABASE IF EXISTS \"" + DB_NAME + "\";");
        adminJdbcTemplate.update("CREATE DATABASE \"" + DB_NAME + "\";");

        System.out.println("Test Database Created!");
    }

    @AfterAll
    public static void cleanupDatabase() {
        if (adminDataSource != null) {
            System.out.println("Deleting our Test Database...");
            adminJdbcTemplate.update("DROP DATABASE \"" + DB_NAME + "\";");
            adminDataSource.destroy();

            System.out.println("Test Database deleted!");
        }
    }

    @AfterEach
    public void rollback() {

        System.out.println("After Test...");
        try {
            System.out.println("Rolling back all changes...");
            testDataSource.getConnection().rollback();
        } catch (Exception ex) {
            System.out.println("!!!!! Unable to roll back!");
        }
    }

    @BeforeEach
    public void before() {
        System.out.println("Before Test...");
    }

    @Test
    void loadCar() {
        Car car1 = carDao.getCarById(1);
        Assert.assertEquals(car1.getMake(), "Toyota");
    }

    @Test
    void getAllCars() {
        List<Car> cars = carDao.getAllCars();
        Assert.assertEquals(cars.size(), 3);
    }

    @Test
    void testUpdateCar() {
        Car car1 = carDao.getCarById(1);
        Assert.assertEquals(car1.getMake(), "Toyota");

        car1.setMake("Tesla");
        carDao.saveCar(car1);

        Car car2 = carDao.getCarById(1);
        Assert.assertEquals(car2.getMake(), "Tesla");
    }

    @Test
    void testUpdateCarAnother() {
        Car car1 = carDao.getCarById(1);
        Assert.assertEquals(car1.getMake(), "Toyota");

        car1.setMake("Jeep");
        carDao.saveCar(car1);

        Car car2 = carDao.getCarById(1);
        Assert.assertEquals(car2.getMake(), "Jeep");
    }
}