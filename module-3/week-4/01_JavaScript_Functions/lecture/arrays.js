let a1 = ["Peter", "Paul", "Mary", "Jim", "Kim"];
//console.table(a1);


function isNameLong(element) {
    if (element.length > 3)
        return true;
    return false;
}

function isNameShort(element) {
    if (element.length < 4)
        return true;
    return false;
}

function isNameEven(inx) {
    if (inx % 2 == 0)
        return true;
    return false;
}


function printElement(element) {
    console.log(element);
}

function printMembers(checker) {

    let longNames = [];

    for (let index = 0; index < a1.length; index++) {
        const element = a1[index];

        if (checker(index, element))
            longNames.push(element);
    }

    return longNames;
}

//console.table(printMembers(isNameLong));
//console.table(printMembers(isNameShort));
//console.table(printMembers(isNameEven));


a1.forEach(printElement);


let filtered= a1.filter(isNameLong);
//console.table(filtered)


const employees = [
    { firstName: 'John', lastName: 'Doe', years: 5, department: 'Marketing' },
    { firstName: 'Jane', lastName: 'Smith', years: 3, department: 'Finance' },
    { firstName: 'Bob', lastName: 'Johnson', years: 10, department: 'IT' },
    { firstName: 'Alice', lastName: 'Williams', years: 2, department: 'HR' },
    { firstName: 'Michael', lastName: 'Brown', years: 7, department: 'Operations' },
];


function filterByAge(employee) {

    return employee.years < 5 
}


console.table(employees);

let noobies = employees.filter(filterByAge);
let oldies = employees.filter((employee) => employee.years > 5 );


console.table(noobies);




