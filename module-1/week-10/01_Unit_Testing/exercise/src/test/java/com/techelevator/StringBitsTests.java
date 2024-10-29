package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;

import com.techelevator.StringBits;
import org.junit.jupiter.api.Test;

public class StringBitsTests {

    @Test
    public void testGetBitsWithRegularString(){
        StringBits stringBits = new StringBits();
        assertEquals("Hlo", stringBits.getBits("Hello"));
    }

    @Test
    public void testGetBitsWithShortString(){
        StringBits stringBits = new StringBits();
        assertEquals("H", stringBits.getBits("Hi"));
    }

    @Test
    public void testGetBitsWithRepeatingCharacters(){
        StringBits stringBits = new StringBits();
        assertEquals("Hello", stringBits.getBits("Heeololeon"));
    }

    @Test
    public void testGetBitsWithEmptyString(){
        StringBits stringBits = new StringBits();
        assertEquals("", stringBits.getBits(""));
    }

    @Test
    public void testGetBitsWithNullString(){
        StringBits stringBits = new StringBits();
        assertEquals("", stringBits.getBits(null));
    }

    @ Test
    public void testGetBitsWithSingleCharacter(){
        StringBits stringBits = new StringBits();
        assertEquals("A", stringBits.getBits("A"));
    }

    @Test
    public void testGetBitsWithAllSameCharacters(){
        StringBits stringBits = new StringBits();
        assertEquals("AAA", stringBits.getBits("AAAAAA"));
    }

}
