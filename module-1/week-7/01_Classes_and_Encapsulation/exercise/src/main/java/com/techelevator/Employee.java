package com.techelevator;

public class Employee {

    //instance
    private int employeeId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;

    // constructor
    public Employee(int employeeId, String firstName, String lastName,double annualSalary){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
        this.department = " ";
    }

    // getters
    public int getEmployeeId(){
        return employeeId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFullName(){
        return lastName + "," + firstName;
    }

    public String getDepartment(){
        return department;
    }

    public double getAnnualSalary(){
        return annualSalary;
    }

    // setters

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // raised salary method
    public void raiseSalary(double percent){
        double raiseAmount = annualSalary * percent / 100;
        annualSalary += raiseAmount;
    }

    //testing employee class
    public static void main(String[] args){
        //create employee object
        Employee emp = new Employee(101, "John", "Doe", 50000.0);

// employee info
    System.out.println("Employee ID " + emp.getEmployeeId());
    System.out.println("Full Name " + emp.getFullName());
    System.out.println("Department " + emp.getDepartment());
    System.out.println("Annual Salary: " + emp.getAnnualSalary() + "dollars");

    //Give the employee a raise of 5%
    emp.raiseSalary(5.0);

    //Display updated salary
    System.out.println("\nAfter 5% raise, New Annual Salary: $ " + emp.getAnnualSalary());
}
}