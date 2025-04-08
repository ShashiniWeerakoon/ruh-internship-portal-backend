package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.FeedbackDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.request.FeedbackUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.Feedback;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo.FeedbackRepo;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.FeedbackService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackImpl implements FeedbackService {
    @Autowired
    private FeedbackRepo feedbackRepo;


    @Override
    public String saveFeedback(FeedbackDTO feedbackDTO) {
        try {
            Feedback feedback = new Feedback(
                    feedbackDTO.getFeedback_id(),
                    feedbackDTO.getSc_number(),
                    feedbackDTO.getCompany_name(),
                    feedbackDTO.getFeedback()
            );
            feedbackRepo.save(feedback);
            return "Feedback saved successfully.";
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to save feedback. Database error: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred while saving feedback: " + e.getMessage());
        }
    }


    @Override
    public String updateFeedback(FeedbackUpdateDTO feedbackUpdateDTO) {
        if(feedbackRepo.existsById(feedbackUpdateDTO.getFeedback_id())){
            Feedback feedback = feedbackRepo.getReferenceById(feedbackUpdateDTO.getFeedback_id());
            feedback.setFeedback(feedbackUpdateDTO.getFeedback());
            feedbackRepo.save(feedback);
            return feedbackUpdateDTO.getFeedback_id() + " feedback updated successfully.";

        }else{
            throw new RuntimeException("Feedback not found");
        }
    }

    @Override
    public List<FeedbackDTO> getAllFeedback() throws JsonProcessingException {
        List<Feedback> feedbackList = feedbackRepo.findAll();
        List<FeedbackDTO> feedbackDTOList = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            feedbackDTO.setFeedback_id(feedback.getFeedback_id());
            feedbackDTO.setSc_number(feedback.getScNumber());
            feedbackDTO.setCompany_name(feedback.getCompany_name());
            feedbackDTO.setFeedback(feedback.getFeedback());
            feedbackDTO.setCreatedDate(feedback.getCreatedDate());
            feedbackDTOList.add(feedbackDTO);
        }
        return feedbackDTOList;
    }

}