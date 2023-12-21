package se.lexicon.course_manager.data.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager.data.dao.CourseDao;
import se.lexicon.course_manager.data.dao.StudentDao;
import se.lexicon.course_manager.data.service.converter.Converters;
import se.lexicon.course_manager.data.service.converter.ModelToDto;
import se.lexicon.course_manager.dto.forms.CreateCourseForm;
import se.lexicon.course_manager.dto.forms.UpdateCourseForm;
import se.lexicon.course_manager.dto.views.CourseView;
import se.lexicon.course_manager.model.Course;


import java.time.LocalDate;
import java.util.*;

@Service
public class CourseManager implements CourseService {

    private final CourseDao courseDao;
    private final StudentDao studentDao;
    private final Converters converters;

    @Autowired
    public CourseManager(CourseDao courseDao, StudentDao studentDao, Converters converters) {
        this.courseDao = courseDao;
        this.studentDao = studentDao;
        this.converters = converters;
    }

    @Override
    public CourseView create(CreateCourseForm form) {
        Course c = this.courseDao.createCourse(
                form.getCourseName(),
                form.getStartDate(),
                form.getWeekDuration());

        return this.converters.courseToCourseView(c);
    }

    @Override
    public CourseView update(UpdateCourseForm form) {
        Course c = this.courseDao.findById(form.getId());
        c.setCourseName(form.getCourseName());
        c.setStartDate(form.getStartDate());
        c.setWeekDuration(form.getWeekDuration());

        return this.converters.courseToCourseView(c);
    }

    @Override
    public List<CourseView> searchByCourseName(String courseName) {
        List<CourseView> clv = new ArrayList<>();
        Collection<Course> cl = this.courseDao.findByNameContains(courseName);
        if (cl.size() == 0)
            return clv;

        for (Course c: cl) {
            clv.add(this.converters.courseToCourseView(c));
        }

        return clv;
    }

    @Override
    public List<CourseView> searchByDateBefore(LocalDate end) {
        List<CourseView> clv = new ArrayList<>();
        Collection<Course> cl = this.courseDao.findByDateBefore(end);

        if (cl.size() == 0) return clv;

        for(Course c: cl) {
            clv.add(this.converters.courseToCourseView(c));
        }

        return clv;
    }

    @Override
    public List<CourseView> searchByDateAfter(LocalDate start) {
        List<CourseView> clv = new ArrayList<>();
        Collection<Course> cl = this.courseDao.findByDateAfter(start);

        if (cl.size() == 0) return clv;

        for(Course c: cl) {
            clv.add(this.converters.courseToCourseView(c));
        }

        return clv;

    }

    @Override
    public boolean addStudentToCourse(int courseId, int studentId) {
        return false;
    }

    @Override
    public boolean removeStudentFromCourse(int courseId, int studentId) {
        return false;
    }

    @Override
    public CourseView findById(int id) {
        return null;
    }

    @Override
    public List<CourseView> findAll() {
        List<CourseView> clv = new ArrayList<>();
        Collection<Course> cl = this.courseDao.findAll();
        if (cl.size() == 0)
            return clv;

        for (Course c: cl) {
            clv.add(this.converters.courseToCourseView(c));
        }

        return clv;

    }

    @Override
    public List<CourseView> findByStudentId(int studentId) {
        return null;
    }

    @Override
    public boolean deleteCourse(int id) {
        return false;
    }
}
