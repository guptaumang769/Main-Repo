package com.job.firstJobApp.jobs;

import java.util.List;

public interface JobService {
	
	List<Job> findAll();
	
	void createJob(Job job);

	Job findJobById(Long id);

	boolean deleteJob(Long id);

	boolean updateJob(Long id, Job updatedJob);

}
