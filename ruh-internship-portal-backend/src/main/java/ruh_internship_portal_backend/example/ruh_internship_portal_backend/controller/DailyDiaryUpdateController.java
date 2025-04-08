package ruh_internship_portal_backend.example.ruh_internship_portal_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.DailyDiaryUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.DailyDiaryUpdateService;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/diaryUpdate/")
public class DailyDiaryUpdateController {

    @Autowired
    private DailyDiaryUpdateService dailyDiaryUpdateService;

    @PostMapping("/daily/save")
    public ResponseEntity<Map<String, String>> saveDailyDiaryUpdate(@RequestBody DailyDiaryUpdateDTO dailyDiaryUpdateDTO) {
        Map<String, String> response = new HashMap<>();
        try {
            String result = dailyDiaryUpdateService.saveDailyDiaryUpdate(dailyDiaryUpdateDTO);
            response.put("message", result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/update")
    public String updateDailyDiaryUpdate(@RequestBody DailyDiaryUpdateDTO dailyDiaryUpdateDTO) {
        return dailyDiaryUpdateService.updateDailyDiaryUpdate(dailyDiaryUpdateDTO);
    }
}