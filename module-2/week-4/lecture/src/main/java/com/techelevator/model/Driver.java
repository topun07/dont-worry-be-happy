package com.techelevator.model;

public class Driver {

    int id = -1;
    String Name;
    int Age;

    public Driver(String name, int age) {
        Name = name;
        Age = age;
    }


    public Driver(int id, String name, int age) {
        this(name,age);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return Name + ", Age:" + Age + " (id:" + id + ")";
    }
}
