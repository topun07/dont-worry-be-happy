package com.techelevator;
import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean repeat = true;
		while (repeat) {
			System.out.print("Enter the temperature: ");
			int temperature = scanner.nextInt();

			System.out.print("Enter the scale (C, F): ");
			String scale = scanner.next();

			if (scale.equals("C") || scale.equals("c")) {
				int fahrenheit = celsiusToFahrenheit(temperature);
				System.out.println(temperature + "C is approx " + fahrenheit + 'F');
			} else if (scale.equals("F") || scale.equals("f")) {
				int celsius = fahrenheitToCelsius(temperature);
				System.out.println(temperature + "F is approx" + celsius + 'C');
			} else {
				System.out.println("Invalid scale input.");
				continue;
			}

			System.out.print("Do you want to convert another temp? y/n? ");
			String choice = scanner.next();
			repeat = choice.equalsIgnoreCase("y");
		}
	scanner.close();
}
	public static int celsiusToFahrenheit(int celsius){
		return (int) Math.round(celsius * 9 / 5 + 32);
	}

	public static int fahrenheitToCelsius(int fahrenheit){
		return (int) Math.round((fahrenheit - 32)* 5 / 9);
	}
	}
