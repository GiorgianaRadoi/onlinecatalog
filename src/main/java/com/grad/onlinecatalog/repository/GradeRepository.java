package com.grad.onlinecatalog.repository;

import com.grad.onlinecatalog.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
