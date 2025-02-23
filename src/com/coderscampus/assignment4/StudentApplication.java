package com.coderscampus.assignment4;

import java.io.*;

public class StudentApplication {
    public static void main(String[] args) throws IOException {
        StudentService studentService = new StudentService();
        studentService.studentManager();
    }
}