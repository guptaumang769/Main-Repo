package com.job.firstJobApp.companies;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.job.firstJobApp.jobs.Job;

import jakarta.persistence.*;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String employeeSize;
	private String aboutCompany;
	private String estDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Job> jobs;
	
	public Company() {
	}

	public Company(Long id, String name, String employeeSize, String aboutCompany, String estDate) {
		this.id = id;
		this.name = name;
		this.employeeSize = employeeSize;
		this.aboutCompany = aboutCompany;
		this.estDate = estDate;
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

	public String getEmployeeSize() {
		return employeeSize;
	}

	public void setEmployeeSize(String employeeSize) {
		this.employeeSize = employeeSize;
	}

	public String getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}

	public String getEstDate() {
		return estDate;
	}

	public void setEstDate(String estDate) {
		this.estDate = estDate;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	
	
}
