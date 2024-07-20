package com.microservices.jobms.jobs;

import java.util.List;

import com.microservices.jobms.jobs.dto.JobWithCompanyDTO;

public interface JobService {
	
	List<JobWithCompanyDTO> findAll();
	
	void createJob(Job job);

	Job findJobById(Long id);

	boolean deleteJob(Long id);

	boolean updateJob(Long id, Job updatedJob);

}
