package com.magic.employeepayroll;

import java.io.File;
import java.util.Arrays;

public class FileOperations {
    public static boolean deleteFiles(File filesToDelete) {
        File[] listOfFiles = filesToDelete.listFiles();
        if(listOfFiles!=null) {
            Arrays.stream(listOfFiles).forEach(file -> deleteFiles(file));
        }
        return filesToDelete.delete();
    }
}

