package com.Shubham.Recruitra.Service;

import com.Shubham.Recruitra.Dto.ApplicationDto;
import com.Shubham.Recruitra.Entity.Applicant;
import com.Shubham.Recruitra.Entity.Application;
import com.Shubham.Recruitra.Entity.Job;
import com.Shubham.Recruitra.Exception.ApplicantNotFoundException;
import com.Shubham.Recruitra.Exception.ApplicationNotFoundException;
import com.Shubham.Recruitra.Exception.JobNotFoundException;
import com.Shubham.Recruitra.Repository.ApplicantRepo;
import com.Shubham.Recruitra.Repository.ApplicationRepo;
import com.Shubham.Recruitra.Repository.JobRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepo applicationRepo;

    @Autowired
    private ApplicantRepo applicantRepo;

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Page<ApplicationDto> getAllApplicationData(int pageNum, int pageSize, String sortBy){
        Pageable pageable = PageRequest.of(pageNum,pageSize, Sort.by(sortBy));
        Page<Application> applicationPage = applicationRepo.findAll(pageable);
        return applicationPage.map(Application->modelMapper.map(Application,ApplicationDto.class));
    }

    public ApplicationDto getApplicationDataById(Long applicationId){
        Application application = applicationRepo.findById(applicationId)
                .orElseThrow(()->new ApplicationNotFoundException("Application does not exist!"));
        return modelMapper.map(application,ApplicationDto.class);
    }

    public String createApplicationData(ApplicationDto applicationDto){
        if(applicationDto==null){
            throw new RuntimeException("Application must be empty!");
        }

        Application application = modelMapper.map(applicationDto,Application.class);
        Job job = jobRepo.findById(applicationDto.getJobId())
                .orElseThrow(()->new JobNotFoundException("Job does not exist!"));
        application.setJob(job);
        Applicant applicant = applicantRepo.findById(applicationDto.getApplicantId())
                .orElseThrow(()->new ApplicantNotFoundException("Applicant does not exist!"));
        application.setApplicant(applicant);
        applicationRepo.save(application);
        return "Application submitted successfully!";
    }

    public String updateApplicationData(Long applicationId,ApplicationDto applicationDto){
        Application application = applicationRepo.findById(applicationId)
                .orElseThrow(()->new ApplicantNotFoundException("Application does not exist!"));
        if(applicationDto.getApplicationStatus()!=null){
            application.setApplicationStatus(applicationDto.getApplicationStatus());
        }
        if(applicationDto.getNotes()!=null){
            application.setNotes(applicationDto.getNotes());
        }
        applicationRepo.save(application);
        return "Application updated successfully!";
    }

    public String deleteApplicationData(Long applicationId){
        Application application = applicationRepo.findById(applicationId)
                .orElseThrow(()->new ApplicationNotFoundException("Application does not exist!"));
        applicationRepo.deleteById(applicationId);
        return "Application deleted successfully!";
    }
}
