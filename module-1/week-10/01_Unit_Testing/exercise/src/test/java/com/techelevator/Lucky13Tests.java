package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Lucky13Tests{

    @Test
    public void testGetLucky_noOnesOrThrees(){
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {0, 2, 4};
        assertTrue(lucky13.getLucky(nums), "Expected true for array without 1s and 3s");
    }

    @Test
    public void testGetLucky_containsOneAndThree(){
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {1, 2, 3};
        assertFalse(lucky13.getLucky(nums), "Expected false for array with both 1 and 3");
    }

    @Test
    public void testGetLucky_containsOne(){
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {1, 2, 4};
        assertFalse(lucky13.getLucky(nums), "Expected false for array with 1");
    }

    @Test
    public void testGetLucky_containsThree(){
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {2, 3, 5};
        assertFalse(lucky13.getLucky(nums), "Expected false for array with 3");
    }

    @Test
    public void testGetLucky_emptyArray(){
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {};
        assertTrue(lucky13.getLucky(nums), "Expected true for an empty array");
    }

    @Test
    public void testGetLucky_nullArray(){
        Lucky13 lucky13 = new Lucky13();
        assertTrue(lucky13.getLucky(null), "Expected true for a null array");
    }
}
