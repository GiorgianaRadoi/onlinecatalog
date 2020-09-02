package com.grad.onlinecatalog.repository;

import com.grad.onlinecatalog.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, String> {
}
