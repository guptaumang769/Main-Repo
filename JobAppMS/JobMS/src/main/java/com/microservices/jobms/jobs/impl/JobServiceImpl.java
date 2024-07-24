package com.microservices.jobms.jobs.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.jobms.jobs.Job;
import com.microservices.jobms.jobs.JobRepository;
import com.microservices.jobms.jobs.JobService;
import com.microservices.jobms.jobs.clients.CompanyClient;
import com.microservices.jobms.jobs.clients.ReviewClient;
import com.microservices.jobms.jobs.dto.JobDTO;
import com.microservices.jobms.jobs.external.Company;
import com.microservices.jobms.jobs.external.Review;
import com.microservices.jobms.jobs.mapper.JobMapper;

@Service
public class JobServiceImpl implements JobService {
	
	//private List<Job> jobs = new ArrayList<>();
	JobRepository jobsRepository;
	private Long nextId = 1L;
	
	@Autowired
	RestTemplate restTemplate;
	
	private CompanyClient companyCLient;
	
	private ReviewClient reviewClient;

	public JobServiceImpl(JobRepository jobsRepository, CompanyClient companyCLient, ReviewClient reviewClient) {
		this.jobsRepository = jobsRepository;
		this.companyCLient = companyCLient;
		this.reviewClient = reviewClient;
	}

	@Override
	public List<JobDTO> findAll() {
		// TODO Auto-generated method stub
		List<Job> jobs = jobsRepository.findAll();
		
		return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	
	public JobDTO convertToDTO(Job job) {
		
			Company company = companyCLient.getCompany(job.getCompanyId());
			List<Review> reviews = reviewClient.getReviews(job.getCompanyId());
			
			JobDTO jobDTO = JobMapper.mapToJobWithCOmpanyDTO(job, company, reviews);

			return jobDTO;
		
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		job.setId(nextId++);
		jobsRepository.save(job);
	}

	@Override
	public JobDTO findJobById(Long id) {
		// TODO Auto-generated method stub
		Job job = jobsRepository.findById(id).orElse(null);
		return convertToDTO(job);
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
