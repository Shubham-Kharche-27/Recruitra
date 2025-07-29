package com.Shubham.Recruitra.Dto;

import com.Shubham.Recruitra.Entity.Application;
import com.Shubham.Recruitra.Entity.Company;
import com.Shubham.Recruitra.Entity.Enums.EmpType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class JobDto {
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private EmpType employeeType;
    private String salaryRange;
    private String experienceLevel;
    private String skillRequired;
    private LocalDate jobDeadline;
    private Long companyId;
    private Set<Application> applicationSet = new HashSet<>();

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public EmpType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmpType employeeType) {
        this.employeeType = employeeType;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getSkillRequired() {
        return skillRequired;
    }

    public void setSkillRequired(String skillRequired) {
        this.skillRequired = skillRequired;
    }

    public LocalDate getJobDeadline() {
        return jobDeadline;
    }

    public void setJobDeadline(LocalDate jobDeadline) {
        this.jobDeadline = jobDeadline;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Set<Application> getApplicationSet() {
        return applicationSet;
    }

    public void setApplicationSet(Set<Application> applicationSet) {
        this.applicationSet = applicationSet;
    }
}
