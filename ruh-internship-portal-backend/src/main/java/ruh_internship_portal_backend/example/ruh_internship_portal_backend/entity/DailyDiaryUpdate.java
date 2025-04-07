package ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;



@Table(
        name ="Daily_Diary_Update" ,
        indexes = @Index(columnList = "sc_number")
)
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
    @NotBlank(message = "SC Number is required")

    private String sc_number;

    @Column(name = "date")
    private Date date;

    @Column(name = "notes",columnDefinition = "TEXT", nullable = false)
    @NotBlank(message = "Notes cannot be empty")

    private String Notes;

    @Column(name = "submit_at")
    @CreationTimestamp
    private LocalDateTime submittedAt = LocalDateTime.now();

}
