package com.grad.onlinecatalog.repository;

import com.grad.onlinecatalog.model.Attendance;
import com.grad.onlinecatalog.model.SchoolGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    @Query("FROM Attendance s WHERE s.attendance.attendanceId= :attendanceId")
    List<Attendance> findAllByStudentId(@Param("attendanceId")Integer studentId);
}
