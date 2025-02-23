package com.coderscampus.assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StudentService {
    ArrayList<Student> COMPLICITStudents = new ArrayList<>();
    ArrayList<Student> APMTHStudents = new ArrayList<>();
    ArrayList<Student> STATStudents = new ArrayList<>();

    public void studentManager() {
        FileService fileService = new FileService();
        ArrayList<Student> allStudents = fileService.loadStudentsFromFile();
        Collections.sort(allStudents);
        for (Student student : allStudents) {
            if (student.getCourse().contains("COMPSCI")) {
                COMPLICITStudents.add(student);
            }

            if (student.getCourse().contains("APMTH")) {
                APMTHStudents.add(student);
            }

            if (student.getCourse().contains("STAT")) {
                STATStudents.add(student);
            }
        }

        fileService.writeStudentsInToFile(COMPLICITStudents, 1);
        fileService.writeStudentsInToFile(APMTHStudents, 2);
        fileService.writeStudentsInToFile(STATStudents, 3);

    }
}
