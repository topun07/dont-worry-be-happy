package com.lendingcatalog;

import com.lendingcatalog.model.Book;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTests {

    @Test
    public void testMatchesName(){
        Book book = new Book("Exhalation", "Ted Chiang", LocalDate.of(2008, 11, 15));

        assertTrue(book.matchesName("Exhalation"));
        assertTrue(book.matchesName("exhalation"));
        assertFalse(book.matchesName("Gatsby"));
        assertFalse(book.matchesName("Some other title"));
        assertFalse(book.matchesName(" "));
        assertFalse(book.matchesName("null"));
    }

    @Test
    public void testMatchesCreator() {
        Book book = new Book("Exhalation", "Ted Chiang", LocalDate.of(2008, 11, 15));

        assertTrue(book.matchesCreator("Ted Chiang"));
        assertTrue(book.matchesCreator("ted chiang"));
        assertFalse(book.matchesCreator("Fitzgerald"));
        assertFalse(book.matchesCreator("Reed"));
        assertFalse(book.matchesCreator("Some other author"));
        //assertFalse(book.matchesCreator(""));
        assertFalse(book.matchesCreator("null"));
    }

    @Test
    public void testMatchesYear() {
        Book book = new Book("Exhalation", "Ted Chiang", LocalDate.of(2009, 11, 15));

        assertTrue(book.matchesYear(2009));
        assertFalse(book.matchesYear(1924));
        assertFalse(book.matchesYear( 1));
        assertFalse(book.matchesYear(23456));
    }
}
