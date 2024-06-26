package com.job.firstJobApp.companies;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.job.firstJobApp.jobs.Job;
import com.job.firstJobApp.reviews.Reviews;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String aboutCompany;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Job> jobs;
	
	@OneToMany(mappedBy = "company")
	private List<Reviews> reviews;
	
	public Company() {
	}

	public Company(Long id, String name, String aboutCompany) {
		this.id = id;
		this.name = name;
		this.aboutCompany = aboutCompany;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
	
	
	
}
