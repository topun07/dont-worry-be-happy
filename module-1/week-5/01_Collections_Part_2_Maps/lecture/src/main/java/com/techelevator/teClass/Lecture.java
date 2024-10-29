package com.techelevator.teClass;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Lecture {
	public static void main(String[] args) {

		String a;

		//region Stack (Page Navigation, Undo) LIFO

		{
			Stack<String> history = new Stack<String>();
			history.push("Press 1");
			System.out.println(history.size());
			history.push("Press 2");
			System.out.println(history.size());
			history.push("Press 3");
			System.out.println(history.size());
			a = history.pop();
			System.out.println(history.size() + " " + a);
			a = history.pop();
			System.out.println(history.size() + " " + a);
			a = history.pop();
			System.out.println(history.size() + " " + a);
		}
		//endregion

		//region Queue (ticketing queue) FIFO
		{
			Queue<String> messages = new LinkedList<String>();
			messages.add("Joe");
			System.out.println(messages.size());
			messages.add("Jim");
			System.out.println(messages.size());
			messages.add("Peter");
			System.out.println(messages.size());
			a = messages.remove();
			System.out.println(messages.size() + " " + a);
			a = messages.remove();
			System.out.println(messages.size() + " " + a);
			a = messages.remove();
			System.out.println(messages.size() + " " + a);
		}
		//endregion

		//region Set (track unique items)
		{
			HashSet<String> greetings = new HashSet<>();

			greetings.add("Hi");
			greetings.add("Hello");
			greetings.add("Hi There");
			greetings.add("hi");

			boolean has = greetings.contains("hi");

			greetings.remove("hi");

			has = greetings.contains("hi");

			greetings.add("hi");
			greetings.add("hi");

			System.out.println(greetings.size());
		}
		//endregion

		//region Shopping List
		{
			//Create aShopping list for
			//3 Breads, 2 Milks, 12 Eggs, 6 Oranges, 5 apples

			//region Shopping list using ArrayList
			ArrayList<Integer> shoppingList1 = new ArrayList<>();

			// Adding an item to a shopping List
			shoppingList1.add(3);
			shoppingList1.add(2);
			shoppingList1.add(12);
			shoppingList1.add(6);
			shoppingList1.add(5);
			//endregion

			//region Shopping list using Maps
			HashMap<String, Integer> shoppingList = new HashMap<String, Integer>();


			// Adding an item to a shopping List
			shoppingList.put("bread", 3);
			shoppingList.put("milk", 2);
			shoppingList.put("eggs", 12);
			shoppingList.put("oranges", 6);
			shoppingList.put("apples", 5);


			int numBreads = shoppingList.get("bread");
			int numOranges = shoppingList.get("oranges");
			//endregion
		}
		//endregion

		//region Maps
		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();
		// 1)  Declaring and initializing a Map

		HashMap<String, String> nameToZip = new HashMap<>();

		// 2)  Adding Map entries

		nameToZip.put("Mary Jones", "60100");
		nameToZip.put("Bob Smith", "60101");
		nameToZip.put("Jen Kraus", "60102");
		nameToZip.put("Bob Rich", "60110");

		// 3)  Retrieve values from a Map
		System.out.println("Retrieve values from the Map");
		System.out.println("Bob Rich lives in zipcode: " + nameToZip.get("Bob Rich"));
		System.out.println("Bob Smith lives in zipcode: " + nameToZip.get("Bob Smith"));
		System.out.println("Mary Jones lives in zipcode: " + nameToZip.get("Mary Jones"));
		System.out.println("Jen Kraus lives in zipcode: " + nameToZip.get("Jen Kraus"));

		// 4)  Retrieve just the Keys (Key Set)
		System.out.println("\nLet's get just the Keys (Key Set):");
		Set<String> nameToZipKeys = nameToZip.keySet();
		for (String keyVal : nameToZipKeys) {
			System.out.println("This is the key for: " + keyVal);
		}

		// 5)  Leverage the access to the Key Set, to extract the keys
		//     and use the keys to extract Values
		System.out.println("\nLeverage the access to the Key Set to " +
				" extract the Keys and use them to extract the Values");
		for (String keyVal : nameToZipKeys) {
			System.out.println(keyVal + " lives in zipcode: " + nameToZip.get(keyVal));
		}

		// 6)  Updating Key Values
		System.out.println("\nUpdating Key Values");
		nameToZip.put("Bob Smith", "99999");
		for (String keyVal : nameToZipKeys) {
			System.out.println(keyVal + " lives in zipcode: " + nameToZip.get(keyVal));
		}

		// 7)  Checking for Key existence
		System.out.println("\nChecking for Key existence");
		System.out.println("Does Jen Kraus have an entry into the Map? " +
				nameToZip.containsKey("Jen Kraus"));
		System.out.println("Does George Foreman have an entry into the Map? " +
				nameToZip.containsKey("George Foreman"));

		// 8)  Removing a Entry");
		System.out.println("\nRemoving an Entry");
		System.out.println("I have removed: " + nameToZip.remove("Bob Jones") +
				" from the Map.");
		System.out.println("I have removed zipcode: " + nameToZip.remove("Bob Smith") +
				" from the Map.\n");
		for (String keyVal : nameToZipKeys) {
			System.out.println(keyVal + " lives in zipcode: " + nameToZip.get(keyVal));
		}

		// 9)  Scanner prompting for user to input keyToRemove is replaced by
		// hard code below to save lecture time
		System.out.println("\nRemove Bob Smith");
		String keyToRemove = new String("Bob Rich");  // String ketToRemove = "Bob Smith";
		String valRemoved = nameToZip.remove(keyToRemove);
		System.out.println("I have removed zipcode: " + valRemoved +
				" associated with " + keyToRemove);

		// 10)  Restore Key that was removed, Scanner prompting for user to select
		// true or false (yes or no) is replaced by hard code to save lecture time
		System.out.println("\nRestore Bob Smith");
		boolean areYouSure = false;
		if (!areYouSure) {
			System.out.println("Restoring " + keyToRemove + ": " + valRemoved);
			nameToZip.put(keyToRemove, valRemoved);
		}
		System.out.println();
		for (String keyVal : nameToZipKeys) {
			System.out.println(keyVal + " lives in zipcode: " + nameToZip.get(keyVal));
		}

		// 11)  Iterate through entire Map entries
		System.out.println("\nLet's iterate over the Map entries");
		for (Map.Entry<String, String> nameZipEntry : nameToZip.entrySet()) {
			System.out.println(nameZipEntry);
		}
		//endregion
	}
}
