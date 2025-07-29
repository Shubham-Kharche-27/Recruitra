package com.Shubham.Recruitra.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantId;
    private String applicantFullName;
    private String applicantEmail;
    private String applicantPhoneNum;
    private String applicantResumeLink;
    private String profileSummary;
    private String applicantSkills;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Application> applicationSet = new HashSet<>();

    @PrePersist
    public void setCreatedAt() {
        createdAt = LocalDateTime.now();
    }

    public Applicant(Long applicantId, String applicantFullName, String applicantEmail, String applicantPhoneNum, String applicantResumeLink, String profileSummary, String applicantSkills, LocalDateTime createdAt, Set<Application> applicationSet) {
        this.applicantId = applicantId;
        this.applicantFullName = applicantFullName;
        this.applicantEmail = applicantEmail;
        this.applicantPhoneNum = applicantPhoneNum;
        this.applicantResumeLink = applicantResumeLink;
        this.profileSummary = profileSummary;
        this.applicantSkills = applicantSkills;
        this.createdAt = createdAt;
        this.applicationSet = applicationSet;
    }

    public Applicant() {
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantFullName() {
        return applicantFullName;
    }

    public void setApplicantFullName(String applicantFullName) {
        this.applicantFullName = applicantFullName;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantPhoneNum() {
        return applicantPhoneNum;
    }

    public void setApplicantPhoneNum(String applicantPhoneNum) {
        this.applicantPhoneNum = applicantPhoneNum;
    }

    public String getApplicantResumeLink() {
        return applicantResumeLink;
    }

    public void setApplicantResumeLink(String applicantResumeLink) {
        this.applicantResumeLink = applicantResumeLink;
    }

    public String getProfileSummary() {
        return profileSummary;
    }

    public void setProfileSummary(String profileSummary) {
        this.profileSummary = profileSummary;
    }

    public String getApplicantSkills() {
        return applicantSkills;
    }

    public void setApplicantSkills(String applicantSkills) {
        this.applicantSkills = applicantSkills;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Application> getApplicationSet() {
        return applicationSet;
    }

    public void setApplicationSet(Set<Application> applicationSet) {
        this.applicationSet = applicationSet;
    }
}
