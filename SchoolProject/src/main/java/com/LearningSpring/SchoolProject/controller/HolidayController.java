package com.LearningSpring.SchoolProject.controller;

import com.LearningSpring.SchoolProject.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @GetMapping("/holidays")
    public String displayHolidays(
            @RequestParam(required = false) boolean central, @RequestParam(required = false) boolean state,
            @RequestParam(required = false) boolean festival, Model model) {

        model.addAttribute("central", central);
        model.addAttribute("festival", festival);
        model.addAttribute("state", state);

        List<Holiday> holidayList = List.of(
                new Holiday("1 Jan", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday("26 Jan", "Republic Day", Holiday.Type.CENTRAL),
                new Holiday("15 Apr", "Good Friday", Holiday.Type.FESTIVAL),
                new Holiday("15 Aug", "Independence Day", Holiday.Type.CENTRAL),
                new Holiday("2 Oct", "Mahatma Gandhi's Birthday", Holiday.Type.CENTRAL),
                new Holiday("24 Nov", "Guru Teg Bahadur Martyrdom Day", Holiday.Type.STATE),
                new Holiday("25 Dec", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday("31 Dec", "Last Working Day of Year", Holiday.Type.FESTIVAL)
        );
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
