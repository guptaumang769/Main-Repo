package com.microservices.jobms.jobs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.jobms.jobs.dto.JobDTO;

@RestController
@RequestMapping("/jobs")
public class JobController {
	private JobService jobService;
		
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	//@GetMapping("/jobs")
	@GetMapping
	public ResponseEntity<List<JobDTO>> findAll() {
		return ResponseEntity.ok(jobService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job Added Successfully", HttpStatus.CREATED);
		
	}
	
	//@GetMapping("/jobs/{id}")
	@GetMapping("/{id}")
	public ResponseEntity<JobDTO> findJobById(@PathVariable Long id) {
		JobDTO jobDTO = jobService.findJobById(id);
		if(jobDTO != null) 
			return new ResponseEntity<>(jobDTO, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
		boolean deleted = jobService.deleteJob(id);
		if(deleted) {
			return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK); 
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	//@RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
		boolean updated = jobService.updateJob(id, updatedJob);
		if(updated)
			return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
