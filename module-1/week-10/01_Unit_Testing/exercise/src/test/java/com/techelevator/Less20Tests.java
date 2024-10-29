package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Less20Tests{

    @Test
    public void testIsLessThanMultipleof20_1LessThanMultiple(){
        Less20 less20 = new Less20();
        assertTrue(less20.isLessThanMultipleOf20(19));
        assertTrue(less20.isLessThanMultipleOf20(39));
        assertTrue(less20.isLessThanMultipleOf20(59));
    }

    @Test
    public void testIsLessThanMultipleof20_2LessThanMultiple(){
        Less20 less20 = new Less20();
        assertTrue(less20.isLessThanMultipleOf20(18));
        assertTrue(less20.isLessThanMultipleOf20(38));
        assertTrue(less20.isLessThanMultipleOf20(58));
    }

    @Test
    public void testIsLessThanMultipleof20_Multipleof20(){
        Less20 less20 = new Less20();
        assertFalse(less20.isLessThanMultipleOf20(20));
        assertFalse(less20.isLessThanMultipleOf20(40));
        assertFalse(less20.isLessThanMultipleOf20(60));
    }

    @Test
    public void testIsLessThanMultipleof20_NotCloseToMultiple(){
        Less20 less20 = new Less20();
        assertFalse(less20.isLessThanMultipleOf20(0));
        assertFalse(less20.isLessThanMultipleOf20(15));
        assertFalse(less20.isLessThanMultipleOf20(21));
    }

    @Test
    public void testIsLessThanMultipleof20_JustAboveMultiple(){
        Less20 less20 = new Less20();
        assertFalse(less20.isLessThanMultipleOf20(21));
        assertFalse(less20.isLessThanMultipleOf20(41));
        assertFalse(less20.isLessThanMultipleOf20(61));
    }
}
