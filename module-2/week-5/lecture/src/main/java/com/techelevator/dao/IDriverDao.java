package com.techelevator.dao;

import com.techelevator.model.Driver;

import java.util.List;

public interface IDriverDao {
    List<Driver> getAllDrivers();

    void saveDriver(Driver Driver);

    int deleteAllDrivers();

    public Driver getDriverById(int id);

    public int deleteDriver(Driver Driver);

}
