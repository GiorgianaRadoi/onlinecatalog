package com.grad.onlinecatalog.service;

import com.grad.onlinecatalog.model.Attendance;
import com.grad.onlinecatalog.model.Grade;
import com.grad.onlinecatalog.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IAttendanceService")
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> findAll(){return attendanceRepository.findAll();};

    public Attendance findById(Integer id) {
        Optional<Attendance> attendance = attendanceRepository.findById(id);
        if (attendance.isPresent()) {
            return attendance.get();
        }

        return null;
    }

    public void deleteById(Integer id) {
        attendanceRepository.deleteById(id);
    }

    public List<Attendance> findByAttendanceId(Integer attendanceId){return attendanceRepository.findAllByStudentId( attendanceId );}
}
