package com.student.mgmt.entity;

public class Student {
    private int studentId;
    private String studentName;
    private String studentPhone;
    private String studentCity;

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return this.studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentCity() {
        return this.studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public Student(int studentId, String studentName, String studentPhone, String studentCity) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentCity = studentCity;
    }

    public Student() {
    }

    public String toString() {
        return "Student{studentId=" + this.studentId + ", studentName='" + this.studentName + "', studentPhone='" + this.studentPhone + "', studentCity='" + this.studentCity + "'}";
    }
}
