package com.microservices.jobms.jobs.mapper;

import java.util.List;

import com.microservices.jobms.jobs.Job;
import com.microservices.jobms.jobs.dto.JobDTO;
import com.microservices.jobms.jobs.external.Company;
import com.microservices.jobms.jobs.external.Review;

public class JobMapper {
	
	public static JobDTO mapToJobWithCOmpanyDTO(Job job, Company company, List<Review> reviews) {
		
		JobDTO jobDTO = new JobDTO();
		
		jobDTO.setId(job.getId());
		jobDTO.setDescription(job.getDescription());
		jobDTO.setTitle(job.getTitle());
		jobDTO.setLocation(job.getLocation());
		jobDTO.setMinSalary(job.getMinSalary());
		jobDTO.setMaxSalary(job.getMaxSalary());
		jobDTO.setCompany(company);
		jobDTO.setReview(reviews);
		
		return jobDTO;
	}

}
