package com.Shubham.Recruitra.Service;

import com.Shubham.Recruitra.Dto.CompanyDto;
import com.Shubham.Recruitra.Entity.Company;
import com.Shubham.Recruitra.Exception.CompanyExistException;
import com.Shubham.Recruitra.Exception.CompanyNotFoundException;
import com.Shubham.Recruitra.Repository.CompanyRepo;
import com.Shubham.Recruitra.Service.Email.EmailService;
import jakarta.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmailService emailService;

    public Page<CompanyDto> getAllCompanyData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Company> companyPage = companyRepo.findAll(pageable);
        return companyPage.map(Company -> modelMapper.map(Company, CompanyDto.class));
    }

    public CompanyDto getCompanyDataById(Long companyId) {
        Company company = companyRepo.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company does not exist!"));
        return modelMapper.map(company, CompanyDto.class);
    }

    public String createCompanyData(CompanyDto companyDto){
        if(companyRepo.existsByCompanyName(companyDto.getCompanyName())){
            throw new CompanyExistException("Company already registered!");
        }
        Company company = modelMapper.map(companyDto,Company.class);
        companyRepo.save(company);
        try{
            emailService.sendWelcomeEmailToCompany(companyDto.getCompanyEmail(),companyDto.getCompanyName());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "Company registered successfully!";
    }

    public String updateCompanyData(Long companyId,CompanyDto companyDto){
        Company company = companyRepo.findById(companyId)
                .orElseThrow(()->new CompanyNotFoundException("Company does not exist!"));
        if(companyDto.getCompanyName()!=null){
            company.setCompanyName(companyDto.getCompanyName());
        }
        if(companyDto.getCompanyIndustry()!=null){
            company.setCompanyIndustry(companyDto.companyIndustry);
        }
        if(companyDto.getCompanyLocation()!=null){
            company.setCompanyLocation(companyDto.getCompanyLocation());
        }
        if(companyDto.getCompanyWebsite()!=null){
            company.setCompanyWebsite(companyDto.getCompanyWebsite());
        }
        if(companyDto.getCompanyEmail()!=null){
            company.setCompanyEmail(companyDto.getCompanyEmail());
        }
        if(companyDto.getContactNum()!=null){
            company.setContactNum(companyDto.getContactNum());
        }
        companyRepo.save(company);
        return "Company data updated successfully!";
    }

    public String deleteCompany(Long companyId){
        Company company = companyRepo.findById(companyId)
                .orElseThrow(()->new CompanyNotFoundException("Company does not exist!"));
        companyRepo.deleteById(companyId);
        return "Company data deleted successfully!";
    }
}
