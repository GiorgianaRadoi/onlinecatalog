package com.grad.onlinecatalog.controller;

import com.grad.onlinecatalog.model.SchoolGroup;
import com.grad.onlinecatalog.model.Student;
import com.grad.onlinecatalog.service.SchoolGroupService;
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
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolGroupService schoolGroupService;

    @GetMapping("allstudents")
    public String showAllStudents(Model model) {

        List<Student> studentList = studentService.findAll();
        model.addAttribute("students", studentList);

        return "student/showallstudents";
    }

//    @GetMapping("/addstudent")
//    public String addStudent(Model model) {
//        model.addAttribute("schoolgroups", schoolGroupService.findAll());
//        model.addAttribute("student", new Student()); // initial bind with the form, to say to the webpage
//        // what is the type of student th:object
//
//        return "student/addstudent";
//    }
//
//    @PostMapping("/addstudent")
//    public String addStudent(@ModelAttribute Student student) {
////        System.out.println(student);
//        studentService.save(student);
//        return "redirect:/allstudents";
//        //TODO: show in same page on the left all students, on the right add a new student
//    }

    @GetMapping("/{id}/addstudent")//ruta care trebuie sa se regasesca in html
    public String addStudent(Model model, @PathVariable Integer id) {
        Student student = new Student();
        model.addAttribute( "schoolgroup",
                schoolGroupService.findById( id ));
        student.setSchoolGroup( schoolGroupService.findById( id ) );
        model.addAttribute( "student", student );
        return "student/addstudent";
    }

    @PostMapping("/{id}/addstudent")
    public String addStudent(@ModelAttribute Student student, @PathVariable Integer id) {
        student.setSchoolGroup( schoolGroupService.findById( id ) );
        studentService.save( student);
        return "redirect:/group/"+id+"/students";

    }

    @GetMapping("/editstudent/{id}")
    public String editStudent(Model model, @PathVariable Integer id) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student); // initial bind with the form, to say to the webpage
        model.addAttribute("schoolgroups",
                schoolGroupService.findByUnitId( id ));

        return "student/editstudent";
    }

    @PostMapping("/editstudent/{id}")
    public String editStudent(@ModelAttribute Student student, @PathVariable Integer id) {
        student.setSchoolGroup( schoolGroupService.findById( id ) );
        studentService.save(student);
//
        return "redirect:/group/"+id+"/students";

    }

    @GetMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);
        return "redirect:/group/"+id+"/students";
    }
}
