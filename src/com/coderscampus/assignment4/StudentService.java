package com.coderscampus.assignment4;

import java.util.Arrays;
import java.util.Comparator;

public class StudentService {
    private final FileService fileService = new FileService();
    public Student[] allStudents;

    public void load() {
        String[] fileStrings = fileService.read();
        int stringLength = fileStrings.length;
        allStudents = new Student[stringLength];

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
    }

    public void sortStudentByGrade() {
        Comparator<Student> studentComparator = Comparator.comparing(Student::getGrade, Comparator.nullsLast(Comparator.reverseOrder()));
        Arrays.sort(allStudents, studentComparator);
    }

    public Student[] separateByCourse(String course) {
        int studentCounter = 0;
        for (Student student : allStudents) {
            if (student.getCourse().startsWith(course)) {
                studentCounter++;
            }
        }

        Student[] studentByCourse = new Student[studentCounter];
        int index = 0;
        for (Student student : allStudents) {
            if (student.getCourse().contains(course)) {
                studentByCourse[index++] = student;
            }
        }
        return studentByCourse;
    }

    public void writeToCsv(Student[] studentsByCourse, int fileNumber) {
        fileService.write(studentsByCourse, fileNumber);
    }
}
