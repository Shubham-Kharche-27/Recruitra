package com.Shubham.Recruitra.Entity;

import com.Shubham.Recruitra.Entity.Enums.ApplicationStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId")
    @JsonBackReference(value = "jobReference")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicantId")
    @JsonBackReference(value = "applicantReference")
    private Applicant applicant;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;
    private LocalDateTime appliedAt;
    private String notes;

    @PrePersist
    public void setAppliedAt() {
        appliedAt = LocalDateTime.now();
    }

    public Application(Long applicationId, Job job, Applicant applicant, ApplicationStatus applicationStatus, LocalDateTime appliedAt, String notes) {
        this.applicationId = applicationId;
        this.job = job;
        this.applicant = applicant;
        this.applicationStatus = applicationStatus;
        this.appliedAt = appliedAt;
        this.notes = notes;
    }

    public Application() {
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
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
