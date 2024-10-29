package com.techelevator.temp;
import java.util.ArrayList;
import java.util.List;

public class TempConverter {
    private static final int FREEZING = 32;
    private static final double C_F_RATIO = 1.8;

    private List<String> history = new ArrayList<>();

    int numHistoryEntries() {
        return history.size();
    }

    public void clearHistory() {
        history.clear();
    }

    boolean hasTemperature(Double temp) {

        for(String h : history)
            if(h.toLowerCase().contains(String.format("%.2f",temp)))
                return true;

        return false;
    }

    public double convertToFahrenheit(double celsius) {
        double fahrenheit = ((celsius * C_F_RATIO) + FREEZING);

       // if(history.size() == 0)
        //dfdf


            history.add(String.format("%.2f C => %.2f F",celsius,fahrenheit));
        return fahrenheit;
    }

    public double convertToCelsius(double fahrenheit) {
        double celsius = ((fahrenheit / C_F_RATIO) - FREEZING);
       history.add(String.format("%.2f F => %.2f C",fahrenheit, celsius));
        return celsius;
    }
}


