package com.grad.onlinecatalog.repository;

import com.grad.onlinecatalog.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, String> {
}
