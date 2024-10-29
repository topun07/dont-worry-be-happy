import java.util.ArrayList;

public class Bookkeeper {

    ArrayList<String> history = new ArrayList<>();
    public void addLengthConversion(double from, Double result) {
        history.add("Converted Length from " + from + " to " + result);
    }

    public void addTemperatureConversion(double from, Double result) {
        history.add("Converted Temperature from " + from + " to " + result);
    }

    public String getReport() {

        int numTemps = 0;
        int numLengths = 0;

        for(String histEntry : history) {
            if(histEntry.contains("Temperature"))
                numTemps++;
            else
                numLengths++;
        }

        return "There are " + numTemps  + " temperature conversions and " + numLengths + " Length conversions";
    }
}
