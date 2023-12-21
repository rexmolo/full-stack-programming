package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Student;

import java.util.Collection;
import java.util.HashSet;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student st = new Student(StudentSequencer.nextStudentId(), name, email, address);
        this.students.add(st);
        return st;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        for (Student s: this.students) {
            if (s.getName().equalsIgnoreCase(email))
                return s;
        }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        Collection<Student> cst = new HashSet<>();
        for (Student s: this.students) {
            if (s.getName().contains(name))
                cst.add(s);
        }
        return cst;
    }

    @Override
    public Student findById(int id) {
        for (Student st: this.students) {
            if (st.getId() == id)
                return st;
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return this.students;
    }

    @Override
    public boolean removeStudent(Student student) {
        return this.students.remove(student);
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
