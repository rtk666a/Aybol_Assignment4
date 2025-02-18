package com.coderscampus.assignment4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileService {
    private final File fileName = new File("student-master-list.csv");
    ArrayList<String> fileData = new ArrayList<>();
    void loadStudentsFromFile() throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                fileData.add(scanner.nextLine());
            }
            scanner.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
