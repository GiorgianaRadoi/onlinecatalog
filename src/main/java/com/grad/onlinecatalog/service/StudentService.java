package com.grad.onlinecatalog.service;

import com.grad.onlinecatalog.model.SchoolGroup;
import com.grad.onlinecatalog.model.Student;
import com.grad.onlinecatalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IStudentService")
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student findById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }

        return null;
    }

    public void deleteById(Integer id) {
       studentRepository.deleteById(id);
    }

    public List<Student> findByUnitId(Integer groupId){return studentRepository.findAllByGroupId( groupId );}
}
