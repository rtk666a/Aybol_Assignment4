package com.coderscampus.assignment4;

public class Student {
    private String studentID;
    private String studentName;
    private String Course;
    private int Grade;

    public Student() {

    }

    public Student(String studentID, String studentName, String course, int grade) {
        this.studentID = studentID;
        this.studentName = studentName;
        Course = course;
        Grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", Course='" + Course + '\'' +
                ", Grade=" + Grade +
                '}';
    }
}
