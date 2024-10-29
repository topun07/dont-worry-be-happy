package com.techelevator.app;

import com.techelevator.dao.IDriverDao;
import com.techelevator.dao.JdbcDriverDao;
import com.techelevator.model.Car;
import com.techelevator.dao.ICarDao;
import com.techelevator.model.Driver;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Arrays;
import java.util.List;

import com.techelevator.dao.JdbcCarDao;


public class App {

    private static final String URL = "jdbc:postgresql://localhost:5432/Transport";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres1";

    public static void main(String[] args) {
        List<Car> cars = getSomeSampleCars();
        List<Driver> drivers = getSomeSampleDrivers();

        ICarDao carDao = getCarDao();
        IDriverDao driverDao = getDriverDao();

        //Clean up all the cars (this needs to go first)
        int numDeleted = carDao.deleteAllCars();
        System.out.println(numDeleted >0 ? "Deleted " + numDeleted + " cars" :"Nothing to delete");

        //Clean up all drivers
        numDeleted = driverDao.deleteAllDrivers();
        System.out.println(numDeleted >0 ? "Deleted " + numDeleted + " drivers" :"Nothing to delete");

        System.out.println("Saving drivers...");
        for (Driver driver  : drivers)
            driverDao.saveDriver(driver);

        List<Driver> savedDrivers = driverDao.getAllDrivers();
        for(Driver d : savedDrivers)
            System.out.println(d);

        System.out.println("Assign drivers to some cars...");
        //Assign the first car to the first driver and second car to the second driver
        Car firstCar = cars.get(0);
        Driver firstDriver =  drivers.get(0);

        firstCar.setDriverId(firstDriver.getId());
        carDao.saveCar(firstCar);

        Car secondCar = cars.get(1);
        Driver secondDriver =  drivers.get(2);

        secondCar.setDriverId(secondDriver.getId());
        carDao.saveCar(secondCar);

        // Read cars from database
        List<Car> readCars = carDao.getAllCars();

        // Print read cars
        for (Car car : readCars) {
            System.out.println(car);
        }

        System.out.println("Deleting a car...");
        //Delete the second car
        Car carToDelete = readCars.get(1);
        numDeleted = carDao.deleteCar(carToDelete);
        System.out.println("Deleted " + numDeleted + " cars!");

        System.out.println("Replacing the driver in the first car...");
        // Read cars from database again
        readCars = carDao.getAllCars();
        Car someCar = readCars.get(0);
        System.out.println("Before replacing:" + someCar);

        //Assign a new driver to first car
        Driver newDriver = drivers.get(drivers.size()-1);
        someCar.setDriverId(newDriver.getId());
        carDao.saveCar(someCar);

        //Re-read the same car to see if that worked
        Car updated = carDao.getCarById(someCar.getId());
        System.out.println("After replacing:" + updated);

        //Delete the driver that was last assigned to that updated car
        //First find all cars for that driver
        List<Car> carsForDriver = carDao.getCarsForDriver(updated.getDriverId());

        //Unassign all the cars that may be assigned to that driver first
        for(Car c : carsForDriver) {
            carDao.unassignDriver(c);
        }

        //Now that we no longer have any cars assigned to that driver we can delete the driver
        numDeleted = driverDao.deleteDriver(newDriver);

        System.out.println("Deleted " + numDeleted + " drivers");

    }



    private static List<Car> getSomeSampleCars() {
        List<Car> cars = Arrays.asList(
                new Car("Toyota", "Camry", 2020),
                new Car("Honda", "Civic", 2018),
                new Car("Ford", "Mustang", 2019)
        );

        return cars;
    }

    private static List<Driver> getSomeSampleDrivers() {
        List<Driver> drivers = Arrays.asList(
                new Driver("Peter Smith", 25),
                new Driver("Jim Beam", 44),
                new Driver("Kim Richards", 53)
        );

        return drivers;
    }
    private static ICarDao getCarDao() {
        ICarDao dao;
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        dao = new JdbcCarDao(dataSource);
        return dao;
    }

    private static IDriverDao getDriverDao() {
        IDriverDao dao;
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        dao = new JdbcDriverDao(dataSource);
        return dao;
    }
}


