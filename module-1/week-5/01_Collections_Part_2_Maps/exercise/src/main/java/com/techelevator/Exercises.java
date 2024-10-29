package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" -> "Crash").
	 *
	 * The animal name should be case-insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") → "unknown"
	 * animalGroupName("walrus") → "unknown"
	 * animalGroupName("Rhino") → "Crash"
	 * animalGroupName("rhino") → "Crash"
	 * animalGroupName("elephants") → "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		Map<String, String> animalGroups = new HashMap<>();
		animalGroups.put("elephant", "Herd");
		animalGroups.put("rhino", "Crash");
		animalGroups.put("giraffe", "Tower");
		animalGroups.put("lion", "Pride");
		animalGroups.put("crow", "Murder");
		animalGroups.put("pigeon", "Kit");
		animalGroups.put("flamingo", "Pat");
		animalGroups.put("deer", "Herd");
		animalGroups.put("dog","Pack");
		animalGroups.put("crocodile", "Float");
		animalGroups.put("", "");
		animalGroups.put("null", "null");
		animalGroups.put("    ", "     ");

		// Convert the animal name to lowercase for case-insensitive comparison
		String lowercaseAnimalName = (animalName != null) ? animalName.toLowerCase() : "";
		// Retrieve the group name from the map
		String group = animalGroups.get(lowercaseAnimalName);
		// If the group is null or empty, return "unknown"
		return (group != null && !group.isEmpty()) ? group : "unknown";
	}
/*(group != null && !group.isEmpty()): This part is a ternary conditional operator (also known as the ternary operator
or the conditional operator). It has the following structure: condition ? value_if_true : value_if_false
group != null: This checks whether the group variable is not null. If it is not null, the condition evaluates to true.
!group.isEmpty(): This checks whether the group variable is not empty (i.e., it contains characters).
If it is not empty, the condition evaluates to true.
The entire expression evaluates to true if both conditions are true (i.e., group is not null and not empty), and false otherwise.
? group : "unknown": This part specifies the values to return based on the condition. If the condition is true,
it returns the value of group. Otherwise, it returns the string "unknown". So, in summary:
If group is not null and not empty, the expression returns the value of group. Otherwise, it returns the string "unknown".
This construct is commonly used to provide a default value when a variable might be null or empty. If group is valid
(not null and not empty), it returns that value; otherwise, it falls back to “unknown”. */

	/*
	 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case-insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("spaceship9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		Map<String, Double> itemDiscounts = new HashMap<>();
		itemDiscounts.put("kitchen4001", 0.20);
		itemDiscounts.put("garage1070", 0.15);
		itemDiscounts.put("livingroom", 0.10);
		itemDiscounts.put("kitchen6073", 0.40);
		itemDiscounts.put("bedroom3434", 0.60);
		itemDiscounts.put("bath0073", 0.15);

		//public static double getDiscountPercentage(String itemNumber){
			// Convert the item number to lowercase for case-insensitive comparison
			String lowercaseItemNumber = (itemNumber != null) ? itemNumber.toLowerCase() : "";

			// Retrieve the discount percentage from the map
			Double discount = itemDiscounts.get(lowercaseItemNumber);

			// If the discount is null (item not found), return 0.00
			return (discount != null) ? discount : 0.00;
	} /* (discount != null): This part checks whether the discount variable is not null. If discount is not null, the
	condition evaluates to true.
? discount : 0.00: This is the ternary conditional operator (also known as the ternary operator or the conditional
operator). It has the following structure:
condition ? value_if_true : value_if_false
If the condition (i.e., discount != null) is true, it returns the value of discount.
Otherwise (if the condition is false), it returns the value 0.00.
So, in summary: If discount is not null, the expression returns the value of discount.
Otherwise, it returns 0.00.
This construct is commonly used to provide a default value when a variable might be null. If discount is valid
(not null), it returns that value; otherwise, it falls back to 0.00.  */

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 * robPeterToPayPaul({"Peter": 101, "Paul": 500}) → {"Peter": 51, "Paul": 550}
	 * robPeterToPayPaul({"Peter": 0, "Paul": 500}) → {"Peter": 0, "Paul": 500}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		// Check if "Peter" has more than 0 money
		if (peterPaul.containsKey("Peter") && peterPaul.get("Peter") > 0) {
			// Check if "Paul" has less than $10
			if (peterPaul.containsKey("Paul") && peterPaul.get("Paul") < 1000) {
				int peterMoney = peterPaul.get("Peter");
				int paulMoney = peterPaul.get("Paul");

				// Transfer half of Peter's money to Paul
				int transferAmount = peterMoney / 2;
				peterPaul.put("Peter", peterMoney - transferAmount);
				peterPaul.put("Paul", paulMoney + transferAmount);
			}
		}
		return peterPaul;
	}


	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> money) {
		//check if peter and paul have enough money
		boolean peterHasEnough = money.containsKey("Peter") && money.get("Peter") >= 50;
		boolean paulHasEnough = money.containsKey("Paul") && money.get("Paul") >= 100;

		//check if both partners have enough money for the partnership to be funded
		boolean partnershipFunded = peterHasEnough && paulHasEnough;

		if (partnershipFunded){
			//calculate the contribution for peter and paul
			int peterContribution = money.get("Peter") / 4;
			int paulContribution = money.get("Paul") / 4;

			//update values in map
			money.put("Peter", money.get("Peter") - peterContribution);
			money.put("Paul", money.get("Paul") - paulContribution);
			money.put("PeterPaulPartnership", peterContribution + paulContribution);

		}
		return money;
	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> where, for every String in the array,
	 * there is an entry whose key is the first character of the string.
	 *
	 * The value of the entry is the last character of the String. If multiple Strings start with the same letter, then the
	 * value for that key should be the later String's last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["code", "bug", "cat"]) → {"b": "g", "c": "t"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> resultMap = new HashMap<>();

		// iterate through the array of words
		for (String word : words){
			//get the first character of the word
			String firstChar = String.valueOf(word.charAt(0));
			//get the last character of the word
			String lastChar = String.valueOf(word.charAt(word.length()-1));
			//update the value associated with the first character key
			resultMap.put(firstChar, lastChar);
		}
		return resultMap;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		// create a hashmap to stor the word counts
		Map<String, Integer> wordCounts = new HashMap<>();

		//iterate through the array of words
		for (String word : words){
			//if the word already exists in the map, increment its count
			//otherwise, add the word to the map with a count of 1
			wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
		}
		return wordCounts;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		//create a HashMap to store the number counts
		Map<Integer, Integer> numCounts = new HashMap<>();

		// iterate through the array of numbers
		for (int num : ints){
			//if the number already exists in the map, increment its count
			//otherwise, add the number to the map with a count of 1
			numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
		}
		return numCounts;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["apple", "banana", "apple", "carrot", "banana"]) → {"banana": true, "carrot": false, "apple": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		//create a hashmap to store the word occurences
		Map<String, Integer> wordCounts = new HashMap<>();/*Here, we create a new HashMap named wordCounts.
		This map will store the count of each word in the input array. */

		// populate the hashmap with word occurences
		for (String word : words){
			wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
		}
		// create a new hashmap to store word multiplicity
		Map<String, Boolean> wordMultiplicity = new HashMap<>(); /*Here, we create a new HashMap named wordMultiplicity.
		This map will store whether each word appears multiple times (true) or not (false).*/

		// populate the word multiplicity map based on word occurences
		for (String word : wordCounts.keySet()){
			wordMultiplicity.put(word, wordCounts.get(word) >= 2); /*This loop iterates over each unique word in the
			wordCounts map. For each word, it checks if its count is greater than or equal to 2. If it is, it adds
			the word to the wordMultiplicity map with a value of true, indicating that the word appears more than once.
			Otherwise, it adds the word with a value of false. */
		}
		return wordMultiplicity;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {
		//create a new hashmap to store the merged inventory
		Map<String, Integer> mergedInventory = new HashMap<>();

		//add all entries for the main warehouse to the merged inventory
		mergedInventory.putAll(mainWarehouse); /*We add all entries from the main warehouse to the merged inventory.*/

		//iterate through the entries of the remote wharehouse
		for (Map.Entry<String, Integer> entry : remoteWarehouse.entrySet()){
			String sku = entry.getKey();
			int quantity = entry.getValue();/*We iterate through the entries of the remote warehouse. For each entry,
			we check if the SKU exists in the merged inventory. If it does, we add the quantities from both warehouses
			and update the merged inventory with the combined quantity.*/

			// if the sku exists in the merged inventory with the combined quantity
			if (mergedInventory.containsKey(sku)){
				quantity += mergedInventory.get(sku);
			}

			//update the merged inventory with the combined quantity
			mergedInventory.put(sku, quantity);
		}
		return mergedInventory;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, its last2 count is the number of times that a subString length 2
	 * appears in the String and also as the last 2 chars of the String.
	 *
	 * We don't count the end subString, so "hixxxhi" has a last2 count of 1, but the subString may overlap a prior
	 * position by one.  For instance, "xxxx" has a count of 2: one pair at position 0, and the second at position 1.
	 * The third pair at position 2 is the end subString, which we don't count.
	 *
	 * Return a Map<String, Integer> where the keys are the Strings from the array and the values are the last2 counts.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		// Create a new HashMap to store the last2 counts
		Map<String, Integer> last2Counts = new HashMap<>();

		// Iterate through each word in the array
		for (String word : words) {
			// Calculate the last2 count for the current word
			int count = countLast2(word);
			// Add the word and its last2 count to the map
			last2Counts.put(word, count);
		} /*This method takes an array of strings (words) as input and returns a map where the keys are the
			strings from the array, and the values are the last2 counts.
			It iterates through each word in the array and calculates the last2 count for each word using the
			'countLast2' helper method.*/
		return last2Counts;
	}

	// Helper method to calculate the last2 count for a given word
	private int countLast2(String word) {
		if (word.length() < 2) {
			return 0;
		}

		// Get the substring of the last two characters
		String end = word.substring(word.length() - 2);
		int count = 0;

		// Iterate through the word except for the last two characters
		for (int i = 0; i < word.length() - 2; i++) {
			// Check if the substring of length 2 at position i matches the end substring
			if (word.substring(i, i + 2).equals(end)) {
				count++;
			}/* This method calculates the last2 count for a given word.
			It first checks if the word length is less than 2. If so, it returns 0.
			It then extracts the last two characters from the word and iterates through the word except for the last two
			characters. For each pair of characters in the word, it checks if it matches the end substring
			(last two characters). If it does, it increments the count.*/
		}

		return count;
	}

}
