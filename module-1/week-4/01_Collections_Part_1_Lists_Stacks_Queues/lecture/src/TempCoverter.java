public class TempCoverter {
    public static final int FREEZING = 32;
    public static final double C_F_RATIO = 1.8;

    public double convertToFahrenheit(double celsius) {
        return ((celsius * C_F_RATIO) + FREEZING);
    }

    public double convertToCelsius(double fahrenheit) {
        return ((fahrenheit / C_F_RATIO) - FREEZING);
    }
}
