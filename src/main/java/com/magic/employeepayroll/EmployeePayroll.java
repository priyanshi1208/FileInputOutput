package com.magic.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayroll {
    public List<Employee> employeeList;
    public void readEmployeeData(Scanner consoleInputReader) {
        employeeList=new ArrayList<>();
        System.out.println("Enter Employee Id");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary");
        double salary = consoleInputReader.nextDouble();
        employeeList.add(new Employee(id, name, salary));
    }
    public void writeEmployeeData() {
        System.out.println(employeeList);
    }

    public static void main(String[] args) {
        EmployeePayroll employeePayroll=new EmployeePayroll();
        Scanner consoleReader=new Scanner(System.in);
        employeePayroll.readEmployeeData(consoleReader);
        employeePayroll.writeEmployeeData();
    }

}
