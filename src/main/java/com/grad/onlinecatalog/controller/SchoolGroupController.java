package com.grad.onlinecatalog.controller;

import com.grad.onlinecatalog.model.SchoolGroup;
import com.grad.onlinecatalog.service.SchoolGroupService;
import com.grad.onlinecatalog.service.SchoolUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SchoolGroupController {

       @Autowired
    private SchoolGroupService schoolGroupService;

       @Autowired
       private SchoolUnitService schoolUnitService;

    @GetMapping("allschoolgroups")
    public String showAllGroups(Model model) {
        List<SchoolGroup> schoolGroups = schoolGroupService.findAll();
        model.addAttribute("schoolgroups", schoolGroups);
        return "schoolgroup/showallschoolgroups";
    }

    @GetMapping("/{id}/addschoolgroup")
    public String addSchoolGroup(Model model, @PathVariable Integer id) {
        SchoolGroup schoolGroup = new SchoolGroup(  );
        schoolGroup.setSchoolUnit( schoolUnitService.findById( id ) );
        model.addAttribute("schoolgroup", schoolGroup); // initial bind with the form, to say to the webpage
        return "schoolgroup/addschoolgroup";
    }

           @PostMapping("/{id}/addschoolgroup")
        public String addSchoolGroup(@ModelAttribute SchoolGroup schoolGroup, @PathVariable Integer id) {
            schoolGroup.setSchoolUnit( schoolUnitService.findById( id ) );
            schoolGroupService.save(schoolGroup);
            return "forward: /viewschoolunit/"+id;

    }

    @GetMapping("/group/{id}/students")
    public String viewStudentsInGroup(Model model, @PathVariable Integer id) {
        model.addAttribute("students", schoolGroupService.findStudentsByGroup(id));
        return "schoolgroup/viewstudents";
    }

    @GetMapping("/editschoolgroup/{id}")
    public String editSchoolGroup(Model model, @PathVariable Integer id) {
        SchoolGroup schoolGroup = schoolGroupService.findById(id);
        model.addAttribute("schoolgroup", schoolGroup); // initial bind with the form, to say to the webpage what is the type of student th:object
        return "schoolgroup/editschoolgroup";
    }

    @PostMapping("/editschoolgroup/{id}")
    public String editSchoolGroup(@ModelAttribute SchoolGroup schoolGroup, @PathVariable Integer id) {
//        SchoolGroup database_schoolgroup = schoolGroupService.findById(id); // ti be able to update that id, get it from database
//        database_schoolgroup.setGroupName(schoolGroup.getGroupName()); // update fields
//        database_schoolgroup.setGroupYear(schoolGroup.getGroupYear());
//        System.out.println(database_schoolgroup);
        schoolGroupService.save(schoolGroup); // save it again. SAVE acts as UPDATE
//        return "redirect:/editstudent/"+id;
        return "redirect:/allschoolgroups";
    }

    @GetMapping("/deleteschoolgroup/{id}")
    public String deleteSchoolGroup(@PathVariable Integer id) {
        schoolGroupService.deleteById(id);
        return "redirect:/allschoolgroups"; // forward
    }

}
