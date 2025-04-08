package ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Table
@Entity(name = "Feedback_from_student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Feedback {
    @Id
    @Column(name = "feedback_id",length = 46)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedback_id;
    @Column(name = "sc_number",nullable = false)
    private String scNumber;
    @Column(name = "company_name")
    private String company_name;
    @Column(name = "feedback_notes",columnDefinition = "TEXT", nullable = false)
    private String feedback;
    @Column(name = "submit_at")  // Match exactly with your database column
    private LocalDateTime submittedAt = LocalDateTime.now();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date createdDate;

    // Keep this
    public Feedback(Long feedbackId, String scNumber, String companyName, String feedback) {
        this.feedback_id = feedbackId;
        this.scNumber = scNumber;
        this.company_name = companyName;
        this.feedback = feedback;
        this.submittedAt = LocalDateTime.now();  // Auto-set timestamp
    }

    public void setSc_number(String sc123) {
    }


}