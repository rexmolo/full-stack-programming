package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.CourseSequencer;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.time.LocalDate;
import java.util.*;


public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {

        Course c = new Course(
                CourseSequencer.nextCourseId(),
                courseName,
                startDate,
                weekDuration);

        this.courses.add(c);
        return c;
    }

    @Override
    public Course findById(int id) {
        for (Course c: this.courses) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        HashSet<Course> cl = new HashSet<>();
        for (Course c: this.courses) {
            if (c.getCourseName().equalsIgnoreCase(name))
                cl.add(c);
        }
        return cl;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        HashSet<Course> cl = new HashSet<>();

        for (Course c: this.courses) {
            if (c.getStartDate().isBefore(end))
                cl.add(c);
        }

        return cl;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        HashSet<Course> cl = new HashSet<>();

        for (Course c: this.courses) {
            if (c.getStartDate().isAfter(start))
                cl.add(c);
        }

        return cl;
    }

    @Override
    public Collection<Course> findAll() {

        return this.courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        ArrayList<Course> cl = new ArrayList<>();
        for (Course c: this.courses) {
            for(Student s: c.getStudents()){
                if (s.getId() == studentId){
                    cl.add(c); break;
                }
            }
        }
        return cl;
    }

    @Override
    public boolean removeCourse(Course course) {
        return this.courses.remove(course);
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}
