package se.ecutb.cheng.data_access;

import se.ecutb.cheng.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseDao {
    Course saveCourse(Course course);
    Course findById(int courseId);
    List<Course> findByName(String name);
    List<Course> findByDate(LocalDate date);
    List<Course> findAll();
    boolean removeCourse(Course course);
}
