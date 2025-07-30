package com.Shubham.Recruitra.Controller;

import com.Shubham.Recruitra.Dto.ApplicationDto;
import com.Shubham.Recruitra.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/get")
    public ResponseEntity<Page<ApplicationDto>> getAllApplications(
            @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3")int pageSize,
            @RequestParam(defaultValue = "applicationId")String sortBy
    ){
        return new ResponseEntity<>(applicationService.getAllApplicationData(pageNum-1,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{applicationId}")
    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable Long applicationId){
        return new ResponseEntity<>(applicationService.getApplicationDataById(applicationId),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createApplication(@RequestBody ApplicationDto applicationDto){
        return new ResponseEntity<>(applicationService.createApplicationData(applicationDto),HttpStatus.CREATED);
    }

    @PutMapping("/put/{applicationId}")
    public ResponseEntity<String> updateApplication(@PathVariable Long applicationId,@RequestBody ApplicationDto applicationDto){
        return new ResponseEntity<>(applicationService.updateApplicationData(applicationId,applicationDto),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{applicationId}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long applicationId){
        return new ResponseEntity<>(applicationService.deleteApplicationData(applicationId),HttpStatus.NO_CONTENT);
    }
}
