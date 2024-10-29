/*
1. **sumDouble** Given two int values, return their sum. Unless the two values are the 
    same, then return double their sum.

		sumDouble(1, 2) → 3
		sumDouble(3, 2) → 5
		sumDouble(2, 2) → 8

		function sumDouble(x, y) {
			// do logic here
			// return result;
			return x + y;
        }
*/

function sumDouble(x, y) {
    // Calculate the sum of x and y
    let sum = x + y;
    
    // If x and y are the same, return double the sum
    if (x === y) {
        return sum * 2;
    }
    
    // Otherwise, return the sum
    return sum;
}


/*
2. **hasTeen** We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
    Given 3 int values, return true if 1 or more of them are teen.

		hasTeen(13, 20, 10) → true
		hasTeen(20, 19, 10) → true
		hasTeen(20, 10, 13) → true
*/

function hasTeen(a, b, c) {
    // Check if any of the values is in the range 13..19 inclusive
    if ((a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19)) {
        return true;
    }
    // If none of them is in the "teen" range, return false
    return false;
}


/* 
3. **lastDigit** Given two non-negative int values, return true if they have the same 
    last digit, such as with 27 and 57.

		lastDigit(7, 17) → true
		lastDigit(6, 17) → false
		lastDigit(3, 113) → true
*/

function lastDigit(a, b) {
    // Get the last digit of both numbers using the modulo operator
    const lastDigitA = a % 10;
    const lastDigitB = b % 10;

    // Compare the last digits and return true if they are the same, false otherwise
    return lastDigitA === lastDigitB;
}


/*
4. **seeColor** Given a string, if the string begins with "red" or "blue" return that color 
    string, otherwise return the empty string.

		seeColor("redxx") → "red"
		seeColor("xxred") → ""
        seeColor("blueTimes") → "blue"
*/

function seeColor(str) {
    // Check if the string starts with "red"
    if (str.startsWith("red")) {
        return "red";
    }
    // Check if the string starts with "blue"
    if (str.startsWith("blue")) {
        return "blue";
    }
    // If neither, return the empty string
    return "";
}

/*
5. **oddOnly** Write a function that given an array of integer of any length, removes
    the even numbers, and returns a new array of just the the odd numbers.

		oddOnly([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]) → [1, 3, 5, 7, 9, 11];
		oddOnly([2, 4, 8, 32, 256]); → []
*/

function oddOnly(arr) {
    // Use the filter method to return only odd numbers
    return arr.filter(num => num % 2 !== 0);
}


/*
6. **frontAgain** Given a string, return true if the first 2 chars in the string also appear 
    at the end of the string, such as with "edited".

		frontAgain("edited") → true
		frontAgain("edit") → false
		frontAgain("ed") → true
*/

function frontAgain(str) {
    // Check if the string length is at least 2
    if (str.length < 2) {
        return false;
    }
    
    // Get the first 2 characters and the last 2 characters of the string
    const firstTwo = str.substring(0, 2);
    const lastTwo = str.substring(str.length - 2);
    
    // Return true if they are equal, otherwise false
    return firstTwo === lastTwo;
}


/*
7. **cigarParty** When squirrels get together for a party, they like to have cigars. 
A squirrel party is successful when the number of cigars is between 40 and 60, inclusive. 
Unless it is the weekend, in which case there is no upper bound on the number of cigars. 
Write a squirrel party function that return true if the party with the given values is successful, 
or false otherwise.

		cigarParty(30, false) → false
		cigarParty(50, false) → true
		cigarParty(70, true) → true
*/

function cigarParty(cigars, isWeekend) {
    // If it's the weekend, the number of cigars must be at least 40
    if (isWeekend) {
        return cigars >= 40;
    }
    
    // If it's not the weekend, the number of cigars must be between 40 and 60 inclusive
    return cigars >= 40 && cigars <= 60;
}


/*
8. **fizzBuzz** Given a number, return a value according to the following rules:
If the number is multiple of 3, return "Fizz."
If the number is a multiple of 5, return "Buzz." 
If the number is a multiple of both 3 and 5, return "FizzBuzz."
In all other cases return the original number. 

	fizzBuzz(3) → "Fizz"
	fizzBuzz(1) → 1
	fizzBuzz(10) → "Buzz"
	fizzBuzz(15) → "FizzBuzz"
	fizzBuzz(8) → 8
*/

function fizzBuzz(num) {
    // Check if the number is a multiple of both 3 and 5
    if (num % 3 === 0 && num % 5 === 0) {
        return "FizzBuzz";
    }
    // Check if the number is a multiple of 3
    if (num % 3 === 0) {
        return "Fizz";
    }
    // Check if the number is a multiple of 5
    if (num % 5 === 0) {
        return "Buzz";
    }
    // Otherwise, return the original number
    return num;
}

/*
9. **filterEvens** Write a function that filters an array to only include even numbers.

	filterEvens([]) → []
	filterEvens([1, 3, 5]) → []
	filterEvens([2, 4, 6]) → [2, 4, 6]
	filterEvens([100, 8, 21, 24, 62, 9, 7]) → [100, 8, 24, 62]
*/

function filterEvens(arr) {
    // Use the filter method to return only even numbers
    return arr.filter(num => num % 2 === 0);
}

/*
10. **filterBigNumbers** Write a function that filters numbers greater than or equal to 100.

	filterBigNumbers([7, 10, 121, 100, 24, 162, 200]) → [121, 100, 162, 200]
	filterBigNumbers([3, 2, 7, 1, -100, -120]) → []
	filterBigNumbers([]) → []
*/

function filterBigNumbers(arr) {
    // Use the filter method to return numbers greater than or equal to 100
    return arr.filter(num => num >= 100);
}

/*
11. **filterMultiplesOfX** Write a function to filter numbers that are a multiple of a 
parameter, `x` passed in.

	filterMultiplesOfX([3, 5, 1, 9, 18, 21, 42, 67], 3) → [3, 9, 18, 21, 42]
	filterMultiplesOfX([3, 5, 10, 20, 18, 21, 42, 67], 5) → [5, 10, 20]
*/

function filterMultiplesOfX(arr, x) {
    // Use the filter method to return numbers that are multiples of x
    return arr.filter(num => num % x === 0);
}

/*
12. **createObject** Write a function that creates an object with a property called 
firstName, lastName, and age. Populate the properties with your values.

	createObject() →

	{
		firstName,
		lastName,
		age
	}
*/

function createObject() {
    // Create and return an object with the properties firstName, lastName, and age
    return {
        firstName: "John",  // Replace with your first name
        lastName: "Doe",    // Replace with your last name
        age: 25             // Replace with your age
    };
}
