package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.HashMap;

public class WordCountTests {

    @Test
    public void testGetCount_multipleOccurrences() {
        WordCount wordCount = new WordCount();
        String[] words = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);
        assertEquals(expected, wordCount.getCount(words), "Expected map with word counts for input ['ba', 'ba', 'black', 'sheep']");
    }

    @Test
    public void testGetCount_multipleOccurrencesDifferentOrder() {
        WordCount wordCount = new WordCount();
        String[] words = {"a", "b", "a", "c", "b"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 2);
        expected.put("b", 2);
        expected.put("c", 1);
        assertEquals(expected, wordCount.getCount(words), "Expected map with word counts for input ['a', 'b', 'a', 'c', 'b']");
    }

    @Test
    public void testGetCount_emptyArray() {
        WordCount wordCount = new WordCount();
        String[] words = {};
        Map<String, Integer> expected = new HashMap<>();
        assertEquals(expected, wordCount.getCount(words), "Expected empty map for empty input array");
    }

    @Test
    public void testGetCount_uniqueWords() {
        WordCount wordCount = new WordCount();
        String[] words = {"c", "b", "a"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("c", 1);
        expected.put("b", 1);
        expected.put("a", 1);
        assertEquals(expected, wordCount.getCount(words), "Expected map with word counts for input ['c', 'b', 'a']");
    }

    @Test
    public void testGetCount_nullArray() {
        WordCount wordCount = new WordCount();
        String[] words = null;
        Map<String, Integer> expected = new HashMap<>();
        assertEquals(expected, wordCount.getCount(words), "Expected empty map for null input array");
    }

    @Test
    public void testGetCount_singleWord() {
        WordCount wordCount = new WordCount();
        String[] words = {"hello"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 1);
        assertEquals(expected, wordCount.getCount(words), "Expected map with single entry for input ['hello']");
    }

    @Test
    public void testGetCount_caseSensitivity() {
        WordCount wordCount = new WordCount();
        String[] words = {"Hello", "hello"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Hello", 1);
        expected.put("hello", 1);
        assertEquals(expected, wordCount.getCount(words), "Expected map with case-sensitive counts for input ['Hello', 'hello']");
    }

}
