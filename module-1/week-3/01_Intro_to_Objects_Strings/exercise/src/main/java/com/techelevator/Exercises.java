package com.techelevator;

public class Exercises {
	/*
	 Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
	 helloName("Bob") → "Hello Bob!"
	 helloName("Alice") → "Hello Alice!"
	 helloName("X") → "Hello X!"
	 */
	public String helloName(String name) {
		String strings = new String(name);
		return "Hello " + strings + "!";
		//return null;
	}

	/*
	 Given two strings, a and b, return the result of putting them together in the order abba,
	 e.g. "Hi" and "Bye" returns "HiByeByeHi".
	 makeAbba("Hi", "Bye") → "HiByeByeHi"
	 makeAbba("Yo", "Alice") → "YoAliceAliceYo"
	 makeAbba("What", "Up") → "WhatUpUpWhat"
	 */
	public String makeAbba(String a, String b) {
		return a + b + b + a;
	}

	/*
	 The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example,
	 the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the
	 HTML string with tags around the word, e.g. "<i>Yay</i>".
	 makeTags("i", "Yay") → "<i>Yay</i>"
	 makeTags("i", "Hello") → "<i>Hello</i>"
	 makeTags("cite", "Yay") → "<cite>Yay</cite>"
	 */
	public String makeTags(String tag, String word) {
		String tags = new String(tag);
		String words = new String(word);
		return '<' + tags + '>' + words + '<' + '/' + tags + '>';
	}

	/*
	 Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the
	 middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting
	 at index i and going up to but not including index j.
	 makeOutWord("<<>>", "Yay") → "<<Yay>>"
	 makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
	 makeOutWord("[[]]", "word") → "[[word]]"
	 */
	public String makeOutWord(String out, String word) {
		String start = out.substring(0 ,2);
		String end = out.substring(2);

		return start + word + end;
	}

	/*
	 Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string
	 length will be at least 2.
	 extraEnd("Hello") → "lololo"
	 extraEnd("ab") → "ababab"
	 extraEnd("Hi") → "HiHiHi"
	 */
	public String extraEnd(String str) {
		String strings = new String(str);
		String lastTwoChars = str.substring(str.length() - 2);

		return lastTwoChars + lastTwoChars + lastTwoChars;
	}

	/*
	 Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
	 string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
	 yields the empty string "". Note that str.length() returns the length of a string.
	 firstTwo("Hello") → "He"
	 firstTwo("abcdefg") → "ab"
	 firstTwo("ab") → "ab"
	 */
	public String firstTwo(String str) {
		String strings = new String(str);
		if (str.length() < 2){
			return str;
		} else {
			return str.substring(0, 2);
		}
	}

	/*
	 Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
	 firstHalf("WooHoo") → "Woo"
	 firstHalf("HelloThere") → "Hello"
	 firstHalf("abcdef") → "abc"
	 */
	public String firstHalf(String str) {
		int halfLength = str.length() / 2;

		return str.substring(0, halfLength);
	}

	/*
	 Given a string, return a version without the first and last char, so "Hello" yields "ell".
	 The string length will be at least 2.
	 withoutEnd("Hello") → "ell"
	 withoutEnd("java") → "av"
	 withoutEnd("coding") → "odin"
	 */
	public String withoutEnd(String str) {

		return str.substring(1, str.length() - 1);
	}

	/*
	 Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string
	 on the outside and the longer string on the inside. The strings will not be the same length, but
	 they may be empty (length 0).
	 comboString("Hello", "hi") → "hiHellohi"
	 comboString("hi", "Hello") → "hiHellohi"
	 comboString("aaa", "b") → "baaab"
	 */
	public String comboString(String a, String b) {
		if (a.length() < b.length()){
			return a + b + a;
		}else {
			return b + a + b;
		}
	}

	/*
	 Given 2 strings, return their concatenation, except omit the first char of each. The strings will
	 be at least length 1.
	 nonStart("Hello", "There") → "ellohere"
	 nonStart("java", "code") → "avaode"
	 nonStart("shotl", "java") → "hotlava"
	 */
	public String nonStart(String a, String b) {
		return a.substring(1) + b.substring(1);
	}

	/*
	 Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end.
	 The string length will be at least 2.
	 left2("Hello") → "lloHe"
	 left2("java") → "vaja"
	 left2("Hi") → "Hi"
	 */
	public String left2(String str) {
		return str.substring(2) + str.substring(0, 2);
	}

	/*
	 Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start.
	 The string length will be at least 2.
	 right2("Hello") → "loHel"
	 right2("java") → "vaja"
	 right2("Hi") → "Hi"
	 */
	public String right2(String str) {
		int length = str.length();
		return str.substring(length - 2) + str.substring(0, length - 2);
	}

	/*
	 Given a string, return a string length 1 from its front, unless front is false, in which case
	 return a string length 1 from its back. The string will be non-empty.
	 theEnd("Hello", true) → "H"
	 theEnd("Hello", false) → "o"
	 theEnd("oh", true) → "o"
	 */
	public String theEnd(String str, boolean front) {
		if (front){
			return str.substring(0, 1);
		} else {
			return str.substring(str.length() - 1);
		}
	}

	/*
	 Given a string, return a version without both the first and last char of the string. The string
	 may be any length, including 0.
	 withoutEnd2("Hello") → "ell"
	 withoutEnd2("abc") → "b"
	 withoutEnd2("ab") → ""
	 */
	public String withoutEnd2(String str) {
		if (str.length() <= 2){
			return "";
		}else {
			return str.substring(1, str.length() - 1);
		}
	}

	/*
	 Given a string of even length, return a string made of the middle two chars, so the string "string"
	 yields "ri". The string length will be at least 2.
	 middleTwo("string") → "ri"
	 middleTwo("code") → "od"
	 middleTwo("Practice") → "ct"
	 */
	public String middleTwo(String str) {
		int middleIndex = str.length() / 2;

		return str.substring(middleIndex -1, middleIndex + 1);
	}

	/*
	 Given a string, return true if it ends in "ly".
	 endsLy("oddly") → true
	 endsLy("y") → false
	 endsLy("oddy") → false
	 */
	public boolean endsLy(String str) {
		return str.endsWith("ly");
	}

	/*
	 Given a string and an int n, return a string made of the first and last n chars from the string. The
	 string length will be at least n.
	 nTwice("Hello", 2) → "Helo"
	 nTwice("Chocolate", 3) → "Choate"
	 nTwice("Chocolate", 1) → "Ce"
	 */
	public String nTwice(String str, int n) {
		String firstNChars = str.substring(0, n);
		String lastNChars = str.substring(str.length() - n);
		return firstNChars + lastNChars;
	}

	/*
	 Given a string and an int n, return a string that starts at n and has a length of 2. Note that n may or may not be a valid
	 location in the string. If n is too low or too high to define a string of length 2, return the string's first 2 characters.
	 The string length will be at least 2.
	 twoChar("java", 0) → "ja"
	 twoChar("java", 2) → "va"
	 twoChar("java", 3) → "ja"
	 */
	public String twoChar(String str, int n) {
		if (n < 0 || n > str.length() - 2){
			return str.substring(0, 2);
		}else {

		} return str.substring(n,n + 2);
	}

	/*
	 Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and".
	 The string length will be at least 3.
	 middleThree("Candy") → "and"
	 middleThree("and") → "and"
	 middleThree("solving") → "lvi"
	 */
	public String middleThree(String str) {
		int middleIndex = str.length() / 2;
		return str.substring(middleIndex - 1, middleIndex + 2);
	}

	/*
	 Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with
	 "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals()
	 to compare 2 strings.
	 hasBad("badxx") → true
	 hasBad("xbadxx") → true
	 hasBad("xxbadxx") → false
	 */
	public boolean hasBad(String str) {
		if (str.length() >= 3 && (str.substring(0, 3).equals("bad") || (str.length() >= 4 && str.substring(1, 4).equals("bad")))) {
			return true;
		}
		return false;
	}

	/*
	 Given a string and a non-negative int n, return a larger string that is n copies of the original string.
	 stringTimes("Hi", 2) → "HiHi"
	 stringTimes("Hi", 3) → "HiHiHi"
	 stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++){
			result.append(str);
		}
		return result.toString();
	}

	/*
	 Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or
	 whatever is there if the string is less than length 3. Return n copies of the front;
	 frontTimes("Chocolate", 2) → "ChoCho"
	 frontTimes("Chocolate", 3) → "ChoChoCho"
	 frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {
		StringBuilder result = new StringBuilder();
		String front = str.length() < 3 ? str : str.substring(0, 3);
		for (int i = 0; i < n; i++){
			result.append(front);
		}
		return result.toString();
	}
/* The code snippet defines a method that takes two inputs: a string (str) and a number (n). The method creates a new
string by repeating the first three characters of str a certain number of times, as specified by n.
Code Breakdown
Method Definition: public String frontTimes(String str, int n) This line defines a method called frontTimes that returns
a string (String). It takes two parameters: str (a string) and n (an integer indicating how many times to repeat).
Using StringBuilder: StringBuilder result = new StringBuilder(); This line creates a StringBuilder named result. A
StringBuilder allows you to build or construct strings efficiently, especially when repeatedly appending text.
Getting the First Three Characters: String front = str.length() < 3 ? str : str.substring(0, 3);
This line checks the length of str. If str has fewer than three characters, front is set to the entire string. Otherwise,
front gets the first three characters of str using str.substring(0, 3). This prepares the part of str to be repeated.
Repeating the front String: for (int i = 0; i < n; i++) { This begins a loop that runs n times (from 0 to n - 1). The
loop counter i keeps track of the current iteration.
result.append(front); Inside the loop, this line appends (adds) the front string to result. Since the loop runs n times,
it adds front to result each time.
Returning the Final String: return result.toString();
After the loop, this line converts the StringBuilder to a regular string and returns it. This final result contains the
front string repeated n times.
Example Let's say str = "hello" and n = 3. The front would be "hel" (the first three characters of "hello"). The loop
appends "hel" to result three times. The returned result would be "helhelhel".
If str has fewer than three characters (like "hi"), then the entire str is used. If str = "hi" and n = 2, the result
would be "hihi".
Overall, this code snippet creates a string by repeating a portion of the input string a specified number of times.
*/	/*

	 Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
	 countXX("abcxx") → 1
	 countXX("xxx") → 2
	 countXX("xxxx") → 3
	 */
	public int countXX(String str) {
		int count = 0;
		for (int i = 0; i < str.length() - 1; i++){
			if (str.substring(i, i + 2).equals("xx")){
				count++;
			}
		}
		return count;
	}

	/*
	 Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
	 doubleX("axxbb") → true
	 doubleX("axaxax") → false
	 doubleX("xxxxx") → true
	 */
	public boolean doubleX(String str) {
		int index = str.indexOf('x');
		if (index == -1 || index == str.length() - 1){
			return false;  //no occurance of 'x' or 'x' is the last character
		}
		return str.charAt(index + 1) == 'x'; //check if 'x' is immediatly followed by another 'x'
	}

	/*
	 Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
	 stringBits("Hello") → "Hlo"
	 stringBits("Hi") → "H"
	 stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i += 2){
			result.append(str.charAt(i));
		}
		return result.toString();
	}

	/*
	 Given a non-empty string like "Code" return a string like "CCoCodCode".
	 stringSplosion("Code") → "CCoCodCode"
	 stringSplosion("abc") → "aababc"
	 stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			result.append(str.substring(0, i + 1));
		} return result.toString();
	}

	/*
	 Given a string, return the count of the number of times that a substring length 2 appears in the string and
	 also as the last 2 chars of the string.

	 We don't count the end subString, so "hixxxhi" yields 1, but the subString may overlap a prior position by one.
	 For instance, "xxxx" has a count of 2: one pair at position 0, and the second at position 1. The third pair at
	 position 2 is the end subString, which we don't count.

	 last2("hixxhi") → 1
	 last2("xaxxaxaxx") → 1
	 last2("axxxaaxx") → 2
	 last2("xxxx") -> 2
	 */
	public int last2(String str) {
		if (str.length() < 2){
			return 0;
		}
		String end = str.substring(str.length() - 2);
		int count = 0;

		for (int i = 0;i < str.length() - 2; i++){
			if (str.substring(i, i + 2).equals(end)){
				count++;
			}
		}
		return count;
	}

	/*
	 Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end
	 should not be removed.
	 stringX("xxHxix") → "xHix"
	 stringX("abxxxcd") → "abcd"
	 stringX("xabxxxcdx") → "xabcdx"
	 */
	public String stringX(String str) {
		if (str.length() <= 2) {
			return str;
		}
		StringBuilder result = new StringBuilder().append(str.charAt(0));
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'x') {
				continue;
			}
			result.append(str.charAt(i));
		}
		result.append(str.charAt(str.length() - 1));

		return result.toString();
	}

	/*
	 Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
	 altPairs("kitten") → "kien"
	 altPairs("Chocolate") → "Chole"
	 altPairs("CodingHorror") → "Congrr"
	 */
	public String altPairs(String str) {
		StringBuilder result = new StringBuilder();
		int i = 0;

		while (i < str.length()){
			result.append(str.charAt(i));
			i++;

			if (i < str.length()){
				result.append(str.charAt(i));
			}i +=3;
		}
		return result.toString();
	}

	/*
	 Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed.
	 The "yak" strings will not overlap.
	 stringYak("yakpak") → "pak"
	 stringYak("pakyak") → "pak"
	 stringYak("yak123ya") → "123ya"
	 */
	public String stringYak(String str) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (i + 2 < str.length() && str.charAt(i) == 'y' && str.charAt(i + 2) == 'k') {
				i += 2;
			} else {
				result.append(str.charAt(i));
			}
		}
		return result.toString();
	}
	}


