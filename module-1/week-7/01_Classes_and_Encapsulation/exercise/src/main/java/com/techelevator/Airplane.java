package com.techelevator;

public class Airplane {
    //instances
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    //constructors
    private Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    // getter
    public String getPlaneNumber(){
        return planeNumber;
    }
    public int getTotalFirstClassSeats(){
        return totalFirstClassSeats;
    }
    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }
    public int getAvailableFirstClassSeats(){
        return totalFirstClassSeats;
    }
    public int getTotalCoachSeats(){
        return totalCoachSeats;
    }
    public int getBookedCoachSeats(){
        return bookedCoachSeats;
    }
    public int getAvailableCoachSeats(){
        return totalCoachSeats - bookedCoachSeats;
    }

    //reserve seats
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){
        if (forFirstClass){
            if (totalNumberOfSeats <= getAvailableFirstClassSeats()){
                bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            }
        }
        return false;
    }

    //testing
    public static void main(String[] args){
        //airplane object
        Airplane plane = new Airplane("ABC123", 10, 20);

        //reserve seats
        boolean reservedFirstClass = plane.reserveSeats(true, 5);
        boolean reservedCoach = plane.reserveSeats(false, 15);

        //Display reservation status
        System.out.println("Reserved first class seats " + reservedFirstClass);
        System.out.println("Reserved coach seats " + reservedCoach);
        System.out.println("Available first class seats " + plane.getAvailableFirstClassSeats());
        System.out.println("Available coach seats " + plane.getAvailableCoachSeats());
    }
}
