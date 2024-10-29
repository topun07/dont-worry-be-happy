package com.techelevator;

public class Exercise05_Weather {

    private final static int FREEZING_TEMPERATURE = 32;

    /*
    GaleForce Meteorologists recently developed a new weather station and need it to perform
    some common measurements for reporting.

    Note: Assume all temperatures are in Fahrenheit (°F) unless otherwise
    noted.
     */

    /*
    GaleForce needs to know the number of days in the upcoming forecast
    where the temperature is at or below freezing.

    Given an array of high temperatures, count the number of days when
    the high temperature is freezing (32° F) or below.

    Examples:
	belowFreezing([33, 30, 32, 37, 44, 31, 41]) → 3
	belowFreezing([-7, -3, 19, 35, 30])  → 4
	belowFreezing([]) → 0
    */
	public int belowFreezing(int[] dailyHighs) {
        int count = 0;

        for (int temp : dailyHighs){
            if (temp <= 32){
                count++;
            }
        }
		return count;
        /*In this code, the belowFreezing method takes an array temperatures representing the high temperatures forecast. It iterates through each temperature using a for loop and counts the number of days where the temperature is at or below freezing (32°F). Finally, it returns the count. The main method demonstrates the usage of this belowFreezing method with different forecast arrays.*/
	}

    /*
    GaleForce also needs to determine the hottest day when given an upcoming forecast.

    Given an array of high temperatures, determine the hottest temperature.

    Note: The array of high temperatures is guaranteed to have at least one
    element.

    Examples:
	hottestDay([81, 93, 94, 105, 99, 95, 101, 90, 89, 92]) → 105
	hottestDay([23, 24] → 24
	hottestDay([34, 33] → 34
	hottestDay([55]) → 55
    */
    public int hottestDay(int[] dailyHighs) {
        int hottest = dailyHighs[0]; //initialize the hottest temp with the first element

        for (int i = 1; i < dailyHighs.length; i++){
            if (dailyHighs[i] > hottest){
                hottest = dailyHighs[i];
            }
        }
        return hottest;
        /*In this code, the hottestDay method takes an array temperatures representing the high temperatures forecast. It initializes the hottest temperature with the first element of the array and then iterates through the remaining elements using a for loop to find the highest temperature. Finally, it returns the hottest temperature. The main method demonstrates the usage of this hottestDay method with different forecast arrays.*/
    }

    /*
    GaleForce discovered an equipment malfunction. Every other reading, starting with the first,
    was off by 2 degrees Fahrenheit (°F).

    Given an array of Fahrenheit temperatures, fix each of the incorrect readings by adding
    2 degrees to its current value.

    Examples:
	fixTemperatures([33, 30, 32, 37, 44, 31, 41]) → [35, 30, 34, 37, 46, 31, 43]
	fixTemperatures([-7, -33, 19, 35]) → [-5, -33, 21, 35]
	fixTemperatures([-1, 0, 1] → [1, 0, 3]
    fixTemperatures([-1] → [1]
	fixTemperatures([]) → []
     */
    public int[] fixTemperatures(int[] temperatures) {
        for (int i =0; i < temperatures.length; i += 2){
            temperatures[i] += 2;
        }
        return temperatures;
        /*In this code, the fixTemperatures method takes an array temperatures representing the Fahrenheit temperatures readings. It iterates through the array using a for loop, starting from index 0 and incrementing by 2 each time to reach every other reading. For each iteration, it adds 2 degrees to the temperature. Finally, it returns the modified array. The main method demonstrates the usage of this fixTemperatures method with different temperature arrays.*/
    }
}
