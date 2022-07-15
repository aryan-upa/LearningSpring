package com.LearningSpring.SchoolProject.controller;

import com.LearningSpring.SchoolProject.model.Holiday;
import com.LearningSpring.SchoolProject.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @Autowired
    private HolidayRepository holidayRepository;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable(name = "display") String toDisplay, Model model) {

        if(null != toDisplay) {
            if (toDisplay.equals("all")) {
                model.addAttribute("central", true);
                model.addAttribute("festival", true);
                model.addAttribute("state", true);
            } else
                model.addAttribute(toDisplay, true);
        }

        List<Holiday> holidayList = holidayRepository.getAllHolidays();

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    holidayList
                            .stream()
                            .filter(isHolidayType(type))
                            .collect(Collectors.toList()));
        }
        return "/holidays";
    }

    public static Predicate<Holiday> isHolidayType(Holiday.Type type) {
        return holiday -> holiday.getType().equals(type);
    }

}
