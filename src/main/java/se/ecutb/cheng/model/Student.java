package se.ecutb.cheng.model;

import java.util.Objects;

public class Student {
    private static int studentCounter;
    private int studentId; // to differ id in Class Course
    private String name;
    private String email;
    private String address;

    public Student(int studentId, String name, String email, String address) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Student(String name, String email, String address) {
        this(++studentCounter, name, email, address);
    }

    public int getStudentCounter(){
        return studentCounter;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId &&
                name.equals(student.name) &&
                email.equals(student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
