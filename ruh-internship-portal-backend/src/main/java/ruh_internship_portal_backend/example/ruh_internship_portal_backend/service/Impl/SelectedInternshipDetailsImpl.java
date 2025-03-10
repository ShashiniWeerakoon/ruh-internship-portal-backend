package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.Impl;

import org.springframework.stereotype.Service;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.SelectedInternshipDetailsDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.SelectedInternshipDetails;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo.SelectedInternshipDetailsRepo;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.SelectedInternshipDetailsService;

@Service
public class SelectedInternshipDetailsImpl implements SelectedInternshipDetailsService {

    private final SelectedInternshipDetailsRepo selectedInternshipDetailsRepo;

    public SelectedInternshipDetailsImpl(SelectedInternshipDetailsRepo selectedInternshipDetailsRepo) {
        this.selectedInternshipDetailsRepo = selectedInternshipDetailsRepo;
    }

    @Override
    public String getSelectedInternshipDetails(SelectedInternshipDetailsDTO selectedInternshipDetailsDTO) {
        SelectedInternshipDetails selectedInternshipDetails = new SelectedInternshipDetails(
                selectedInternshipDetailsDTO.getSelection_id(),
                selectedInternshipDetailsDTO.getSc_number(),
                selectedInternshipDetailsDTO.getEmail(),
                selectedInternshipDetailsDTO.getPhoneNumber(),
                selectedInternshipDetailsDTO.getCompany(),
                selectedInternshipDetailsDTO.getDesignation(),
                selectedInternshipDetailsDTO.getAppointment_letter_pdf(),
                selectedInternshipDetailsDTO.getStart_date(),
                selectedInternshipDetailsDTO.getEnd_date(),
                selectedInternshipDetailsDTO.getSupervisor_name()
        );

        selectedInternshipDetailsRepo.save(selectedInternshipDetails);
        return "save";
    }

    @Override
    public String updateSelectedInternshipDetails(SelectedInternshipDetailsDTO selectedInternshipDetailsDTO) {
        if (selectedInternshipDetailsRepo.existsById(selectedInternshipDetailsDTO.getSelection_id())) {
            SelectedInternshipDetails selectedInternshipDetails = selectedInternshipDetailsRepo.getReferenceById(selectedInternshipDetailsDTO.getSelection_id());
            selectedInternshipDetails.setEmail(selectedInternshipDetailsDTO.getEmail());
            selectedInternshipDetails.setPhoneNumber(selectedInternshipDetailsDTO.getPhoneNumber());
            selectedInternshipDetails.setSupervisor_name(selectedInternshipDetailsDTO.getSupervisor_name());
            return selectedInternshipDetailsDTO.getSc_number() + " updated successfully";
        } else {
            throw new RuntimeException("SelectedInternshipDetails not found");
        }
    }
}
