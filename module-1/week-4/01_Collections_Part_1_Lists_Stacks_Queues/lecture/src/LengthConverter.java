public class LengthConverter {

    final double FEET_TO_METERS = .3048;
    final double METERS_TO_FEET = 3.2808399;

    public double convertToMeters(double feet) {
        return feet * FEET_TO_METERS;
    }
    public double convertToFeet(double meters) {
        return meters * METERS_TO_FEET;
    }
}
