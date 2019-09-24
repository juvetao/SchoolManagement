package se.ecutb.cheng.data_storage;

import se.ecutb.cheng.Course;
import se.ecutb.cheng.data_access.CourseDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {
    private static List<Course> courses;

    public CourseDaoList(){
        courses = new ArrayList<>();
    }

    @Override
    public Course saveCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            return course;
        }
        return null;
    }

    @Override
    public Course findById(int courseId) {
        for(Course course: courses){
            if(course.getCourseId() == courseId){
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> c = new ArrayList<>();
        for(Course course: courses){
            if(course.getCourseName().equalsIgnoreCase(name)){
                c.add(course);
            }
        }
        return c;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> c = new ArrayList<>();
        for(Course course: courses){
            if(course.getStartDate() == date){
                c.add(course);
            }
        }
        return c;

    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
        if(courses.contains(course)){
            courses.remove(course);
            return true;
        }
        return false;
    }

}
