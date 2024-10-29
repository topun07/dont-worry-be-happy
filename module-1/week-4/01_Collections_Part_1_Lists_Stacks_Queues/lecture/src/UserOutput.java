public class UserOutput {

    public void openForBusiness() {
        System.out.println("===== Convert Shop is Open for Business=====");
    }

    public void promptForType() {
        System.out.print("Please enter Conversion type. Use [T] for temp, ot [L} for length:");
    }

    public void tellUserTheyAreWrong() {
        System.out.println("Invalid type. Please use 't' or 'T'  for temp or 'l' or 'L' for length!");
    }

    public void promptForLength() {
        System.out.print("Please enter length in M:");
    }

    public void promptForTemp() {
        System.out.print("Please enter temp in F:");
    }

    public void displayTempResult(Double result) {
        System.out.println("Converting Temperature => The result is " + result + "C");
    }

    public void displayLengthResult(Double result) {
        System.out.println("Converting Length => The result is " + result + "Ft");
    }
}
