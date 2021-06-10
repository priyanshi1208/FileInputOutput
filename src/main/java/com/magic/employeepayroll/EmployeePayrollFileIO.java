package com.magic.employeepayroll;

import java.io.FileWriter;
import java.io.IOException;
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
}
