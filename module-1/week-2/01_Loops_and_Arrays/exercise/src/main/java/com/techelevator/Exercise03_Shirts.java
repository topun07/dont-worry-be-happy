package com.techelevator;

public class Exercise03_Shirts {

    private final static char SMALL_TSHIRT = 'S';
    private final static char MEDIUM_TSHIRT = 'M';
    private final static char LARGE_TSHIRT = 'L';

    /*
    A t-shirt company rep from Top Threads just finished taking an order
    from a client and needs to key it into the system. The client ordered,
    3 Small shirts ('S'), 2 Medium shirts ('M'), and 1 Large shirt ('L').

    Implement the logic to reflect an order of 6 t-shirts.

    Examples:
    buildOrder() → ['S', 'S', 'S', 'M', 'M', 'L']
     */
    public char[] buildOrder() {
        char[] order = new char[6];
        int index = 0;

        for (int i = 0; i < 3; i++){
            order[index++] = 'S';
        }
        for (int i = 0; i < 2; i++){
            order[index++] = 'M';
        }
        for (int i = 0; i< 1; i++){
            order[index] = 'L';
        }
        return order;
    }

    /*
    Another customer called in and is hosting a large networking event and
    needs a bulk order. Rather than indicate how many of each shirt they
    wanted, they've asked for as even distribution as possible.

    Implement the logic to generate an order representing as even a distribution
    as possible, for example: ('S', 'M', 'L', 'S', 'M', 'L', 'S', ...)

    Note: The number of shirts ordered is guaranteed to be non-negative.

    Examples:
    buildBulkOrder(6) → ['S', 'M', 'L', 'S', 'M', 'L']    
    buildBulkOrder(3) → ['S', 'M', 'L']
    buildBulkOrder(4) → ['S', 'M', 'L', 'S']
    buildBulkOrder(0) → []
     */
    public char[] buildBulkOrder(int numberOfShirts) {
        char[] order = new char[numberOfShirts];

        //arrays representing the shirt sizes
        char[] sizes = {'S', 'M', 'L'};
        int sizeIndex = 0;

        //fill the order array with an even distribution of shirt sizes
        for (int i = 0; i < numberOfShirts; i++){
            order[i] = sizes[sizeIndex];
            sizeIndex = (sizeIndex + 1) % sizes.length;
        }
        return order;
    }

    /*
    The warehouse is out of small shirts and will only request more when the
    next order comes in that includes an 'S' shirt.

    Implement the logic to look through the next incoming order `char[] order`
    and return true if we need to place an order for Small shirts.

    Examples:
    placeRequest(['M', 'L', 'S']) → true
    placeRequest(['M', 'S', 'L']) → true
    placeRequest(['M', 'M', 'L']) → false
    placeRequest([]) → false
     */
    public boolean placeRequest(char[] order) {
        //iterate through the order array
        for (char shirt : order){
            //check if the order includes an 'S' shirt
            if (shirt == 'S'){
                return true; //If "S" shirt found, return true
            }
        }
        return false; //if 'S' shirt not found, return false
    }
}
