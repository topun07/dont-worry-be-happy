package com.techelevator;
import java.util.Scanner;
public class DecimalToBinary {
	public static String decimalToBinary(int decimal){ /* defines a static method named decimalToBinary,
														  public - access modifier. specifies that the method can be accessed from anywhere.
														  static - keyword in java used to create methods and variables that belong to the class*/

		StringBuilder binary = new StringBuilder(); /* In Java, StringBuilder is a class that provides a way to create mutable (modifiable) strings.
													   It allows you to efficiently build strings by appending or inserting characters without creating new String objects each time.
													   The line StringBuilder binary = new StringBuilder(); creates a new StringBuilder object named binary.
													   This object is used to construct a string that represents a binary number. The StringBuilder()
													   constructor initializes the StringBuilder object with an empty sequence of characters.
													   You can then use methods like append() to add characters to the StringBuilder object,
													   and toString() to convert the StringBuilder object to a String when you need the final result.*/

		while (decimal > 0){
			int remainder = decimal % 2;
			binary.insert(0, remainder); /* binary is a StringBuilder object that specifies an offset position. this line inserts the string "remainder"
												  integer at the beginning of StringBuilder shifting any existing characters to the right*/
			decimal /=2; //shorthand for decimal = decimal/2
		}
		//If the input number is 0, return "0" as its binary representation
		if (binary.length() == 0){
			binary.append(0); // adds character "0" to the end of content
		}
		return binary.toString();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Enter decimal integers separated by spaces (or type 'exit' to quit):  ");
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("exit")) {
				System.out.println("Exiting program...");
				break;
			}
			//}

			//System.out.print("Enter decimal integers seperated by spaces: ");
			//String input = scanner.nextLine();

			String[] numbers = input.split(" ");
			System.out.println("Decimal\tBinary");

			for (String number : numbers) {
				try {
					int decimal = Integer.parseInt(number);
					String binary = decimalToBinary(decimal);
					System.out.println(decimal + "\t" + binary);
				} catch (NumberFormatException e) {
					System.out.println("invalid input: \"" + number + "\"");
				}
				//int decimal = Integer.parseInt(number);
				//String binary = decimalToBinary(decimal);
				//System.out.println(decimal + "\t" + binary);
			}

			//scanner.close();
		}
	}
}