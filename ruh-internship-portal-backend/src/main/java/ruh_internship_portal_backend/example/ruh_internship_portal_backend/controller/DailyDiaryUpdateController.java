package ruh_internship_portal_backend.example.ruh_internship_portal_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.DailyDiaryUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.DailyDiaryUpdateService;
//import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/diaryUpdate/daily")
public class DailyDiaryUpdateController {

    @Autowired
    private DailyDiaryUpdateService dailyDiaryUpdateService;

    @PostMapping("/save")
    public String saveDailyDiaryUpdate(@RequestBody DailyDiaryUpdateDTO dailyDiaryUpdateDTO) {
        dailyDiaryUpdateService.saveDailyDiaryUpdate(dailyDiaryUpdateDTO);
        return "save";
    }

    @PutMapping("/update")
    public String updateDailyDiaryUpdate(@RequestBody DailyDiaryUpdateDTO dailyDiaryUpdateDTO) {
        String message = dailyDiaryUpdateService.updateDailyDiaryUpdate(dailyDiaryUpdateDTO);
        return message;
    }

    @GetMapping("/search")
    //@PreAuthorize("hasRole('ADMIN')")  // Security check
    public List<DailyDiaryUpdateDTO> getDiaryEntriesByScNumber(
            @RequestParam String sc_number
    ) {
        return dailyDiaryUpdateService.getDiaryEntriesByScNumber(sc_number);
    }
}
