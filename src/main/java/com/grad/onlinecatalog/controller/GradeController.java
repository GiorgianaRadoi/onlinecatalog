package com.grad.onlinecatalog.controller;

import com.grad.onlinecatalog.model.Grade;
import com.grad.onlinecatalog.model.Student;
import com.grad.onlinecatalog.service.GradeService;
import com.grad.onlinecatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @GetMapping("allgrades")
    public String showAllGrades(Model model, @PathVariable Integer id) {

        model.addAttribute( "students",
                studentService.findByUnitId( id ) );

        return "grade/viewallgrades";
    }

    @GetMapping("/{id}/allgrades")//ruta care trebuie sa se regasesca in html
    public String addGrade(Model model, @PathVariable Integer id) {
        Grade grade = new Grade();
        model.addAttribute( "student",
                studentService.findByUnitId( id ));
        grade.setStudent( studentService.findById( id ) );
        model.addAttribute( "grade", grade );
        return "grade/viewallgrades";
    }

    @PostMapping("/{id}/allgrades")
    public String addGrade(@ModelAttribute Grade grade, @PathVariable Integer id) {
        grade.setStudent( studentService.findById( id ) );
        gradeService.save( grade);
        return "grade/viewallgrades";
    }
}
