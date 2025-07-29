package com.Shubham.Recruitra.Controller;

import com.Shubham.Recruitra.Dto.CompanyDto;
import com.Shubham.Recruitra.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/get")
    public ResponseEntity<Page<CompanyDto>> getAllCompany(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "companyId") String sortBy
    ) {
        return new ResponseEntity<>(companyService.getAllCompanyData(pageNum - 1, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{companyId}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long companyId){
        return new ResponseEntity<>(companyService.getCompanyDataById(companyId),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createCompany(@RequestBody CompanyDto companyDto){
        return new ResponseEntity<>(companyService.createCompanyData(companyDto),HttpStatus.CREATED);
    }

    @PutMapping("/put/{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable Long companyId,@RequestBody CompanyDto companyDto){
        return new ResponseEntity<>(companyService.updateCompanyData(companyId,companyDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId){
        return new ResponseEntity<>(companyService.deleteCompany(companyId),HttpStatus.NO_CONTENT);
    }
}
