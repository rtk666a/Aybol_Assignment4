package com.coderscampus.assignment4;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {
    public ArrayList<Student> loadStudentsFromFile() {
        ArrayList<Student> allStudents = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream("student-master-list.csv"); Scanner scanner = new Scanner(fileInputStream)) {
            while (scanner.hasNextLine()) {
                String[] studentInformation = scanner.nextLine().split(",");

                if (studentInformation.length < 4) {
                    System.out.println("this is not valid student Information :" + String.join(",", studentInformation));
                }

                try {
                    allStudents.add(new Student(studentInformation[0], studentInformation[1], studentInformation[2], Integer.parseInt(studentInformation[3])));
                } catch (Exception e) {
                    System.out.println("Invalid data format:" + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("here some IO Exception ");
        }
        return allStudents;
    }
    public void writeStudentsInToFile(ArrayList<Student> students, int fileCase) {
        try (BufferedWriter studentWriter = new BufferedWriter(new FileWriter("course" + String.valueOf(fileCase) + ".csv"))) {
            studentWriter.write("Student ID,Student Name,Course,Grade\n");
            for (Student student : students) {
                studentWriter.write(student.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
