package com.techelevator.teClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {

		//region Lists Basics
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		ArrayList<Integer> ints = new ArrayList<>(10);
		ArrayList<Integer> ints1 = new ArrayList<Integer>();
		List<Integer> ints3 = new ArrayList<>();
		ArrayList<Double> doubles = new ArrayList<>();
		ArrayList<Boolean> bools = new ArrayList<>();


		//endregion

		//region Boxing

		//Collections won't work with the primitive data types
		byte b = 0;
		short s = 1;
		int it = 2;
		long l = 3;
		float f = 3.5f;
		double d = 3.678d;
		char c = 'S';
		boolean bl = true;

		Byte bb = new Byte(b);
		Short ss = 4;
		Integer ii = 5;
		Long ll = 6l;
		Float ff = 3.5f;
		Double dd = 3.1415d;
		Character cc = 'S';
		Boolean bll = true;



		//Boxing
		int five = 5;
		ints.add(five);
		int another = ints.get(0);
		//endregion

		//region Array of Names
		ArrayList<String> names = new ArrayList<>();

		{
			names.add("Frodo");
			names.add("Sam");
			names.add("Pippin");
			names.add("Merry");
			names.add("gandalf");
			names.add("Aragorn");
			names.add("Boromir");
			names.add("Gimli");
			names.add("Legolas");

		}
		//endregion

		//region Lists are Ordered
		{
			System.out.println("####################");
			System.out.println("Lists are ordered");
			System.out.println("####################");

			//the elements will be returned in the same order they were added
			for (int i = 0; i < names.size(); i++) {
				System.out.println(names.get(i));
			}
		}
		//endregion

		//region Lists Allow Duplicates
		{
			System.out.println("####################");
			System.out.println("Lists allow duplicates");
			System.out.println("####################");

			names.add("Sam");

			for (int i = 0; i < names.size(); i++) {
				System.out.println(names.get(i));
			}
		}
		//endregion

		//region Insert in the middle
		{
			System.out.println("####################");
			System.out.println("Lists allow elements to be inserted in the middle");
			System.out.println("####################");

			names.add(2, "David");

			for (int i = 0; i < names.size(); i++) {
				System.out.println(names.get(i));
			}
		}
		//endregion

		//region Remove by Index
		{
			System.out.println("####################");
			System.out.println("Lists allow elements to be removed by index");
			System.out.println("####################");

			names.remove(2);

			for (int i = 0; i < names.size(); i++) {
				System.out.println(names.get(i));
			}
		}
		//endregion

		//region Searchable
		{
			System.out.println("####################");
			System.out.println("Find out if something is already in the List");
			System.out.println("####################");

			boolean inList = names.contains("Samwise");
			System.out.println("Samwise is in the list of names: " + inList);
		}
		//endregion

		//region indexOf
		{
			System.out.println("####################");
			System.out.println("Find index of item in List");
			System.out.println("####################");

			int indexOfGandalf = names.indexOf("gandalf");
			System.out.println("Gandalf is located at index: " + indexOfGandalf);
		}
		//endregion

		//region toArray
		{
			System.out.println("####################");
			System.out.println("Lists can be turned into an array");
			System.out.println("####################");

			String[] namesArray = names.toArray(new String[0]);


			for (int i = 0; i < namesArray.length; i++) {
				System.out.println(namesArray[i]);
			}
		}

		//endregion

		//region Sorting
		{
			System.out.println("####################");
			System.out.println("Lists can be sorted");
			System.out.println("####################");

			Collections.sort(names); //Sort() modifies the original list, doesn't require assignment
			for (int i = 0; i < names.size(); i++) {
				System.out.println(names.get(i));
			}
		}
		//endregion

		//region Reversing
		{
			System.out.println("####################");
			System.out.println("Lists can be reversed too");
			System.out.println("####################");

			Collections.reverse(names); //Reverse() modifies the original list, doesn't require assignment
			for (int i = 0; i < names.size(); i++) {
				System.out.println(names.get(i));
			}
		}
		//endregion

		//region forEach
		{
			System.out.println("####################");
			System.out.println("       FOREACH");
			System.out.println("####################");
			System.out.println();

			// Let's loop through names again, but this time using a for-each loop
			// for each name in names

			for (int i = 0; i < names.size(); i++) {
				String xyz = names.get(i);
				System.out.println(xyz);
			}

			for (String xyz : names) {
				System.out.println(xyz);
			}

			String [] dogs = { "Sport", "Snack", "Jumbo"};

			//Convert array of strings to ArrayList<String>
			ArrayList<String> dogsa = new ArrayList<>(List.of(dogs));
			ArrayList<String> moreDogs = new ArrayList<String>(Arrays.asList(dogs));

			//Convert ArrayList<String> to array of strings String[]
			String[] data = moreDogs.toArray(new String[0]);


			//Loop and add to another list
			for(String dog : dogs) {
				dogsa.add(dog);
			}

			//Loop and add to myself
			for (String xyz : names) {
				names.add("Joe");
				System.out.println(xyz);
			}
		}
		//endregion

		//region Packages
		ArrayList<Integer> direct = new ArrayList<>(10);
		java.util.ArrayList<Integer> pack = new ArrayList<>(10);
		//endregion
	}
}
