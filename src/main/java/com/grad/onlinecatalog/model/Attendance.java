package com.grad.onlinecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attendanceId;

    private String attendance;

    @ManyToMany(mappedBy = "attendances")
    private List<Student> students;

    private Date attendanceDate;
}
