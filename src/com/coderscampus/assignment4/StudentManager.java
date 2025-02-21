package com.coderscampus.assignment4;

import java.util.ArrayList;

public class StudentManager {
    ArrayList<Student> COMPLICITStudents = new ArrayList<>();
    ArrayList<Student> APMTHStudents = new ArrayList<>();
    ArrayList<Student> STATStudents = new ArrayList<>();

    public void sortStudents(){
        FileService fileService = new FileService();
        ArrayList<Student> allStudents = fileService.loadStudentsFromFile();
        for (Student student : allStudents) {
            if (student.getCourse().contains("COMPSCI") ){
                COMPLICITStudents.add(student);
            }

            if (student.getCourse().contains("APMTH") ){
                APMTHStudents.add(student);
            }

            if (student.getCourse().contains("STAT") ){
                STATStudents.add(student);
            }
        }



    }


}
