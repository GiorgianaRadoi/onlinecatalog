package com.grad.onlinecatalog.controller;

import com.grad.onlinecatalog.model.SchoolGroup;
import com.grad.onlinecatalog.model.SchoolUnit;
import com.grad.onlinecatalog.repository.SchoolUnitRepository;
import com.grad.onlinecatalog.service.SchoolUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SchoolUnitController {

    @Autowired
    private SchoolUnitService schoolUnitService;

    @GetMapping("allschoolunits")
    public String showAllGroups(Model model) {
        List<SchoolUnit> schoolUnits = schoolUnitService.findAll();
        model.addAttribute("schoolunits", schoolUnits);
        return "schoolunit/showallschoolunits";
    }

    @GetMapping("/addschoolunit")
    public String addSchoolUnit(Model model) {
        model.addAttribute("schoolunit", new SchoolUnit()); // initial bind with the form, to say to the webpage
        return "schoolunit/addschoolunit";
    }

    @PostMapping("/addschoolunit")
    public String addSchoolUnit(@ModelAttribute SchoolUnit schoolUnit) {
//        System.out.println(student);
        schoolUnitService.save(schoolUnit);
        return "redirect:/allschoolunits";

    }

}
