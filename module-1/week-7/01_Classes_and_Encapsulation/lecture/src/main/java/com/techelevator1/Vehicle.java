package com.techelevator1;

public class Vehicle {
        private String make;   // highlighted in IntelliJ because I do not have a setter method
        private String model;
        private int year;
        private String color;
        public static int countPublic = 0;  // if not initialized here the default is 0
        private static int countPrivate = 0;
        public Vehicle() {
            model = "";
            make = "";
            year = 0;
            color = "";
        }
        public Vehicle(String model, String make, int year, String color) {
            this.model = model;
            this.make = make;
            this.year = year;
            this.color = color;
        }
        String getMake() {
            return make;
        }
        String getModel() {
            return model;
        }
        int getYear() {
            return year;
        }
        String getColor() {
            return color;
        }
        int getCountPrivate() {
        return countPrivate;
        }
        void setColor(String color) {
            this.color = color;
        }
        void setCountPrivate(int countPrivate) {
            Vehicle.countPrivate = countPrivate;
        }
        void incrementCountPrivate() {
        countPrivate++;
        }
        static int multiplyCountPrivate(int multiplier) {
            return multiplier * countPrivate;
        }

        @Override
        public String toString() {
            return ("Make: " + make + ", Model: " + model + ", Year: " + year +
                    ", Color: " + color + ", countPrivate: " + countPrivate +
                    ", countPublic: " + countPublic);
        }

    }
