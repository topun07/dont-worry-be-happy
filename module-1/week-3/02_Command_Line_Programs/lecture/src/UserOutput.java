public class UserOutput {

    public void showIAmAtWork() {
        System.out.println("I am at work");
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
        System.out.println("The result is " + result + "C");
    }
}
