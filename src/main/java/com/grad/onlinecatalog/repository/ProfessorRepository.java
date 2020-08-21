package com.grad.onlinecatalog.repository;

import com.grad.onlinecatalog.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
