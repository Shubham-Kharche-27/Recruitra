package com.Shubham.Recruitra.Service;

import com.Shubham.Recruitra.Dto.ApplicantDto;
import com.Shubham.Recruitra.Entity.Applicant;
import com.Shubham.Recruitra.Exception.ApplicantExistException;
import com.Shubham.Recruitra.Exception.ApplicantNotFoundException;
import com.Shubham.Recruitra.Repository.ApplicantRepo;
import com.Shubham.Recruitra.Service.Email.EmailService;
import jakarta.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepo applicantRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmailService emailService;

    public Page<ApplicantDto> getAllApplicantData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Applicant> applicantPage = applicantRepo.findAll(pageable);
        return applicantPage.map(Applicant -> modelMapper.map(Applicant, ApplicantDto.class));
    }

    public ApplicantDto getApplicantById(Long applicantId) {
        Applicant applicant = applicantRepo.findById(applicantId)
                .orElseThrow(() -> new ApplicantNotFoundException("Applicant does not exist!"));
        return modelMapper.map(applicant,ApplicantDto.class);
    }

    public String createApplicantData(ApplicantDto applicantDto){
        if(applicantRepo.existsByApplicantFullName(applicantDto.getApplicantFullName())){
            throw new ApplicantExistException("Applicant already registered!");
        }
        Applicant applicant = modelMapper.map(applicantDto,Applicant.class);
        applicantRepo.save(applicant);
        try{
            emailService.sendWelcomeEmailToApplicant(applicantDto.getApplicantEmail(),applicantDto.getApplicantFullName());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "Applicant created successfully!";
    }

    public String updateApplicantData(Long applicantId,ApplicantDto applicantDto){
        Applicant applicant = applicantRepo.findById(applicantId)
                .orElseThrow(()->new ApplicantNotFoundException("Applicant does not exists!"));
        if(applicantDto.getApplicantFullName()!=null){
            applicant.setApplicantFullName(applicantDto.getApplicantFullName());
        }
        if(applicantDto.getApplicantEmail()!=null){
            applicant.setApplicantEmail(applicantDto.getApplicantEmail());
        }
        if(applicantDto.getApplicantPhoneNum()!=null){
            applicant.setApplicantFullName(applicantDto.getApplicantPhoneNum());
        }
        if(applicantDto.getApplicantResumeLink()!=null){
            applicant.setApplicantResumeLink(applicantDto.getApplicantResumeLink());
        }
        if(applicantDto.getProfileSummary()!=null){
            applicant.setProfileSummary(applicantDto.getProfileSummary());
        }
        if(applicantDto.getApplicantSkills()!=null){
            applicant.setApplicantSkills(applicantDto.getApplicantSkills());
        }
        applicantRepo.save(applicant);
        return "Applicant data updated successfully!";
    }

    public String deleteApplicantData(Long applicantId){
        Applicant applicant = applicantRepo.findById(applicantId)
                .orElseThrow(()->new ApplicantNotFoundException("Applicant does not exists!"));
        applicantRepo.deleteById(applicantId);
        return "Applicant deleted successfully!";
    }

}
