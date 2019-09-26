package se.ecutb.cheng;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.cheng.data_storage.CourseDaoList;
import se.ecutb.cheng.model.Course;
import se.ecutb.cheng.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseDaoListTest {
    CourseDaoList testObject;
    Course course1;
    Student student1, student2;
    List<Student> students;

    @Before
    public void setup(){
        student1 = new Student("Cheng Tao", "cheng.tao86@gmail.com", "Skomakaregatan 13");
        student2 = new Student("Emilie Johansson", "ej@gmail.com", "Arklimastaregatan 14A");
        students = new ArrayList<Student>(Arrays.asList(student1, student2));
        course1 = new Course("Programmering i Java", LocalDate.parse("2019-08-20"), 6, students);
        testObject = new CourseDaoList();
    }

    @Test
    public void save_course_test_successfully(){
        Course expectedCourse = course1;
        Course actualCourse = testObject.saveCourse(course1);
        System.out.println("Actual: "+actualCourse);
        Assert.assertEquals(expectedCourse, actualCourse);
    }

    @Test
    public void save_course_test_failed(){
        Course temp = course1;
        Course temp1 = testObject.saveCourse(course1);
        Course actual = testObject.saveCourse(course1);
        Assert.assertNull(actual);
    }

    @Test
    public void find_by_id_test_successfully(){
        testObject.saveCourse(course1);
        System.out.println(testObject.findAll().toString());
        Course expectedCourse = course1;
        Course actualCourse = testObject.findById(course1.getCourseId());
        Assert.assertEquals(expectedCourse, actualCourse);
    }

    @Test
    public void find_by_id_test_fail(){
        testObject.saveCourse(course1);
        Course expectedCourse = null;
        Course actualCourse = testObject.findById(3);
        Assert.assertEquals(expectedCourse, actualCourse);
    }

    @Test
    public void find_by_name_test(){
        testObject.saveCourse(course1);
        Course course2 = new Course("HTML", LocalDate.parse("2019-10-01"), 5, students);
        testObject.saveCourse(course2);


        List<Course> expectedCourses = testObject.findByName("HTML");
        List<Course> actualCourses = new ArrayList<>();
        actualCourses.add(course2);
        Assert.assertEquals(expectedCourses, actualCourses);
    }

    @Test
    public void find_by_date_test() {
        testObject.saveCourse(course1);
        Course course2 = new Course("HTML", LocalDate.parse("2019-10-01"), 5, students);
        testObject.saveCourse(course2);

        List<Course> expectedCourses = testObject.findByDate(LocalDate.parse("2019-10-01"));
        List<Course> actualCourses = new ArrayList<>();
        actualCourses.add(course2);
        Assert.assertEquals(expectedCourses, actualCourses);
    }

    @Test
    public void find_all_test() {
        testObject.saveCourse(course1);
        Student student2 = new Student("Cheng Tao", "ct@gmail.com", "Kungsgatan 11");
        List<Student> students = new ArrayList<Student>(Arrays.asList(student2));
        Course course2 = new Course("HTML", LocalDate.parse("2019-10-01"), 5, students);
        testObject.saveCourse(course2);

        List<Course> expectedCourses = testObject.findAll();
        List<Course> actualCourses = new ArrayList<>();
        actualCourses.add(course1);
        actualCourses.add(course2);
        Assert.assertEquals(expectedCourses, actualCourses);
    }

    @Test
    public void remove_course_test_successfully(){
        testObject.saveCourse(course1);
        testObject.removeCourse(course1);
        int expectedValue = 0;
        int actualValue = testObject.findAll().size();
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void remove_course_test_failed(){
        Student student2 = new Student("Cheng Tao", "ct@gmail.com", "Kungsgatan 11");
        List<Student> students = new ArrayList<Student>(Arrays.asList(student2));
        Course course2 = new Course("HTML", LocalDate.parse("2019-10-01"), 5, students);
        boolean actual = testObject.removeCourse(course2);
        Assert.assertFalse(actual);
    }
}



