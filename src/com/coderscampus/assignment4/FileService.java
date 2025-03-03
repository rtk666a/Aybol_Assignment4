package com.coderscampus.assignment4;

import java.io.*;

public class FileService {
    public String[] read() {
        int lineCount = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("student-master-list.csv"))) {
            bufferedReader.readLine();
            while (bufferedReader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("there was some error counting the number of students file  " + e.getMessage());
        }

        String[] fileInformation = new String[lineCount];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("student-master-list.csv"))) {
            bufferedReader.readLine();
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                fileInformation[index++] = line;
            }
        } catch (IOException e) {
            System.out.println("there was an error reading the csv file  " + e.getMessage());
        }
        return fileInformation;
    }

    public void write(Student[] students, int fileNumber) {
        try (BufferedWriter studentWriter = new BufferedWriter(new FileWriter("course" + fileNumber + ".csv"))) {
            studentWriter.write("Student ID,Student Name,Course,Grade\n");
            for (Student student : students) {
                if (student != null) {
                    studentWriter.write(student.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("there was an error write the csv file  " + e.getMessage());
        }
    }
}
