package com.coderscampus.assignment4;

import java.util.Arrays;

public class StudentService {
    Student[] COMPSCIStudents = new Student[34];
    Student[] APMTHStudents = new Student[33];
    Student[] STATStudents = new Student[33];

    public void manageStudents() {
        FileService fileService = new FileService();
        Student[] allStudents = new Student[100];
        String[] fileStrings = fileService.loadStudentsFromFile();
        int COMPSCISIndex = 0;
        int APMTHIndex = 0;
        int STATtIndex = 0;
        int studentIndex = 0;

        for (String line : fileStrings) {
            String[] studentInformation = line.split(",");
            if (studentInformation.length < 4) {
                System.out.println("this is not valid student Information :" + String.join(",", studentInformation));
            }
            try {
                allStudents[studentIndex++] = new Student(studentInformation[0], studentInformation[1], studentInformation[2], Integer.parseInt(studentInformation[3]));
            } catch (Exception e) {
                studentIndex--;
                System.out.println("Invalid data format:" + e.getMessage());
            }
        }

        Arrays.sort(allStudents);

        for (Student student : allStudents) {

            if (student.getCourse().contains("COMPSCI")) {
                COMPSCIStudents[COMPSCISIndex++] = student;
            }

            if (student.getCourse().contains("APMTH")) {
                APMTHStudents[APMTHIndex++] = student;
            }

            if (student.getCourse().contains("STAT")) {
                STATStudents[STATtIndex++] = student;
            }
        }

        fileService.saveStudentsToFile(COMPSCIStudents, 1);
        fileService.saveStudentsToFile(APMTHStudents, 2);
        fileService.saveStudentsToFile(STATStudents, 3);
    }
}
