package com.techelevator.dao;

import com.techelevator.model.Car;

import java.util.List;

public interface ICarDao {
    List<Car> getAllCars();

    void saveCar(Car car);

    int deleteAllCars();

    public Car getCarById(int id);

    public int deleteCar(Car car);

    List<Car> getCarsByYear(int from, int to);

    List<Car> getCarsForDriver(int driverId);

    void unassignDriver(Car c);
}
