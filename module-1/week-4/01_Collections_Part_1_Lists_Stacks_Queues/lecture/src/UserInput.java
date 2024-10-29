import java.util.Scanner;

public class UserInput {

    Scanner scanner = new Scanner(System.in);
    UserOutput output = new UserOutput();
    public String getConvesionType() {

        while(true) {
            output.promptForType();

            String type = scanner.nextLine();

            if (type.equals("t") || type.equals("T"))
                return type.toLowerCase();

            if (type.equals("l") || type.equals("L"))
                return type.toLowerCase();

            output.tellUserTheyAreWrong();
        }
    }

    public double getLength() {
        while(true) {
            output.promptForLength();

            String type = scanner.nextLine();
            Double from = Double.parseDouble(type);
            return from;
        }
    }

    public double getTemp() {
        while(true) {
            output.promptForTemp();

            String type = scanner.nextLine();
            double from = Double.parseDouble(type);
            return from;
        }
    }
}
