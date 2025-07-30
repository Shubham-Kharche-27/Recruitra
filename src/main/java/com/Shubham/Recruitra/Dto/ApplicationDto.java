package com.Shubham.Recruitra.Dto;

import com.Shubham.Recruitra.Entity.Applicant;
import com.Shubham.Recruitra.Entity.Enums.ApplicationStatus;
import com.Shubham.Recruitra.Entity.Job;

import java.time.LocalDateTime;

import static com.Shubham.Recruitra.Entity.Enums.ApplicationStatus.Pending;

public class ApplicationDto {
    private Long applicationId;
    private Long jobId;
    private Long applicantId;
    private ApplicationStatus applicationStatus = Pending;
    private LocalDateTime appliedAt;
    private String notes;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
