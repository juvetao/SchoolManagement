package se.ecutb.cheng;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.cheng.model.Course;
import se.ecutb.cheng.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseTest {
    List<Student> students;
    Student student1, student2;
    Course course;

    @Before
    public void setup(){
        student1 = new Student("Cheng Tao", "cheng.tao86@gmail.com", "Skomakaregatan 13");
        student2 = new Student("Emilie Johansson", "ej@gmail.com", "Arklimastaregatan 14A");
        students = new ArrayList<Student>(Arrays.asList(student1, student2));
        course = new Course(1, "Programmering i Java", LocalDate.parse("2019-08-20"), 6, students);
    }

    //check initiation, whether studenterCounter works;
    //check whether student can be added and if the studentCounter increases, as added;
    //check whether student can be removed and if the studentCounter decreases, as removed;

    @Test
    public void register_student_test(){
        Student s1 = new Student("John Johansson", "jj@gmail.com", "Gyllenstjansvagen 7");
        course.register(s1);
        int expectedValue = 3;
        Assert.assertEquals(expectedValue, course.getStudentCounter());
    }

    @Test
    public void unregister_student_test(){
        course.unregister(student2);
        int expectedValue = 1;
        Assert.assertEquals(expectedValue, course.getStudentCounter());
    }


}
