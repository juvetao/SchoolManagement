package se.ecutb.cheng.data_access;

import se.ecutb.cheng.Student;

import java.util.List;

public interface StudentDao {
    Student saveStudent(Student student);
    Student findByEmail(String email);
    List<Student> findByName(String name);
    Student findById(int studentId);
    List<Student> findAll();
    boolean deleteStudent(Student student);
}
