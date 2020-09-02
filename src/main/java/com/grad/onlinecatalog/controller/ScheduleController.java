package com.grad.onlinecatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ScheduleController {
    @GetMapping("schedule")
    public String showSchedule() {
        return "schedule/showschedule";
    }
}
