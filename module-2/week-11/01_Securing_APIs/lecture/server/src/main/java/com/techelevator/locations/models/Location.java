package com.techelevator.locations.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Location {

    private int id;
    @NotBlank(message = "The field name is required.")
    private String name;
    @NotBlank(message = "The field address is required.")
    private String address;
    @NotBlank(message = "The field city is required.")
    private String city;
    @NotBlank(message = "The field state is required.")
    private String state;
    @NotBlank(message = "The field zip is required.")
    private String zip;

    @Size(min = 1, max = 5, message = "Gates must be between 1 and 5")
    private String[] gates;

    public Location() {
    }

    public Location(int id, String name, String address, String city, String state, String zip, String [] gates) {
        this.id = id;

        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.gates = gates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", name=" + name + "]";
    }

    public String[] getGates() {
        return this.gates;
    }

    public void setGates(String[] gates) {
        this.gates = gates;
    }
}

