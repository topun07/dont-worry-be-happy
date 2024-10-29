package com.techelevator;

public class MainAuction {

    public static void main(String[] args) {

        // Let user select a type of auction and a winner will be determined

        /* Remove comment to put code back into main method

        Scanner input = new Scanner(System.in);
        String inStr;
        boolean exitProgram = false;
        while (!exitProgram) {
            System.out.print("\n\nEnter 1 for general auction, 2 for reserve auction, 3 for buyout auction, or 4 to terminate program:  ");
            inStr = input.nextLine();
            switch (inStr) {
                case "1":
                    // Create a new general auction
                    System.out.println("Starting a general auction");
                    System.out.println("-----------------");

                    Auction generalAuction = new Auction("Tech Elevator t-shirt");

                    generalAuction.placeBid(new Bid("Ann", 11));
                    generalAuction.placeBid(new Bid("Mary", 17));
                    generalAuction.placeBid(new Bid("Rick", 13));

                    for (Bid bid : generalAuction.getAllBids()) {
                        System.out.println(bid.getBidder() + ", bid price of $" +
                                bid.getBidAmount());
                    }
                    System.out.println();
                    System.out.println("The winner of the " + generalAuction.getItemForSale() +
                                        " is " + generalAuction.getHighBid().getBidder() +
                                        " at $" + generalAuction.getHighBid().getBidAmount());
                    List<Bid> list = generalAuction.getAllBids();

                    // this code is to test Auction method getAllBids() returning the reference
                    //   allBids (which can now be modified by the caller, very dangerous) or
                    //   return a new object of the allBids list which will protect allBids from
                    //   being modified or removed all together.  See test code below:

                    // test code for returning allbids and nothing gets printed due to
                    //   allBids being removed, or return a new object of allBids and
                    //   the new object allBids gets removed but not the allBids within
                    //   the generalAuction object stays intact


                    //list.removeAll(list);
                    //for (Bid bid : generalAuction.getAllBids()) {
                    //    System.out.println(bid.getBidder() + ", bid price of $" +
                    //            bid.getBidAmount());
                    //}

                    break;
                case "2":
                    System.out.println();
                    System.out.println("--------------");
                    System.out.println("Buyout Auction");
                    System.out.println();
                    System.out.println();

                    BuyoutAuction buyoutAuction = new BuyoutAuction("Tech Elevator Travel Mug", 55);

                    System.out.println("Buyout price set to: " + buyoutAuction.getBuyoutPrice() + "\n");

                    buyoutAuction.placeBid(new Bid("Karen", 20));
                    buyoutAuction.placeBid(new Bid("Kate", 30));
                    buyoutAuction.placeBid(new Bid("Howard", 20));
                    buyoutAuction.placeBid(new Bid("Ryan", 56));

                    for (Bid bid : buyoutAuction.getAllBids()) {
                        System.out.println(bid.getBidder() + ", bid price of $" +
                                bid.getBidAmount());
                    }

                    System.out.println("The winner of the " + buyoutAuction.getItemForSale() +
                            " is " + buyoutAuction.getHighBid().getBidder() +
                            " at $" + buyoutAuction.getHighBid().getBidAmount());

                    break;
                case "3":
                    System.out.println();
                    System.out.println("--------------");
                    System.out.println("Reserve Auction");
                    System.out.println();
                    System.out.println();

                    ReserveAuction reserveAuction = new ReserveAuction("Tech Elevator Hat", 80);

                    System.out.println("Reserve price set to: " + reserveAuction.getReservePrice() + "\n");

                    reserveAuction.placeBid(new Bid("Ted", 35));
                    reserveAuction.placeBid(new Bid("Marshall", 55));
                    reserveAuction.placeBid(new Bid("Joan", 80));
                    reserveAuction.placeBid(new Bid("Lily", 60));
                    reserveAuction.placeBid(new Bid("Robin", 85));

                    for (Bid bid : reserveAuction.getAllBids()) {
                        System.out.println(bid.getBidder() + ", bid price of $" +
                                bid.getBidAmount());
                    }

                    System.out.println("The winner of the " + reserveAuction.getItemForSale() +
                            " is " + reserveAuction.getHighBid().getBidder() +
                            " at $" + reserveAuction.getHighBid().getBidAmount());

                    break;
                case "4":
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Invalid input, try again");
            }
        }
*/
    }

}
