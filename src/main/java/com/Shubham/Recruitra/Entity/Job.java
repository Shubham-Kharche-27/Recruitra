package com.Shubham.Recruitra.Entity;

import com.Shubham.Recruitra.Entity.Enums.EmpType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private EmpType employeeType;
    private String salaryRange;
    private String experienceLevel;
    private String skillRequired;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime postedAt;
    private LocalDate jobDeadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    @JsonBackReference
    private Company company;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Application> applicationSet = new HashSet<>();

    @PrePersist
    public void createdAt() {
        postedAt = LocalDateTime.now();
    }

    public Job(Long jobId, String jobTitle, String jobDescription, String jobLocation, EmpType employeeType, String salaryRange, String experienceLevel, String skillRequired, LocalDateTime postedAt, LocalDate jobDeadline, Company company, Set<Application> applicationSet) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobLocation = jobLocation;
        this.employeeType = employeeType;
        this.salaryRange = salaryRange;
        this.experienceLevel = experienceLevel;
        this.skillRequired = skillRequired;
        this.postedAt = postedAt;
        this.jobDeadline = jobDeadline;
        this.company = company;
        this.applicationSet = applicationSet;
    }

    public Job() {
    }

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

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public LocalDate getJobDeadline() {
        return jobDeadline;
    }

    public void setJobDeadline(LocalDate jobDeadline) {
        this.jobDeadline = jobDeadline;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Application> getApplicationSet() {
        return applicationSet;
    }

    public void setApplicationSet(Set<Application> applicationSet) {
        this.applicationSet = applicationSet;
    }
}
