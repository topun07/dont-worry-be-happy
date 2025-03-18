// Sample employee data
const employees = [
    { firstName: 'John', lastName: 'Doe', years: 5, department: 'Marketing' },
    { firstName: 'Jane', lastName: 'Smith', years: 3, department: 'Finance' },
    { firstName: 'Bob', lastName: 'Johnson', years: 10, department: 'IT' },
    { firstName: 'Alice', lastName: 'Williams', years: 2, department: 'HR' },
    { firstName: 'Michael', lastName: 'Brown', years: 7, department: 'Operations' },
  ];
  
  // Display employees in the table
  function displayEmployees(employeeList) {
    const tableBody = document.getElementById("employeeTable").getElementsByTagName("tbody")[0];
    tableBody.innerHTML = ""; // Clear any existing rows
  
    employeeList.forEach(employee => {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.years}</td>
        <td>${employee.department}</td>
      `;
      tableBody.appendChild(row);
    });
  
    calculateAverageEmployment(employeeList);
  }
  
  // Sort employees by a given property and display the sorted array
  function sortEmployees(property) {
    employees.sort((a, b) => {
      if (typeof a[property] === "number") {
        return a[property] - b[property];
      } else {
        return a[property].localeCompare(b[property]);
      }
    });
    displayEmployees(employees);
  }
  
  // Filter employees by last name and display the filtered array
 function onKeyPress(value) {
    const filter = value.toLowerCase();
    const filteredEmployees = employees.filter(employee => 
      employee.lastName.toLowerCase().includes(filter)
    );
    displayEmployees(filteredEmployees);
  };
  
  // Calculate and display the average employment length
  function calculateAverageEmployment(employeeList) {
    const totalYears = employeeList.reduce((acc, employee) => acc + employee.years, 0);
    const average = (employeeList.length > 0) ? (totalYears / employeeList.length).toFixed(2) : 0;
    document.getElementById("avgYears").innerText = average;
  }
  
  // Initial display on page load
  window.onload = () => displayEmployees(employees);
  