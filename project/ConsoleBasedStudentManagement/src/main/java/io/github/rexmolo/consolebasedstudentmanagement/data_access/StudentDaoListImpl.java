package io.github.rexmolo.consolebasedstudentmanagement.data_access;

import io.github.rexmolo.consolebasedstudentmanagement.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao{
    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
