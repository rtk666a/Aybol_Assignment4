package com.coderscampus.assignment4;

import java.io.*;


public class StudentApplication {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.load();
        studentService.sortStudentByGrade();

        String[] courses = {"COMPSCI", "APMTH", "STAT" };

        int fileNumber = 1;
        for (String course : courses) {
            Student[] studentsByCourse = studentService.separateByCourse(course);
            studentService.writeToCsv( studentsByCourse, fileNumber++);
        }

    }
}