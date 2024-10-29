package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
	 array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
	 array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) {
		List<String> list = new ArrayList<>();
		for (String element : stringArray){
			list.add(element);
		}
		return list;
	}/*
In Java, the syntax List<String> list = new ArrayList<>(); represents the following concepts:
List Interface:
List is a part of the Java Collections Framework, specifically an interface that represents an ordered collection or a
sequence of elements. This interface allows operations like adding, removing, accessing, and iterating over elements.
String Type:
The angle brackets <String> indicate that this list will contain elements of the String type. This is known as generics,
enabling type-safe collections in Java.
ArrayList Implementation: ArrayList is one of the most commonly used implementations of the List interface. It is a
resizable array, meaning its  size can change dynamically as elements are added or removed.
Instantiation with ArrayList: 'new ArrayList<>()' creates a new instance of ArrayList. The diamond operator <>
(introduced in Java 7) infers the type parameter from the context, so there's no need to explicitly write <String> again
after new ArrayList. This simplifies the code while keeping it type-safe.
Combining all of the above, the code snippet creates an empty list that can store String objects. It initializes this
list with an 'ArrayList' implementation, allowing for a flexible and resizable list. You can then add, remove, or
manipulate string elements in this list as needed./*

	 Given a list of Strings, return an array containing the same Strings in the same order
	 list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
	 list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
	 list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) {
		String[] array = new String[stringList.size()];
		for (int i = 0; i < stringList.size(); i++){
			array[i] = stringList.get(i);//for each loop
		} return array;
	}
/* The code snippet String[] array = new String[stringList.size()]; represents the following:
String Array Initialization:
String[] array declares a variable named array that is an array of String type. This indicates that the variable array
will contain multiple elements, all of which must be strings.
Array Length: stringList.size() retrieves the size (i.e., the number of elements) of a list named stringList. This list
must be  defined elsewhere in the code and can be of any implementation that extends the List interface, such as ArrayList.
Creating a New String Array: new String[stringList.size()] creates a new array of strings with a length equal to the
size of stringList. This means  that the newly created array has a fixed length, and it's initialized with default
values (null for a string array).
Putting it all together, this snippet creates a new array of strings with a length equal to the number of elements in
stringList. You can then use this array to store or manipulate the corresponding data from the list, perform operations,
or prepare for other tasks like sorting or further transformations.*/

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) {
		List<String> resultList = new ArrayList<>();
		for (String word : stringArray){
			if (word.length() != 4){
				resultList.add(word);
			}
		}
		return resultList;
	}
	/* The statement resultList.add(word); in Java means that you are adding a variable word to a collection named
resultList. Let's break it down to understand what this typically implies:
resultList: This represents a collection that supports adding elements. It is most likely an instance of a class that
implements the List interface, such as ArrayList, LinkedList, etc.
word: This variable represents an item to be added to the list. It could be of any data type, but in many cases, it is
a String.
add() Method: The add() method is used to insert an element at the end of the list. If the list has sufficient capacity,
the operation completes; otherwise, the list expands to accommodate new elements (for resizable lists like ArrayList).
Given these points, resultList.add(word); typically indicates that you are appending word to the end of resultList. This
operation is common when building a list of elements, such as when gathering results, constructing a data structure, or
accumulating items from a loop or another process. */

	/*
	 Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
	 arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
	 arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
	 arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) {
		List<Double> resultList = new ArrayList<>();
		for (int num : intArray){
			resultList.add((double) num/2);
		}
		return resultList;
	}

	/*
	 Given a List of Integers, return the largest value.
	 findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
	 findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
	 findLargest( [-2, -6, -8] ) -> -2
	 */
	public Integer findLargest(List<Integer> integerList) {
		int max = Integer.MIN_VALUE;
		for (int num : integerList){
			if (num > max){
				max = num;
			}
		}
		return max;
	}

	/*
	 Given an array of Integers, return a List of Integers containing just the odd values.
	 oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
	 oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
	 oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) {
		List<Integer> resultList = new ArrayList<>();
		for (int num : integerArray) {
			if (num % 2 != 0) {
				resultList.add(num);
			}
		}
		return resultList;
	}/*
Let's break down this code snippet to understand what it's doing. Here's a step-by-step explanation:
Defining a Method: The first line public List<Integer> oddOnly(Integer[] integerArray) defines a method named oddOnly.
This method takes an array of integers (integerArray) as its parameter and returns a list of integers (List<Integer>).
Creating an Empty List: List<Integer> resultList = new ArrayList<>(); This line creates a new empty list named resultList
that will contain integers. The list is an instance of ArrayList, a common type of list in Java. Initially, the list is empty.
Iterating Through the Array: for (int num : integerArray) { This line begins a loop that goes through each element in the
input array integerArray. The variable num represents the current element in the array as the loop runs.
Checking for Odd Numbers: if (num % 2 != 0) { This line checks whether the current number num is odd. The % operator is
used to find the remainder when num is divided by 2. If the remainder is not zero (!= 0), then the number is odd.
Adding Odd Numbers to the List: resultList.add(num); If the condition in the previous step is true (meaning num is odd),
this line adds num to the resultList. The add() method appends the value to the end of the list.
Returning the Resulting List: return resultList;After the loop has checked every element in the array, this line returns
the resultList containing all the odd numbers from the input array.
Summary: The oddOnly method takes an array of integers as input. It creates an empty list (resultList), then loops
through each integer in the input array. If an integer is odd (i.e., it leaves a remainder when divided by 2), the
method adds it to resultList. At the end of the loop, the method returns resultList, which now contains only the odd
numbers from the original array. */

	/*
	 Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 9, 44, 2, 88, 9], 9) -> true
	 */
	public boolean foundIntTwice(List<Integer> integerList, int intToFind) {
		int count = 0;
		for (int num : integerList){
			if (num == intToFind){
				count++;
				if (count >=2){
					return true;
				}
			}
		}
		return false;
	}

	/*
	Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
	must be replaced by the String "Fizz", any multiple of 5 must be replaced by the String "Buzz",
	and any multiple of both 3 and 5 must be replaced by the String "FizzBuzz."
	** INTERVIEW QUESTION **

	fizzBuzzList( {1, 2, 3} )  ->  ["1", "2", "Fizz"]
	fizzBuzzList( {4, 5, 6} )  ->  ["4", "Buzz", "Fizz"]
	fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  ["7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]

	HINT: To convert an Integer x to a String, you can use x.toString() in your code. For example, if x = 1, then x.toString() returns "1."
	 */
	public List<String> fizzBuzzList(Integer[] integerArray) {
		List<String> resultList = new ArrayList<>();
		for (int num : integerArray){
			if (num % 3 == 0 && num % 5 == 0){
				resultList.add("FizzBuzz");
			} else if (num % 3 == 0) {
				resultList.add("Fizz");
			} else if (num % 5 == 0) {
				resultList.add("Buzz");
			}else {
				resultList.add(String.valueOf(num));
			}
		}
		return resultList;
	}

	/*
	 Given two lists of Integers, interleave them beginning with the first element in the first list followed
	 by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
	 Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
	 list to the new list before returning it.
	 interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
     interleaveLists( [7, 1, 3], [2, 5, 7, 9] )  ->  [7, 2, 1, 5, 3, 7, 9]
     interleaveLists( [1, 2, 5, 8, 10], [4, 5, 6] )  ->  [1, 4, 2, 5, 5, 6, 8, 10]
	 */
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {
		List<Integer> result = new ArrayList<>();
		int index1 = 0, index2 = 0;

		while	(index1 < listOne.size() || index2 < listTwo.size()){
			if ( index1 < listOne.size()){
				result.add(listOne.get(index1));
				index1++;
			}
			if (index2 < listTwo.size()){
				result.add(listTwo.get(index2));
				index2++;
			}
		}
		return result;
		/*
This code defines a method interleaveLists that takes two lists of integers (listOne and listTwo) as input and
returns a new list. The returned list contains elements from both input lists, interleaved (alternating from each list),
until all elements from both lists are added.
Code Breakdown
Method Definition: public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo)
This line defines a method named interleaveLists. It accepts two lists of integers and returns a list of integers.
Creating a Result List: List<Integer> result = new ArrayList<>(); This creates a new, empty list called result to store
the interleaved elements.
Index Variables: int index1 = 0, index2 = 0; These variables, index1 and index2, are used to track the current position
in listOne and listTwo, respectively. Both are initialized to 0, which indicates the start of the lists.
Loop to Interleave the Lists: while (index1 < listOne.size() || index2 < listTwo.size()) { This loop continues as long
as there's at least one item left in either listOne or listTwo.
Adding Elements from List One: if (index1 < listOne.size()) { If index1 is less than the size of listOne, there's an
element to add. The condition ensures that we don't go beyond the end of the list.
result.add(listOne.get(index1)); This line gets the current element from listOne (using index1) and adds it to the result list.
index1++; After adding the element from listOne, index1 is incremented by 1 to move to the next position.
Adding Elements from List Two: The same pattern applies to listTwo with similar logic. If index2 is less than the size
of listTwo, the current element is added to result, and index2 is incremented.
Returning the Result List: return result; Once the loop has finished, this line returns the result list, which now
contains interleaved elements from listOne and listTwo.
Example Usage Let's consider two lists: listOne = [1, 3, 5] and listTwo = [2, 4, 6]. This code interleaves these two
lists, resulting in [1, 2, 3, 4, 5, 6]. If one list is longer, the remaining elements from the longer list are appended at the end.
		 */
	}

}
