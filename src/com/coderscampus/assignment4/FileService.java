package com.coderscampus.assignment4;

import java.io.*;

public class FileService {
    public String[] loadStudentsFromFile() {
        String[] fileInformation = new String[101];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("student-master-list.csv"))) {
            String line = null;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                fileInformation[index++] = line;
            }
        } catch (IOException e) {
            System.out.println("here some IO Exception " + e.getMessage());
        }
        return fileInformation;
    }

    public void saveStudentsToFile(Student[] students, int fileCase) {
        try (BufferedWriter studentWriter = new BufferedWriter(new FileWriter("course" + String.valueOf(fileCase) + ".csv"))) {
            studentWriter.write("Student ID,Student Name,Course,Grade\n");
            for (Student student : students) {
                studentWriter.write(student.toString());
            }
        } catch (IOException e) {
            System.out.println("here we have some IOExceptions " + e.getMessage());
        }
    }
}
