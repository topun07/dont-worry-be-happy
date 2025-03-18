
//Basic function
function a() {
    console.log("Hi there");
}

a();

//Return a value
function b() {
    return 1;
}

console.log(b());

//call with parameters
function c(p1, p2, p3) {

    //console.log("We got " + p1 + " and " + p2 + " and " + p3);

    console.log(`We got ${p1} and ${p2} and ${p3}`);
}

c("Hi", "there", "again", "and again", "and again");
c("Hi");

//call with parameters
function d(p1 = 0, p2 = "not provided", p3 = "something else") {

    //console.log("We got " + p1 + " and " + p2 + " and " + p3);

    console.log(`We got '${p1}' and '${p2}' and '${p3}'`);
}

d("Hi");

a = 5; // Don't do this
var b = 5; //Don't do this either

let c1 = 5;
const d1 = 5;

function someFunction() {

    c1 = 6;

    {
        let c1 = 7;
        c1 = 9;
    }
}

someFunction();

//=================================
function add(x, y) {
    return x + y;
}

let xyz = (x, y) => { return x + y }
let xyz1 = (x, y) => x + y;


console.log(add(3, 2));
console.log(xyz(3, 2));
console.log(xyz1(3, 2));

//====================================
function createPerson(name, age) {
    return {

        "name": name,
        "age": age,
    }
}

function printPerson(p1) {
    console.log(`This is ${p1.name} and they are ${p1.age} years old`);
    console.log(`This is ${p1["name"]} and they are ${p1["age"]} years old`);
}

printPerson(createPerson("Peter", 17));