let a1 = ["Peter", "Paul", "Mary", "Jim", "Kim"];
let a2 = [10, 20, 30];

//console.table(a1);

function isNameLong(element, i, p) {

    console.log(element);
    if (element.length > 3)
        return true;
    return false;
}

function isNameShort(element) {
    if (element.length < 4)
        return true;
    return false;
}

function isNameEven(elemnt, inx) {
    if (inx % 2 == 0)
        return true;
    return false;
}

function printElement(element) {
    console.log(element);
}

function filterArray(checker) {

    let longNames = [];

    for (let index = 0; index < a1.length; index++) {
        const element = a1[index];

        if (checker(element))
            longNames.push(element);
    }

    return longNames;
}




//console.table(filterArray(isNameShort));

console.log("Start");

console.table(a1.filter(isNameEven));

console.log("Done!");


//console.table(printMembers(isNameShort));
//console.table(printMembers(isNameEven));


let filtered= a1.filter(isNameLong);
console.table(filtered)


//======================= FILTER =================================

let people = ["Peter Johnson", "Paul Moore", "Mary Smith", "Jim Peters", "Kim Smith"];


// ==================== FILTER OBJECTS ===========================
const employees = [
    { firstName: 'John', lastName: 'Doe', years: 5, department: 'Marketing' },
    { firstName: 'Jane', lastName: 'Smith', years: 3, department: 'Finance' },
    { firstName: 'Bob', lastName: 'Johnson', years: 10, department: 'IT' },
    { firstName: 'Alice', lastName: 'Williams', years: 2, department: 'HR' },
    { firstName: 'Michael', lastName: 'Brown', years: 7, department: 'Operations' },
];

console.table(employees);

function filterByAge(employee) {
    return employee.years < 5 
}

console.table(employees.filter(filterByAge));
console.table(employees.filter((employee) => employee.years > 5 ));

//============== MAP =====================================

function toEmployee(p) {

    let names= p.split(' ');

    return {
        firstName : names[0],
        lastName : names[1],
        years : 0,
        department : 'N/A'
    }
}


let emps = people.map(toEmployee)

console.table(emps);


//============== SORT =====================================
function sorterAsc(lhs, rhs) {

    let result = lhs.lastName.localeCompare(rhs.lastName);

    let res = "=" 
    if(result > 0)
        res = ">";
    else if(result < 0)
        res = "<";
    console.log(`${lhs.lastName} ${res} ${rhs.lastName}`)

    return result;
}


function sortDesc(lhs,rhs) {
    return sorterAsc(lhs,rhs) * -1;
}

employees.sort(sorterAsc);
console.table(employees)

employees.sort(sortDesc);
console.table(employees)



//==============REDUCE =====================================
function reducer(prevValue, employee) {

        console.log(`Previous Value: ${prevValue} Employee Years: ${employee.years}`);
        return prevValue + employee.years;
}

console.log(`Total Years ${employees.reduce(reducer, 0)}`); 




