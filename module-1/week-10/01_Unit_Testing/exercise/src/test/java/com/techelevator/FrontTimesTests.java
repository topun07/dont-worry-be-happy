package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FrontTimesTests {

    @Test
    public void testGenerateStringWithLongerString(){
        FrontTimes frontTimes = new FrontTimes();
        assertEquals("ChoCho", frontTimes.generateString("Choclate", 2));
        assertEquals("ChoChoCho", frontTimes.generateString("Choclate", 3));
    }

    @Test
    public void testGenerateStringsWithExactThreeCharString(){
        FrontTimes frontTimes = new FrontTimes();
        assertEquals("AbcAbcAbc", frontTimes.generateString("Abc", 3));
        assertEquals("AbcAbc", frontTimes.generateString("Abc", 2));
    }

    @Test
    public void testGenerateStringsWithShorterStrings(){
        FrontTimes frontTimes = new FrontTimes();
        assertEquals("AbAbAb", frontTimes.generateString("Ab", 3));
        assertEquals("A", frontTimes.generateString("A", 1));
    }

    @Test
    public void testGenerateStringWithEmptyString(){
        FrontTimes frontTimes = new FrontTimes();
        assertEquals("", frontTimes.generateString("", 3));
    }

    @Test
    public void testGenerateStringsWithNullString(){
        FrontTimes frontTimes = new FrontTimes();
        assertEquals("", frontTimes.generateString("", 3));
        }

    @Test
    public void testGenerateStringsWithZeroCopies(){
        FrontTimes frontTimes = new FrontTimes();
        assertEquals("", frontTimes.generateString("Chocolate", 0));
        assertEquals("", frontTimes.generateString("Abc", 0));
    }

    @Test
    public void testGenerateStringsWithSingleCopy(){
        FrontTimes frontTimes = new FrontTimes();
        assertEquals("Abc", frontTimes.generateString("Abc", 1));
        assertEquals("Ab", frontTimes.generateString("Ab", 1));
        assertEquals("Cho", frontTimes.generateString("Chocolate", 1));
    }
}
