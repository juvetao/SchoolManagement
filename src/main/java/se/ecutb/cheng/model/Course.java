package se.ecutb.cheng.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private int courseId;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;
    private static int courseCountet;

    public Course(int courseId, String courseName, LocalDate startDate, int weekDuration, List<Student> students) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

    public Course(String courseName, LocalDate startDate, int weekDuration, List<Student> students){
        this(++courseCountet, courseName, startDate, weekDuration, students);
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId &&
                courseName.equals(course.courseName) &&
                startDate.equals(course.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, startDate);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }

    public void register(Student student){
        if(!students.contains(student)){
            System.out.println(student.getName() + " was added to " + getCourseName());
            students.add(student);
        }else{
            System.out.println(student.getName() + " is already in " + getCourseName());
        }
    }

    public void unregister(Student student){
        if(students.contains(student)){
            System.out.println(student.getName() + " was removed from " + getCourseName());
            students.remove(student);
        }else{
            System.out.println(student.getName() + " is not in " + getCourseName());
        }

    }

    public int getStudentCounter(){
        return students.size();
    }

}
