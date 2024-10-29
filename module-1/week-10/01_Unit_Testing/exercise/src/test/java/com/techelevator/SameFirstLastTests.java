package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SameFirstLastTests {

    @Test
    public void testIsItTheSame_lengthZero() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {};
        assertFalse(sameFirstLast.isItTheSame(nums), "Expected false for an empty array");
    }

    @Test
    public void testIsItTheSame_lengthOne() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {1};
        assertTrue(sameFirstLast.isItTheSame(nums), "Expected true for an array of length 1");
    }

    @Test
    public void testIsItTheSame_firstAndLastEqual() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {1, 2, 3, 1};
        assertTrue(sameFirstLast.isItTheSame(nums), "Expected true for array [1, 2, 3, 1] where first and last elements are equal");
    }

    @Test
    public void testIsItTheSame_firstAndLastNotEqual() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {1, 2, 3};
        assertFalse(sameFirstLast.isItTheSame(nums), "Expected false for array [1, 2, 3] where first and last elements are not equal");
    }

    @Test
    public void testIsItTheSame_anotherFirstAndLastEqual() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {1, 2, 1};
        assertTrue(sameFirstLast.isItTheSame(nums), "Expected true for array [1, 2, 1] where first and last elements are equal");
    }

    @Test
    public void testIsItTheSame_arrayWithNegativeNumbers() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {-1, 2, -1};
        assertTrue(sameFirstLast.isItTheSame(nums), "Expected true for array [-1, 2, -1] where first and last elements are equal");
    }

    @Test
    public void testIsItTheSame_arrayWithSameFirstAndLastZero() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {0, 1, 0};
        assertTrue(sameFirstLast.isItTheSame(nums), "Expected true for array [0, 1, 0] where first and last elements are equal");
    }

    @Test
    public void testIsItTheSame_nullArray() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = null;
        assertFalse(sameFirstLast.isItTheSame(nums), "Expected false for a null array");
    }

}
