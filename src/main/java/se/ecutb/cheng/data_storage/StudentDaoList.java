package se.ecutb.cheng.data_storage;

import se.ecutb.cheng.model.Student;
import se.ecutb.cheng.data_access.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student> students;

    public StudentDaoList(){
        students = new ArrayList<>();
    }

    @Override
    public Student saveStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            return student;
        }
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        for(Student student: students){
            if(student.getEmail().equalsIgnoreCase(email)){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> s = new ArrayList<>();
        for(Student student: students){
            if(student.getName().equalsIgnoreCase(name)){
                s.add(student);
            }
        }
        return s;
    }

    @Override
    public Student findById(int studentId) {
        for(Student student: students){
            if(student.getStudentId() == studentId){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        if(students.contains(student)){
            students.remove(student);
            return true;
        }
        return false;
    }
}
