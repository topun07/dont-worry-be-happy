package com.techelevator.random;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        String salt = "mySaltValue"; // Define your salt value
        int numberOfRandomNumbers = 5; // Define how many random numbers you want to generate

        try {
            // Generate a seed from the salt
            byte[] seed = generateSeedFromSalt(salt);

            // Initialize SecureRandom with the seed
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(seed);

            // Generate random numbers
            for (int i = 0; i < numberOfRandomNumbers; i++) {
                int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99
                System.out.println("Random Number " + (i + 1) + ": " + randomNumber);
            }
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static byte[] generateSeedFromSalt(String salt) throws NoSuchAlgorithmException {
        // Create a MessageDigest instance for SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Generate a hash from the salt
        byte[] hash = digest.digest(salt.getBytes());

        // Use the hash as a seed
        return Arrays.copyOf(hash, 16); // Use the first 16 bytes as the seed
    }
}

