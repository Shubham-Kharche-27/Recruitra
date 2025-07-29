package com.Shubham.Recruitra.Repository;

import com.Shubham.Recruitra.Entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
}
