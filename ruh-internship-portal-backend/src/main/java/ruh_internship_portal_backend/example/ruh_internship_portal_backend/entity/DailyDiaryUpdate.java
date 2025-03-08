package ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Table
@Entity(name = "Daily_Diary_Update")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DailyDiaryUpdate {
    @Id
    @Column(name = "id",length = 46)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sc_number",nullable = false)
    private String sc_number;
    @Column(name = "date")
    private Date date;
    @Column(name = "notes",columnDefinition = "TEXT", nullable = false)
    private String Notes;
    @Column(name = "submit_at")
    private LocalDateTime submittedAt = LocalDateTime.now();

}
