package com.ip.mbip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    @GetMapping("/calendar")
    public String showCalendar() {
        // Iterable<Recycle> recycleList = recycleService.findAll(); // Assuming you have a service for retrieving data
        return "calendar";
    }

}
