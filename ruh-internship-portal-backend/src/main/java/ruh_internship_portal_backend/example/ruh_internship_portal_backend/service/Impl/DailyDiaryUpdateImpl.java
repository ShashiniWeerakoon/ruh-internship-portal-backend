package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.DailyDiaryUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.DailyDiaryUpdate;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo.DailyDiaryUpdateRepo;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.DailyDiaryUpdateService;

@Service
public class DailyDiaryUpdateImpl implements DailyDiaryUpdateService {
    @Autowired
    private DailyDiaryUpdateRepo dailyDiaryUpdateRepo;

    @Override
    public String saveDailyDiaryUpdate(DailyDiaryUpdateDTO dailyDiaryUpdateDTO) {
        DailyDiaryUpdate dailyDiaryUpdate = new DailyDiaryUpdate(
                dailyDiaryUpdateDTO.getId(),
                dailyDiaryUpdateDTO.getSc_number(),
                dailyDiaryUpdateDTO.getDate(),
                dailyDiaryUpdateDTO.getNotes(),
                dailyDiaryUpdateDTO.getSubmittedAt()
        );
        dailyDiaryUpdateRepo.save(dailyDiaryUpdate);
        return "save";
    }
}
