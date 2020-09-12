package com.grad.onlinecatalog.repository;

import com.grad.onlinecatalog.model.SchoolGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolGroupRepository extends JpaRepository<SchoolGroup, Integer> {
    @Query("FROM SchoolGroup s WHERE s.schoolUnit.unitId= :unitId")
    List<SchoolGroup> findAllByUnitID(@Param("unitId")Integer unitId);
}
