package com.magic.employeepayroll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayroll {
    EmployeePayrollFileIO employeePayrollFileIO=new EmployeePayrollFileIO();
    public EmployeePayroll(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

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
    public long CountEntries(){
        return employeePayrollFileIO.CountNumberOfEntries();
    }
    public void PrintData(){
        employeePayrollFileIO.printEmployeeData();
    }
    public void writeEmployeeData(OutputType outputType) throws IOException {
        if(outputType.equals(OutputType.Console_InputOutput))
            System.out.println(employeeList);
        else
            new EmployeePayrollFileIO().writeIntoFile(employeeList);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Employee> list=new ArrayList<>();
        EmployeePayroll employeePayroll=new EmployeePayroll(list);
        Scanner consoleReader=new Scanner(System.in);
        employeePayroll.readEmployeeData(consoleReader);
        employeePayroll.writeEmployeeData(OutputType.Console_InputOutput);
    }

}
