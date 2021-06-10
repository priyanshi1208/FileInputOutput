package com.magic.employeepayroll;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

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
        Path fileLocation=Paths.get("C:\\Users\\ayuanshi\\Documents\\");
        IntStream.range(1,5).forEach(counter -> {
            Path file = Paths.get(fileLocation + "\\FileInputOutput" + counter);
            Assert.assertTrue(Files.notExists(file));
            try {
                Files.createFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Assert.assertTrue(Files.exists(file));
        });
    }
    @Test
    public void files() throws IOException {
        Path fileLocation=Paths.get("C:\\Users\\ayuanshi\\Documents\\FileInputOutput");
        Files.list(fileLocation).filter(Files::isRegularFile).forEach(System.out::println);
    }

}