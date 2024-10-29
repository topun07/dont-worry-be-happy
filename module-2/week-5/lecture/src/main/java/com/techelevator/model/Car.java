package com.techelevator.model;

public class Car {   //POJO
    private String make;
    private String model;
    private int year;

    private int driverId;

    private int id = -1;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car(String make, String model, int year, int driverid,  int id) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.driverId = driverid;
        this.id = id;
    }

    // Getters and Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return  year + " - " + make  + " - " + model + " - Driver: " + driverId + " (id:" + getId() + ")";
    }
}

