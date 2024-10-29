package com.techelevator;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.print("Enter the number of Fibonacci numbers to display (or 'exit' to quite): ");
			String input = scanner.nextLine();
			//int n = scanner.nextInt();
			if (input.equalsIgnoreCase("exit")) {
				System.out.println("Exiting Program...");
				break;
			}
			try {
				int n = Integer.parseInt(input);
				System.out.println("Fibonacci sequence: ");
				printFibonacci(n);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid integer or 'exit'. ");
			}
		}

		scanner.close();
	}
public static void printFibonacci(int n){
		int n1 = 0, n2 = 1;

		System.out.print(n1 + " ");
		if (n > 1){
			System.out.print(n2 + " ");
		}
		int i =2;
			while (i < n){
			int n3 = n1 + n2;
			System.out.print(n3 + " ");
			n1 = n2;
			n2 = n3;
			i++;
		}
}
}
