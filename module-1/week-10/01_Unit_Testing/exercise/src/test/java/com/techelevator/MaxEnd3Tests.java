package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MaxEnd3Tests {

    @Test
    public void testMakeArray_firstElementLarger(){
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {11, 5, 9};
        int[] expected = {11, 11, 11};
        assertArrayEquals(expected, maxEnd3.makeArray(nums), "Expected array with all elements set to the first element when it is larger");
    }

    @Test
    public void testMakeArray_lastElementLarger(){
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {1, 2, 3};
        int[] expected = {3, 3, 3};
        assertArrayEquals(expected, maxEnd3.makeArray(nums), "Expected array with all elements set to the last element when it is larger");
    }

    @Test
    public void testMakeArray_firstAndLastElementsEqual() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {5, 2, 5};
        int[] expected = {5, 5, 5};
        assertArrayEquals(expected, maxEnd3.makeArray(nums), "Expected array with all elements set to the first/last element value when they are equal");
    }

    @Test
    public void testMakeArray_largeNumbers() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {1000, 2000, 3000};
        int[] expected = {3000, 3000, 3000};
        assertArrayEquals(expected, maxEnd3.makeArray(nums), "Expected array with all elements set to the larger value between the first and last elements for large numbers");
    }

    @Test
    public void testMakeArray_negativeNumbers() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {-5, -10, -15};
        int[] expected = {-5, -5, -5};
        assertArrayEquals(expected, maxEnd3.makeArray(nums), "Expected array with all elements set to the larger value between the first and last elements for negative numbers");
    }

}
