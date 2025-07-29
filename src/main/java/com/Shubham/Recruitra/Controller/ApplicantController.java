package com.Shubham.Recruitra.Controller;

import com.Shubham.Recruitra.Dto.ApplicantDto;
import com.Shubham.Recruitra.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/get")
    public ResponseEntity<Page<ApplicantDto>> getAllApplicantData(
            @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3")int pageSize,
            @RequestParam(defaultValue = "applicantId")String sortBy
    ){
        return new ResponseEntity<>(applicantService.getAllApplicantData(pageNum-1,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{applicantId}")
    public ResponseEntity<ApplicantDto> getApplicantDataById(@PathVariable Long applicantId){
        return new ResponseEntity<>(applicantService.getApplicantById(applicantId),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createApplicant(@RequestBody ApplicantDto applicantDto){
        return new ResponseEntity<>(applicantService.createApplicantData(applicantDto),HttpStatus.CREATED);
    }

    @PutMapping("/put/{applicantId}")
    public ResponseEntity<String> updateApplicant(@PathVariable Long applicantId,@RequestBody ApplicantDto applicantDto){
        return new ResponseEntity<>(applicantService.updateApplicantData(applicantId,applicantDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{applicantId}")
    public ResponseEntity<String> deleteApplicant(@PathVariable Long applicantId){
        return new ResponseEntity<>(applicantService.deleteApplicantData(applicantId),HttpStatus.NO_CONTENT);
    }
}
