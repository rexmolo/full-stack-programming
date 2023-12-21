package se.lexicon.course_manager.data.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager.data.dao.CourseDao;
import se.lexicon.course_manager.data.dao.StudentDao;
import se.lexicon.course_manager.data.service.converter.Converters;
import se.lexicon.course_manager.dto.forms.CreateStudentForm;
import se.lexicon.course_manager.dto.forms.UpdateStudentForm;
import se.lexicon.course_manager.dto.views.CourseView;
import se.lexicon.course_manager.dto.views.StudentView;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class StudentManager implements StudentService {

    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final Converters converters;

    @Autowired
    public StudentManager(StudentDao studentDao, CourseDao courseDao, Converters converters) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.converters = converters;
    }

    @Override
    public StudentView create(CreateStudentForm form) {
        Student st = this.studentDao.createStudent(
                form.getName(),
                form.getEmail(),
                form.getAddress()
        );
        return this.converters.studentToStudentView(st);
    }

    @Override
    public StudentView update(UpdateStudentForm form) {

        Student st = this.studentDao.findById(form.getId());
        st.setName(form.getName());
        st.setEmail(form.getEmail());
        st.setAddress(form.getAddress());

        return this.converters.studentToStudentView(st);
    }

    @Override
    public StudentView findById(int id) {
        Student st = this.studentDao.findById(id);
        return this.converters.studentToStudentView(st);
    }

    @Override
    public StudentView searchByEmail(String email) {
        Student st = this.studentDao.findByEmailIgnoreCase(email);
        return this.converters.studentToStudentView(st);
    }

    @Override
    public List<StudentView> searchByName(String name) {
        Collection<Student> stc = this.studentDao.findByNameContains(name);
        if (stc.size() == 0) return null;
        return this.converters.studentsToStudentViews(stc);
    }

    @Override
    public List<StudentView> findAll() {
        Collection<Student> stc = this.studentDao.findAll();
        if (stc.size() == 0) return null;
        return this.converters.studentsToStudentViews(stc);
    }

    @Override
    public boolean deleteStudent(int id) {
        return this.studentDao.removeStudent(this.studentDao.findById(id));
    }
}
