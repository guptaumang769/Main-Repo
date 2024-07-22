package com.microservices.jobms.jobs;

import java.util.List;

import com.microservices.jobms.jobs.dto.JobDTO;

public interface JobService {
	
	List<JobDTO> findAll();
	
	void createJob(Job job);

	JobDTO findJobById(Long id);

	boolean deleteJob(Long id);

	boolean updateJob(Long id, Job updatedJob);

}
