package com.techelevator1;

public class Main {

    public static void main(String[] args) {

        // Call overloaded constructors and create two objects of the Vehicle class
        Vehicle car = new Vehicle();
        Vehicle truck = new Vehicle("R1S", "Rivian", 2024, "Green");
        // Vehicle truck = new Vehicle();


        // Display results
        System.out.println("\nDisplay object car:\n" + car);
        System.out.println("Make: " + car.getMake() + ", Model: " + car.getModel() +
                            ", Year: " + car.getYear() + ", Color: " + car.getColor());
        System.out.println("\nDisplay object truck:\n" + truck);
        System.out.println("Make: " + truck.getMake() + ", Model: " + truck.getModel() +
                            ", Year: " + truck.getYear() + ", Color: " + truck.getColor());

        // System.out.println(car.color);  // show error goes away when private goes to public

        // Comment out both constructors in Vehicle class  and line 8 above (replace with line 9) to use the default constructor and
        // see if output is the same for car


        // set color after instantiation
        car.setColor("Green");
        truck.setColor("Black");


        // Display results pay passing object car and truck to println() method
        // The override toString() method in the Vehicle class is called
        // over the toString() method found in the Object class
        // Comment out toString() method and see how display changes
        System.out.println("\nDisplay object car:\n" + car);
        System.out.println("\nDisplay object truck:\n" + truck.toString());


        // ****************************************************
        // Example - STATIC VARIABLE CODE
        // example of tightly coupled code, opposite of what we want (loosely coupled code
        Vehicle.countPublic++;
        Vehicle.countPublic++;
        System.out.println("\n\nAfter incrementing static variable countPublic twice:");
        System.out.println("Car countPublic: " + Vehicle.countPublic);
        System.out.println("Truck countPublic: " + Vehicle.countPublic);


        // loosely coupled due to private variable countPrivate
        // notice we set countPrivate via the car object, but it also changes
        // countPrivite in the truck object due to it is a static variable
        car.setCountPrivate(99);
        System.out.println("Car countPrivate: " + car.getCountPrivate());
        System.out.println("Truck countPrivate: " + truck.getCountPrivate());


        // notice we set countPrivate via the truck object, but it also changes
        // countPrivate in the car object due to it is a static variable
        truck.incrementCountPrivate();
        System.out.println("Car countPrivate: " + car.getCountPrivate());
        System.out.println("Truck countPrivate: " + truck.getCountPrivate());


        // ****************************************
        // Example - STATIC METHOD CODE
        System.out.println("Static method call: " + Vehicle.multiplyCountPrivate(8));
    }

}
