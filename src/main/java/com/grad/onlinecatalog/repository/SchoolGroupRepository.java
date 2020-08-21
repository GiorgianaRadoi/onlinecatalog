package com.grad.onlinecatalog.repository;

import com.grad.onlinecatalog.model.SchoolGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolGroupRepository extends JpaRepository<SchoolGroup, Integer> {
}
