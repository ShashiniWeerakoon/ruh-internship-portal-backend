package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service;

import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.FeedbackDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.request.FeedbackUpdateDTO;

public interface FeedbackService {
    String saveFeedback(FeedbackDTO feedbackDTO);

    String updateFeedback(FeedbackUpdateDTO feedbackUpdateDTO);
}
