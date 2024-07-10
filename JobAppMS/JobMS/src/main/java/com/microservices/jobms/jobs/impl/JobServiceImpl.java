package com.microservices.jobms.jobs.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservices.jobms.jobs.Job;
import com.microservices.jobms.jobs.JobRepository;
import com.microservices.jobms.jobs.JobService;

@Service
public class JobServiceImpl implements JobService {
	
	//private List<Job> jobs = new ArrayList<>();
	JobRepository jobsRepository;
	private Long nextId = 1L;
	
	

	public JobServiceImpl(JobRepository jobsRepository) {
		this.jobsRepository = jobsRepository;
	}

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobsRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		job.setId(nextId++);
		jobsRepository.save(job);
	}

	@Override
	public Job findJobById(Long id) {
		// TODO Auto-generated method stub
		return jobsRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJob(Long id) {
		// TODO Auto-generated method stub
		try {
			jobsRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean updateJob(Long id, Job updatedJob) {
		// TODO Auto-generated method stub
		Optional<Job> jobOptional = jobsRepository.findById(id);
		
		if (jobOptional.isPresent()) {
			Job job = jobOptional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setLocation(updatedJob.getLocation());
			
			jobsRepository.save(job);
			
			return true;
		}
		return false;
	}

}
