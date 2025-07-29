package com.Shubham.Recruitra.Repository;

import com.Shubham.Recruitra.Entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepo extends JpaRepository<Applicant, Long> {
}
