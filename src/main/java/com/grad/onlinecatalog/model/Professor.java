package com.grad.onlinecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int professorId;

    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<SchoolUnit> schoolUnits;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<SchoolGroup> schoolGroups;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Discipline> disciplines;


}
