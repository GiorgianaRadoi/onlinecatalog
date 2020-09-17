package com.grad.onlinecatalog.repository;

import com.grad.onlinecatalog.model.Attendance;
import com.grad.onlinecatalog.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    @Query("FROM Grade s WHERE s.grade.gradeId= :gradeId")
    List<Grade> findGradesForStudentId(@Param("gradeId")Integer studentId);
}
