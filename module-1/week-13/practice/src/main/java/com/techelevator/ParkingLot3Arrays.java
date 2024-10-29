package com.techelevator;

public class ParkingLot3Arrays {

    private Car[] smallLot = new Car[5];
    private Car[] midLot = new Car[4];
    private Car[] largeLot = new Car[5];

    boolean open;

    int numberOfAvailableSlots(String type) {

        return 0;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    boolean park(Car toPark) throws ParkingLotException {

        // check if the lot is open and if not throw an exception
        if (!isOpen())
            throw (new ParkingLotException("Lot is not Open"));

        // check the car type
        if (toPark.getType().equals(Car.COMPACT)) {
            // if(type == "small"

            // loop over the smallLot and check for index that is null and put the car there
            for (int i = 0; i < smallLot.length; i++) {
                if (smallLot[i] == null) {
                    smallLot[i] = toPark;
                    return true;
                }
            }
        }
        // return true
        // if we dont find a spot - return false
        if (toPark.getType().equals(Car.MIDSIZE)) {
            // if(type == "small"

            // loop over the smallLot and check for index that is null and put the car there
            for (int i = 0; i < midLot.length; i++) {
                if (midLot[i] == null) {
                    midLot[i] = toPark;
                    return true;
                }
            }
        }
        if (toPark.getType().equals(Car.FULLSIZE)) {
            // if(type == "small"

            // loop over the smallLot and check for index that is null and put the car there
            for (int i = 0; i < largeLot.length; i++) {
                if (largeLot[i] == null) {
                    largeLot[i] = toPark;
                    return true;
                }
            }
        }
        return false;
    }

    Car exit(String license) {
        for (int i = 0; i < smallLot.length; i++) {
            if (smallLot[i] != null) {
                if (smallLot[i].getLicense().equals(license)) {
                    Car toEvict = smallLot[i];
                    smallLot[i] = null;
                    return toEvict;
                }
            }
        }
        for (int i = 0; i < midLot.length; i++) {
            if (midLot[i] != null) {
                if (midLot[i].getLicense().equals(license)) {
                    Car toEvict = midLot[i];
                    midLot[i] = null;
                    return toEvict;
                }
            }
        }
        for (int i = 0; i < largeLot.length; i++) {
            if (largeLot[i] != null) {
                if (largeLot[i].getLicense().equals(license)) {
                    Car toEvict = largeLot[i];
                    largeLot[i] = null;
                    return toEvict;
                }
            }
        }
        return null;
    }

    int getnumberOfOpenFullSizeSlots() {
        int numFree = 0;
        for (int i = 0; i < largeLot.length; i++) {
            if (largeLot[i] != null) {
                numFree++;
            }
        }
        return numFree;
    }

    int getnumberOfOpenMidsizeSlots() {
        int numFree = 0;
        for (int i = 0; i < midLot.length; i++) {
            if (midLot[i] != null) {
                numFree++;
            }
        }
        return numFree;
    }

    int getnumberOfOpenCompactSlots() {
        int numFree = 0;
        for (int i = 0; i < smallLot.length; i++) {
            if (smallLot[i] != null) {
                numFree++;
            }
        }
        return numFree;
    }
    int openSlots(){
        return getnumberOfOpenFullSizeSlots() + getnumberOfOpenMidsizeSlots()  + getnumberOfOpenCompactSlots();
    }

    int lotSize(){
        return smallLot.length + midLot.length + largeLot.length;
    }
}
