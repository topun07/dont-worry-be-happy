package com.lendingcatalog;

import com.lendingcatalog.model.Movie;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTests {
    @Test
    public void testMatchesName() {
        Movie movie = new Movie("Jurassic Park", "Steven Spielberg", LocalDate.of(1993, 6, 11));

        assertTrue(movie.matchesName("Jurassic Park"));
        assertTrue(movie.matchesName("jurassic park"));
        assertFalse(movie.matchesName("superman"));
        assertFalse(movie.matchesName("Some other movie"));
        assertTrue(movie.matchesName(" "));
        assertFalse(movie.matchesName("null"));
    }

    @Test
    public void testMatchesCreator() {
        Movie movie = new Movie("Jurassic Park", "Steven Spielberg", LocalDate.of(1993, 6, 11));

        assertTrue(movie.matchesCreator("Steven Spielberg"));
        assertTrue(movie.matchesCreator("steven spielberg"));
        assertTrue(movie.matchesCreator("spielberg"));
        assertFalse(movie.matchesCreator("Some other director"));
        assertTrue(movie.matchesCreator(" "));
        assertFalse(movie.matchesCreator("null"));
    }

    @Test
    public void testMatchesYear() {
        Movie movie = new Movie("Inception", "Steven Spielberg", LocalDate.of(1993, 6, 11));

        assertTrue(movie.matchesYear(1993));
        assertFalse(movie.matchesYear(2009));
        assertFalse(movie.matchesYear(1));
        assertFalse(movie.matchesYear(12435));
    }
}

