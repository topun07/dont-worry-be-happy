package com.lendingcatalog;

import com.lendingcatalog.model.Tool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToolTests {

    @Test
    public void testMatchesName() {
        Tool tool = new Tool("Hammer", "Craftsman", 1);

        assertTrue(tool.matchesName("Hammer"));
        assertTrue(tool.matchesName("hammer"));
        assertTrue(tool.matchesName("Hamm"));
        assertFalse(tool.matchesName("Some other tool"));
        assertFalse(tool.matchesName(" "));
        assertFalse(tool.matchesName("null"));
    }

    @Test
    public void testMatchesCreator() {
        Tool tool = new Tool("Hammer", "Craftsman", 1);

        assertTrue(tool.matchesCreator("Craftsman"));
        assertTrue(tool.matchesCreator("craftsman"));
        assertTrue(tool.matchesCreator("Craft"));
        assertFalse(tool.matchesCreator("Some other manufacturer"));
        assertFalse(tool.matchesCreator(" "));
        assertFalse(tool.matchesCreator("null"));
    }

    @Test
    public void testMatchesYear() {
        Tool tool = new Tool("Hammer", "Craftsman", 1);

        assertFalse(tool.matchesYear(-1));
        assertFalse(tool.matchesYear(2));
        assertFalse(tool.matchesYear(0));
    }
}