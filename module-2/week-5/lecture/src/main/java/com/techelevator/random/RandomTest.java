package com.techelevator.random;

import java.util.Random;

public class RandomTest extends Object {

    public static void main(String[] args) {
// Create an instance of Random
        Random random = new Random();

        int randomInt = random.nextInt();
        System.out.println("Random Integer " + randomInt);

        System.out.println("----- Generate 10 -------------------------------------------");

        for (int i = 0; i < 10; i++) {
            // Generate a random integer
            randomInt = random.nextInt();
            System.out.println("Random Integer " + randomInt);
        }








        System.out.println("=====Generate a random integer within a range (0 to 99) =============");
        // Generate a random integer within a range (0 to 99)
        int randomIntRange = random.nextInt(100);
        System.out.println("Random Integer (0-99): " + randomIntRange);

        System.out.println("===== Generate a random double (0.0 to 1.0) ====");
        double randomDouble = random.nextDouble();
        System.out.println("Random Double: " + randomDouble);

        System.out.println("===== Generate a random boolean ====");
        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random Boolean: " + randomBoolean);


        System.out.println("=========Random Sequences =========");
        random = new Random(100);
        Random random1 = new Random(100);

        for (int i = 0; i < 10; i++) {
            int randomInt = random.nextInt();
            int randomInt1 = random1.nextInt();
            System.out.println("Random Integer A:" + randomInt + " B:" + randomInt1 + " Diff:" + (randomInt - randomInt1));
        }

    }
}
