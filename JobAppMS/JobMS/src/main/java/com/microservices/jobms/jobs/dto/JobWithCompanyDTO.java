package com.microservices.jobms.jobs.dto;

import com.microservices.jobms.jobs.Job;
import com.microservices.jobms.jobs.external.Company;

public class JobWithCompanyDTO {
	
	private Job job;
	private Company company;
	
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	

}