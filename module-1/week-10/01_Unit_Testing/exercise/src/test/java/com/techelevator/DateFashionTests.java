package com.techelevator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFashionTests {
    @Test
    public void testGetATableWithStylishYouAndDate(){
        DateFashion dateFashion = new DateFashion();
        assertEquals(2, dateFashion.getATable(9, 10));
    }
    @Test
    public void testGetTableWithStylishDateNot(){
        DateFashion dateFashion = new DateFashion();
        assertEquals(2, dateFashion.getATable(8, 5));
    }

    @Test
    public void testGetTableWithDateStylishYouNot(){
        DateFashion dateFashion = new DateFashion();
        assertEquals(2, dateFashion.getATable(5,8));
    }

    @Test
    public void testGetTableWithYouAndDateNotStylish(){
        DateFashion dateFashion = new DateFashion();
        assertEquals(1, dateFashion.getATable(5,5));
    }

    @Test
    public void testGetTableWithYouNotStylishAndDateVeryNotStylish(){
        DateFashion dateFashion = new DateFashion();
        assertEquals(0, dateFashion.getATable(2,3));
    }

    @Test
    public void testGetTableWithDateNotStylishAndYouVeryNotStylish(){
        DateFashion dateFashion = new DateFashion();
        assertEquals(0, dateFashion.getATable(2,3));
    }

    @Test
    public void testGetTableWithBothVeryNotStylish(){
        DateFashion dateFashion = new DateFashion();
        assertEquals(0, dateFashion.getATable(1,2));
    }

    @Test
    public void testGetTableWithDateWithYouJustStylishEnoughAndDateStylish(){
        DateFashion dateFashion = new DateFashion();
        assertEquals(2, dateFashion.getATable(8,10));
    }

    @Test
    public void testGetTableWithYouStylishAndDateJustStylishEnough(){
        DateFashion dateFashion = new DateFashion();
        assertEquals(2, dateFashion.getATable(10, 8));
    }

    @Test
    public void testGetTableWithBothJustStylishEnough(){
        DateFashion dateFashion = new DateFashion();
        assertEquals(2, dateFashion.getATable(8, 8));
    }
}
