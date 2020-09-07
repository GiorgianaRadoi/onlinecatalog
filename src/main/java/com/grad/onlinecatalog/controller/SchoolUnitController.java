package com.grad.onlinecatalog.controller;

import com.grad.onlinecatalog.model.SchoolGroup;
import com.grad.onlinecatalog.model.SchoolUnit;
import com.grad.onlinecatalog.repository.SchoolUnitRepository;
import com.grad.onlinecatalog.service.SchoolUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
