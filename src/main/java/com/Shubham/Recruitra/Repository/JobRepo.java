package com.Shubham.Recruitra.Repository;

import com.Shubham.Recruitra.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job, Long> {
}
