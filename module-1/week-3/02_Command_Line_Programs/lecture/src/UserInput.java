import java.util.Locale;
import java.util.Scanner;

public class UserInput {

    Scanner scanner = new Scanner(System.in);
    UserOutput output = new UserOutput();
    public String getCOnvertionType() {

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

    public int getLength() {
        while(true) {
            output.promptForLength();

            String type = scanner.nextLine();
            int from = Integer.parseInt(type);
            return from;
        }
    }

    public int getTemp() {
        while(true) {
            output.promptForTemp();

            String type = scanner.nextLine();
            int from = Integer.parseInt(type);
            return from;
        }
    }
}
