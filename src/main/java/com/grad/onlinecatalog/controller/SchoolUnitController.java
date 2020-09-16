package com.grad.onlinecatalog.controller;

import com.grad.onlinecatalog.model.SchoolGroup;
import com.grad.onlinecatalog.model.SchoolUnit;
import com.grad.onlinecatalog.repository.SchoolUnitRepository;
import com.grad.onlinecatalog.service.SchoolGroupService;
import com.grad.onlinecatalog.service.SchoolUnitService;
import com.grad.onlinecatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class SchoolUnitController {

    @Autowired
    private SchoolUnitService schoolUnitService;

    @Autowired
    private SchoolGroupService schoolGroupService;

    @Autowired
    private StudentService studentService;

    @GetMapping("allschoolunits")
    public String showAllGroups(Model model) {
        List<SchoolUnit> schoolUnits = schoolUnitService.findAll();
        model.addAttribute( "schoolunits", schoolUnits );
        return "schoolunit/showallschoolunits";
    }

    @GetMapping("/addschoolunit")
    public String addSchoolUnit(Model model) {
        model.addAttribute( "schoolunit", new SchoolUnit() ); // initial bind with the form, to say to the webpage
        return "schoolunit/addschoolunit";
    }

    @PostMapping("/addschoolunit")
    public String addSchoolUnit(@ModelAttribute SchoolUnit schoolUnit) {
        schoolUnitService.save( schoolUnit );
        return "redirect:/allschoolunits";

    }

    @GetMapping("/viewschoolunit/{id}")
    public String showSchoolUnit(Model model, @PathVariable Integer id) {
        SchoolUnit schoolUnit = schoolUnitService.findById( id );
        model.addAttribute( "schoolunit", schoolUnit );
        model.addAttribute( "schoolgroups",
                schoolGroupService.findByUnitId( id ) );
        return "schoolunit/viewschoolunit";
    }


    @GetMapping("/editschoolunit/{id}")
    public String editSchoolUnit(Model model, @PathVariable Integer id) {
        SchoolUnit schoolUnit = schoolUnitService.findById(id);
        model.addAttribute("schoolunit", schoolUnit); // initial bind with the form, to say to the webpage what is the type of student th:object
        return "schoolgroup/editschoolunit";
    }

    @PostMapping("/editschoolunit/{id}")
    public String editSchoolUnit(@ModelAttribute SchoolUnit schoolUnit, @PathVariable Integer id) {
        schoolUnitService.save(schoolUnit); // save it again. SAVE acts as UPDATE
        return "redirect:/showallschoolunits";
    }

    @GetMapping("/deleteschoolunit/{id}")
    public String deleteSchoolUnit(@PathVariable Integer id) {
        schoolUnitService.deleteById(id);
        return "redirect:/showallschoolunits"; // forward
    }

}
