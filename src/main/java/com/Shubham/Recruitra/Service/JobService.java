package com.Shubham.Recruitra.Service;

import com.Shubham.Recruitra.Dto.JobDto;
import com.Shubham.Recruitra.Entity.Company;
import com.Shubham.Recruitra.Entity.Job;
import com.Shubham.Recruitra.Exception.CompanyNotFoundException;
import com.Shubham.Recruitra.Exception.JobNotFoundException;
import com.Shubham.Recruitra.Repository.CompanyRepo;
import com.Shubham.Recruitra.Repository.JobRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CompanyRepo companyRepo;

    public Page<JobDto> getAllJobData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Job> jobPage = jobRepo.findAll(pageable);
        return jobPage.map(Job -> modelMapper.map(Job, JobDto.class));
    }

    public JobDto getJobById(Long jobId) {
        Job job = jobRepo.findById(jobId)
                .orElseThrow(() -> new JobNotFoundException("Job does not exist!"));
        return modelMapper.map(job, JobDto.class);
    }

    public String createJobData(JobDto jobDto) {
        if (jobDto != null) {
            Company company = companyRepo.findById(jobDto.getCompanyId())
                    .orElseThrow(()->new CompanyNotFoundException("Company does not exist!"));
            Job job = modelMapper.map(jobDto, Job.class);
            job.setCompany(company);
            jobRepo.save(job);
            return "Job posted successfully!";
        }
        throw new RuntimeException("Job detail must be empty!");
    }

    public String updateJobData(Long jobId, JobDto jobDto) {
        Job job = jobRepo.findById(jobId)
                .orElseThrow(() -> new JobNotFoundException("Job does not exist!"));
        if (jobDto.getJobTitle() != null) {
            job.setJobTitle(jobDto.getJobTitle());
        }
        if (jobDto.getJobDescription() != null) {
            job.setJobDescription(jobDto.getJobDescription());
        }
        if (jobDto.getJobLocation() != null) {
            job.setJobLocation(jobDto.getJobLocation());
        }
        if (jobDto.getEmployeeType() != null) {
            job.setEmployeeType(jobDto.getEmployeeType());
        }
        if (jobDto.getSalaryRange() != null) {
            job.setSalaryRange(jobDto.getSalaryRange());
        }
        if (jobDto.getExperienceLevel() != null) {
            job.setExperienceLevel(jobDto.getExperienceLevel());
        }
        if (jobDto.getSkillRequired() != null) {
            job.setSkillRequired(jobDto.getSkillRequired());
        }
        if (jobDto.getJobDeadline() != null) {
            job.setJobDeadline(jobDto.getJobDeadline());
        }
        jobRepo.save(job);
        return "Job data updated successfully!";
    }

    public String deleteJobData(Long jobId){
        Job job = jobRepo.findById(jobId)
                .orElseThrow(()->new JobNotFoundException("Job does not exist!"));
        jobRepo.deleteById(jobId);
        return "Job deleted successfully!";
    }
}
