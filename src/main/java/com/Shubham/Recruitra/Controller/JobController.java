package com.Shubham.Recruitra.Controller;

import com.Shubham.Recruitra.Dto.JobDto;
import com.Shubham.Recruitra.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/get")
    public ResponseEntity<Page<JobDto>> getAllJobs(
            @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3")int pageSize,
            @RequestParam(defaultValue = "jobId")String sortBy
    ){
        return new ResponseEntity<>(jobService.getAllJobData(pageNum-1,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{jobId}")
    public ResponseEntity<JobDto> getJobById(@PathVariable Long jobId){
        return new ResponseEntity<>(jobService.getJobById(jobId),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createJob(@RequestBody JobDto jobDto){
        return new ResponseEntity<>(jobService.createJobData(jobDto),HttpStatus.CREATED);
    }

    @PutMapping("/put/{jobId}")
    public ResponseEntity<String> updateJob(@PathVariable Long jobId,@RequestBody JobDto jobDto){
        return new ResponseEntity<>(jobService.updateJobData(jobId, jobDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable Long jobId){
        return new ResponseEntity<>(jobService.deleteJobData(jobId),HttpStatus.NO_CONTENT);
    }

}
