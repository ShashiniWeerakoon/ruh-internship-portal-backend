package ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DailyDiaryUpdateDTO {
    private Long id;

    private String sc_number;

    private Date date;

    private String Notes;

    private LocalDateTime submittedAt = LocalDateTime.now();
}
