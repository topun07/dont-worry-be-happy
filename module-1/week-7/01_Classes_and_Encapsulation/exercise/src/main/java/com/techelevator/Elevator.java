package com.techelevator;

public class Elevator {
    //instance
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    //constructor
    public Elevator(int numberOfFloors){
        this.currentFloor = 1; // elev starts on first floor
        this.numberOfFloors = numberOfFloors;
        this.doorOpen = false; // elev default door closed
    }

    //getter
    public int getCurrentFloor(){
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    //method
    public void openDoor(){
            doorOpen = true;
        }
        public void closeDoor(){
            doorOpen = false;
        }

        public void goUp(int desiredFloor){
            if (!doorOpen && desiredFloor > currentFloor && desiredFloor <= numberOfFloors){
                currentFloor = desiredFloor;
            }
        }
        public void goDown(int desiredFloor){
            if (!doorOpen && desiredFloor < currentFloor && desiredFloor >= 1){
                currentFloor = desiredFloor;
            }
        }
        //testing
        public static void main(String[] args){
            Elevator elevator = new Elevator(10);

            //open and close door
            elevator.openDoor();
            System.out.println("is door open " + elevator.isDoorOpen());
            elevator.closeDoor();
            System.out.println("is door open " + elevator.isDoorOpen());

            //go up
            elevator.goUp(5);
            System.out.println("current floor " + elevator.getCurrentFloor());

            //go down
            elevator.goDown(3);
            System.out.println("current floor " + elevator.getCurrentFloor());
        }
    }

