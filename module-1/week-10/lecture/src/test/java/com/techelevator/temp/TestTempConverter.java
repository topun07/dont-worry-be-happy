package com.techelevator.temp;

import org.junit.*;

public class TestTempConverter {


    @Test
    public void testC2F() {

        double inputC = 20;
        double expectedF = 68;

        TempConverter tc = new TempConverter();

        double result = tc.convertToFahrenheit(inputC);

        Assert.assertEquals(expectedF,result,0.01);

        System.out.println("testC2F...");
    }

    @Test
    public void testF2C() {

        double expectedC = 20;
        double inputF = 68;

        TempConverter tc = new TempConverter();

        double result = tc.convertToCelsius(inputF);

        Assert.assertEquals(expectedC,result, 0.01);

        System.out.println("testF2C...");
    }

    @Test
    public void test_Conversion_Adds_ToHistory() {

        TempConverter tc = new TempConverter();

        int currHistory = tc.numHistoryEntries();

        tc.convertToFahrenheit(10);

        Assert.assertEquals(currHistory+1, tc.numHistoryEntries());

        System.out.println("test_Conversion_Adds_ToHistory...");

    }


    // Does clear history actually clears the history
    @Test
    public void test_clear_history_clears_history() {

        TempConverter tc = new TempConverter();
        tc.convertToFahrenheit(10);
        Assert.assertEquals(1,tc.numHistoryEntries());
        tc.clearHistory();
        Assert.assertEquals(0,tc.numHistoryEntries());

        System.out.println("test_clear_history_clears_history...");

    }


// Are we returning the correct number of history entries

    @Test
    public void test_can_add_multiple_to_history() {

        TempConverter tc = new TempConverter();
        tc.convertToFahrenheit(10);
        Assert.assertEquals(1,tc.numHistoryEntries());
        tc.convertToFahrenheit(10);
        Assert.assertEquals(2,tc.numHistoryEntries());
        tc.convertToFahrenheit(10);
        Assert.assertEquals(3,tc.numHistoryEntries());

        System.out.println("test_can_add_multiple_to_history...");
    }


    // Can we find existing conversion in the history

    @Test
    public void test_we_can_search_history() {

        TempConverter tc = new TempConverter();
        tc.convertToFahrenheit(15);

        Assert.assertEquals(true, tc.hasTemperature(15d));

        Assert.assertEquals(false, tc.hasTemperature(20d));

        System.out.println("test_we_can_search_history...");
    }
}
