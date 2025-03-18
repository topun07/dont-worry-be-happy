

//isJavascriptWeird();

//variables();

//paper();

//arrays()

a = 5;
function isJavascriptWeird() {

  let res = 0;

  res = 3 - 1;
  res = 3 + 1;
  res = '3' - 1;

  let res1 = '3' + 1;

  if (Math.min() > Math.max())
    console.log("Really !!!");
  else
    console.log("Makes sense!");

  res = "Some String";

  t = "Some Value";

  {
    res = 123;
    let res = 456;
    t = 8;
  }

  // https://github.com/denysdovhan/wtfjs

}

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {

  // Declares a variable where the value cannot be changed
  const daysPerWeek = 7;

  //Using console
  console.log("There are " + daysPerWeek + " days in a week?");
  console.log(`There are ${daysPerWeek} days!!!!! I said ${3 + 5} days`)


  console.warn("This is taking too long...");
  console.error("Something bad happened!");

  // Declares a variable whose value can be changed
  let daysPerMonth = 30;
  console.log(`There are ${daysPerMonth} days in the month.`);

  daysPerMonth = "Thirty";

  daysPerMonth = null;

  daysPerMonth = true;

  daysPerMonth = {
    "month": "January",
    "days": 31
  }


  daysPerMonth = function getMonthDays() {
    return 30;
  }

  let dd = daysPerMonth();
  console.log(`There are ${dd} days in the month.`);

  daysPerMonth = [31, "30", true, 38];

  // Declares a variable that will always be an array
  const weekdays = [
    "Monday", 1, true,
    "Tuesday", ["you", "me", 3, 5],
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
  ];
  console.table(weekdays);

  //But you can modify the array
  weekdays[0] = "Noday";
  weekdays[4][2] = 123.45;

  console.table(weekdays);

}

/* Null vs Undefined */
function paper() {

  let toiletPaper;

  toiletPaper = 100;

  toiletPaper = 0;

  toiletPaper = null;

  if (toiletPaper == null)
    console.log("Toilet paper is: " + toiletPaper);

  toiletPaper = undefined;

  if (toiletPaper == undefined)
    console.log("Toilet paper is: " + toiletPaper);

  // Infinity
  let a = 5 / 0;
  console.log(a);

  //NaN
  a = 0 / 0;
  console.log(a);

  a = "abc" * 3;
  console.log(a);

  console.log(NaN + 5); // Output: NaN
  console.log(NaN * 10); // Output: NaN

}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/
//stringFunctions("Hi Hello There!");

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */

  let abcd = "      Hi There        ";

  let pqr = abcd.trim();

  console.log(abcd);

  console.log(pqr);

}


//arrays();

/*
###############################
Arrays
###############################
*/

function arrays() {

  //push & unshift
  let arr = [2, 3, 4];
  arr.push(5);         // Adds to the end
  console.log(arr);     // Output: [2, 3, 4, 5]

  arr.unshift(1);       // Adds to the start
  console.log(arr);     // Output: [1, 2, 3, 4, 5]

  //pop and shift
  arr = [1, 2, 3, 4];
  arr.pop();            // Removes the last element
  console.log(arr);     // Output: [1, 2, 3]

  arr.shift();          // Removes the first element
  console.log(arr);     // Output: [2, 3]

  let l = arr.length;
  console.log(l);
}


//equality();

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {

  let a = 5;
  let b = 6;
  let c = '5';


  if (a == b)
    console.log("Equal");
  else
    console.log("Not Equal");

  if (a == c)
    console.log("Equal");
  else
    console.log("Not Equal");

  if (a === c)
    console.log("Equal");
  else
    console.log("Not Equal");



  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * #############################
 *  Comparisons
 * ############################
*/


function getSomeData() {

  /*
  FALS-Y
  ----------
  false
  0 (zero)
  -0 (minus zero)
  0n (BigInt zero)
  '', "", `` (empty string)
  null
  undefined
  NaN
  
  Everything else is truthy. That includes:
  
  '0' (a string containing a single zero)
  'false' (a string containing the text “false”)
  [] (an empty array)
  {} (an empty object)
  function(){} 
  
  */

  return "false";
}


function comparison() {

  let res = getSomeData();
  if (res) {
    console.log("All good");
  }
  else {
    console.error("Bad result");
  }


  thruthyFalsy(0);
  thruthyFalsy("0");
  thruthyFalsy("1");
  thruthyFalsy(null);
  thruthyFalsy(undefined);


}

function thruthyFalsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

//objects();

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/


let bill = objects();

function objects() {
  const person =
  {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton",
      { "first": "Joe",
        "last" : "Smith",
        "age": 45
      }
    ],
    friend: {
      name: "Peter",
      birthdate: "1/1/2000"
    }
  };


//toString: function () {
//  return `${this.lastName}, ${this.firstName} (${this.age + 10})`;
//},
//


  console.table(person);

  console.log(`${person.firstName} ${person.lastName} ${person.friend.birthdate}`);

  for (let i = 0; i < person.employees.length; i++) {
    console.log(`Employee ${i + 1} is ${person.employees[i]}`);
  }

  console.log(person);
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/
mathFunctions();

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}



