package se.ecutb.cheng.data_storage;

import se.ecutb.cheng.Student;
import se.ecutb.cheng.data_access.StudentDao;

import java.util.List;

public class StudentDaoList implements StudentDao {
    @Override
    public Student saveStudent(Student student) {
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return false;
    }


}
