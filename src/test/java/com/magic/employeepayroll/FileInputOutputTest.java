package com.magic.employeepayroll;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FileInputOutputTest {
    private String folder=System.getProperty("C:\\Users\\ayuanshi\\Documents\\FileInputOutputDemo");
    private String file="FileDemo";


    @Test
    public void validate_if_the_path_exists_returns_true() {
        Path fileLocation= Paths.get("C:\\Users\\ayuanshi\\Documents\\FileInputOutputDemo");
        Assert.assertTrue(Files.exists(fileLocation));
    }

    @Test
    public void validate_if_file_exists_in_location_delete_file() {
        Path fileLocation=Paths.get("C:\\Users\\ayuanshi\\Documents\\FileInputOutputDemo");
        if (Files.exists(fileLocation))
            FileOperations.deleteFiles(fileLocation.toFile());
        Assert.assertFalse(Files.notExists(fileLocation));
    }
    @Test
    public void given_Path_Should_Create_Directory_And_Return_True() throws IOException {
        Path fileLoaction=Paths.get("C:\\Users\\ayuanshi\\Documents\\FileInputOutput");
        Files.createDirectory(fileLoaction);
        Assert.assertTrue(Files.exists(fileLoaction));
    }
    @Test
    public void validating_Path_Should_Create_Files_Return_True() {
        Path fileLocation=Paths.get("C:\\Users\\ayuanshi\\Documents\\FileInputOutput");
        IntStream.range(1,5).forEach(counter->{
            try {
                Files.createFile(Path.of(fileLocation + "/fileIOStream" + counter + ".txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Assert.assertTrue(Files.exists(fileLocation));
    }
    @Test
    public void files() throws IOException {
        Path fileLocation=Paths.get("C:\\Users\\ayuanshi\\Documents\\FileInputOutput");
        Files.list(fileLocation).filter(Files::isRegularFile).forEach(System.out::println);
    }

    @Test
    public void validating_if_employee_data_is_written_in_file() throws IOException {
        Employee[] employeeData = {
                new Employee(1,"Daniel", 2000000.0),
                new Employee(2,"Bella", 120000.0),
                new Employee(3,"Rose", 90000.0)
        };
        EmployeePayroll employeePayroll = new EmployeePayroll(Arrays.asList(employeeData));
        employeePayroll.writeEmployeeData(OutputType.File_InputOutput);
    }

    @Test
    public void validate_number_of_entries_in_file() throws IOException {
        Employee[] employeeData = {
                new Employee(1,"Daniel", 2000000.0),
                new Employee(2,"Bella", 120000.0),
                new Employee(3,"Rose", 90000.0)
        };
        EmployeePayroll employeePayroll = new EmployeePayroll(Arrays.asList(employeeData));
        employeePayroll.writeEmployeeData(OutputType.File_InputOutput);
        long entries = employeePayroll.CountEntries();
        Assert.assertEquals(3,entries);
    }
}