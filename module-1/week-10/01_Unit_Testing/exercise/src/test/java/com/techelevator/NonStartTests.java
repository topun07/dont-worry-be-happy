package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NonStartTests {
    @Test
    public void testGetPartialString_bothNonEmpty() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("Hello", "There");
        assertEquals("ellohere", result, "Expected 'ellohere' when input strings are 'Hello' and 'There'");
    }

    @Test
    public void testGetPartialString_firstStringEmpty() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("", "There");
        assertEquals("here", result, "Expected 'here' when the first string is empty and the second string is 'There'");
    }

    @Test
    public void testGetPartialString_secondStringEmpty() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("Hello", "");
        assertEquals("ello", result, "Expected 'ello' when the first string is 'Hello' and the second string is empty");
    }

    @Test
    public void testGetPartialString_bothEmpty() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("", "");
        assertEquals("", result, "Expected an empty string when both input strings are empty");
    }

    @Test
    public void testGetPartialString_firstStringNull() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString(null, "There");
        assertEquals("here", result, "Expected 'here' when the first string is null and the second string is 'There'");
    }

    @Test
    public void testGetPartialString_secondStringNull() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("Hello", null);
        assertEquals("ello", result, "Expected 'ello' when the first string is 'Hello' and the second string is null");
    }

    @Test
    public void testGetPartialString_bothNull() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString(null, null);
        assertEquals("", result, "Expected an empty string when both input strings are null");
    }

    @Test
    public void testGetPartialString_differentStrings() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("java", "code");
        assertEquals("avaode", result, "Expected 'avaode' when input strings are 'java' and 'code'");
    }

    @Test
    public void testGetPartialString_otherStrings() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("shotl", "java");
        assertEquals("hotlava", result, "Expected 'hotlava' when input strings are 'shotl' and 'java'");
    }
}
