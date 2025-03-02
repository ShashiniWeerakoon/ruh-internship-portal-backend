package ruh_internship_portal_backend.example.ruh_internship_portal_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.DailyDiaryUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.DailyDiaryUpdateService;


@RestController
@CrossOrigin
@RequestMapping("/api/dailyDiaryUpdate")
public class DailyDiaryUpdateController {

    @Autowired
    private DailyDiaryUpdateService dailyDiaryUpdateService;

    @RequestMapping("/save")
    public String saveDailyDiaryUpdate(@RequestBody DailyDiaryUpdateDTO dailyDiaryUpdateDTO) {
        dailyDiaryUpdateService.saveDailyDiaryUpdate(dailyDiaryUpdateDTO);
        return "save";
    }

}
