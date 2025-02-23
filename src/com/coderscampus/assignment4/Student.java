package com.coderscampus.assignment4;

public class Student implements Comparable<Student> {
    private String studentID;
    private String studentName;
    private String course;
    private int grade;

    public Student() {

    }

    public Student(String studentID, String studentName, String course, int grade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.course = course;
        this.grade = grade;
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
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return studentID + "," + studentName + "," + course + "," + grade + "\n";
    }

    @Override
    public int compareTo(Student that) {
        return Integer.compare(that.grade, this.grade);
    }

}
