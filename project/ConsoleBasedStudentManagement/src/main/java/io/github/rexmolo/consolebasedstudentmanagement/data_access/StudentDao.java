package io.github.rexmolo.consolebasedstudentmanagement.data_access;

import io.github.rexmolo.consolebasedstudentmanagement.model.Student;

import java.util.List;

public interface StudentDao {

    Student save(Student student);
    Student find(int id);
    List<Student> findAll();
    void delete(int id);
}
