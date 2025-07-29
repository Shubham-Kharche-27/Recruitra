package com.Shubham.Recruitra.Dto;

import com.Shubham.Recruitra.Entity.Application;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ApplicantDto {
    private Long applicantId;
    private String applicantFullName;
    private String applicantEmail;
    private String applicantPhoneNum;
    private String applicantResumeLink;
    private String profileSummary;
    private String applicantSkills;
    private Set<Application> applicationSet = new HashSet<>();

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

    public Set<Application> getApplicationSet() {
        return applicationSet;
    }

    public void setApplicationSet(Set<Application> applicationSet) {
        this.applicationSet = applicationSet;
    }
}
