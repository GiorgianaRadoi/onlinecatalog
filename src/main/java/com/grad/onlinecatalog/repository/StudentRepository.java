package com.grad.onlinecatalog.repository;

import com.grad.onlinecatalog.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
