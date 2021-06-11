package com.magic.employeepayroll;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIO{

    Path fileLocation= Paths.get("C:\\Users\\ayuanshi\\Documents\\FileInputOutputDemo\\EmployeeData.txt");
    public void writeIntoFile(List<Employee> employeeList) throws IOException {
            StringBuffer buffer = new StringBuffer();
            employeeList.forEach(emp -> {
                String empDataString = emp.toString().concat("\n");
                buffer.append(empDataString);
                try {
                    Files.write(Paths.get(String.valueOf(fileLocation)), buffer.toString().getBytes());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            });
    }
    public long CountNumberOfEntries(){
        long employeeIndex=0;
        try {
            employeeIndex=Files.lines(fileLocation).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeIndex;
    }
    public void printEmployeeData(){
        try {
            Files.lines(fileLocation).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile() throws IOException {
        BufferedReader reader=Files.newBufferedReader((fileLocation));
        Files.lines(fileLocation).forEach(lines-> {
            try {
                reader.readLine();
                System.out.println(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
