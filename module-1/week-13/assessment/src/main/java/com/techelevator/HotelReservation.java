package com.techelevator;

public class HotelReservation {
    private String name;
    private int numberOfNights;
    private int nightlyRate;
    private int estimatedTotal;

    //contsructors
    public HotelReservation(String name, int numberOfNights, int nightlyRate) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.nightlyRate = nightlyRate;
        this.estimatedTotal = numberOfNights * nightlyRate;
    }
    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
        this.estimatedTotal = numberOfNights * nightlyRate;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
        this.estimatedTotal = numberOfNights * nightlyRate;
    }

    public int getEstimatedTotal() {
        return estimatedTotal;
    }

    //public method
    public int getActualTotal(boolean requiresCleaning, boolean usedMiniBar) {
        int cleaningFee = 0;
        int miniBarFee = 0;
        int actualTotal = estimatedTotal;

        if (requiresCleaning) {
            cleaningFee += 25;
            actualTotal = cleaningFee;
        }
        if (usedMiniBar) {
            miniBarFee += 15;
            cleaningFee += 50;
            actualTotal = miniBarFee + cleaningFee;
            return actualTotal;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "HotelReservation{" +
                "estimatedTotal=" + estimatedTotal +
                '}';
    }
}

