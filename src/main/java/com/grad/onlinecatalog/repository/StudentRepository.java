package com.grad.onlinecatalog.repository;

import com.grad.onlinecatalog.model.SchoolGroup;
import com.grad.onlinecatalog.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("FROM Student s WHERE s.schoolGroup.groupId= :groupId")
    List<Student> findAllByGroupId(@Param("groupId")Integer groupId);
}
