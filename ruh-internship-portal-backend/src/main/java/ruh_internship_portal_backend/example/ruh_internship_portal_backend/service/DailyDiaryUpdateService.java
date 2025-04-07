package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service;

import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.DailyDiaryUpdateDTO;
import java.util.List;

public interface DailyDiaryUpdateService {
    String saveDailyDiaryUpdate(DailyDiaryUpdateDTO dailyDiaryUpdateDTO);

    String updateDailyDiaryUpdate(DailyDiaryUpdateDTO dailyDiaryUpdateDTO);

    List<DailyDiaryUpdateDTO> getDiaryEntriesByScNumber(String sc_number);
}
