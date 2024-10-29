package com.techelevator;
import java.util.Scanner;

public class LinearConvert {
	public static final	double Meters_to_Feet = 3.28;
	public static final double Feet_to_Meters = .3;

	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);

			while(true){
				System.out.print("Enter the Length: ");
				double length = scanner.nextDouble();

				System.out.print("Is the measurment in meters (m) or feet (f)? ");
				String unit = scanner.next();

				if (unit.equalsIgnoreCase("m")) {
					double feet = convertMetersToFeet(length);
					System.out.printf("%.2f meters is approx. %.0f feet.\n", length, feet);
				} else if (unit.equalsIgnoreCase("f")){
					double meters = convertFeetToMeters(length);
					System.out.printf("%.2f feet is approx. %.0f meters.\n", length, meters);
				}else{
					System.out.println("Invalid unit. Please enter 'm' for meters or 'f' for feet.");
				}
				System.out.print("Do you want to convert another length? (y/n): ");
				String answer = scanner.next();
				if (!answer.equalsIgnoreCase("y")){
					System.out.println("Exiting program...");
					break;
				}
			}
			scanner.close();
		}
		public static double convertMetersToFeet(double meters){
		return meters * Meters_to_Feet;
	}
		public static double convertFeetToMeters(double feet){
		return feet * Feet_to_Meters;
}
}	/*
In Java, System.out.printf is a method used to format and print text to the console. The format string "%.2f
meters is approx. %.0f feet.\n" specifies how the output should be formatted.

Here's what each part of the format string means:

%.2f: This part specifies a floating-point number (f) with two decimal places (.2). The %f is a placeholder for
a floating-point number, and the .2 indicates that the number should be rounded to two decimal places.

" meters is approx. ": This part is a static string that will be printed exactly as it is, without any modification.

%.0f: Similar to the first part, this specifies a floating-point number (f), but with zero decimal places (.0).
This will round the number to the nearest whole number.

" feet.\n": This is another static string that will be printed exactly as it is, followed by a newline character (\n)
to move to the next line.

In the context of your question, System.out.printf("%.2f meters is approx. %.0f feet.\n", length, feet); will print the value of length
(a double representing meters) with two decimal places, followed by the string "meters is approx.", and then the value of feet (a double representing feet) rounded to the nearest whole number, followed by the string "feet." and a newline character.*/
