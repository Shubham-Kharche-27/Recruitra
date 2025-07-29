package com.Shubham.Recruitra.Repository;

import com.Shubham.Recruitra.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
