package com.job.firstJobApp.jobs.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.job.firstJobApp.jobs.Job;
import com.job.firstJobApp.jobs.JobService;

@Service
public class JobServiceImpl implements JobService {
	
	private List<Job> jobs = new ArrayList<>();
	private Long nextId = 1L;

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		job.setId(nextId++);
		jobs.add(job);
	}

	@Override
	public Job findJobById(Long id) {
		// TODO Auto-generated method stub
		for (Job job : jobs) {
			if(job.getId().equals(id)) {
				return job;
			}
		}
		return null;
	}

	@Override
	public boolean deleteJob(Long id) {
		// TODO Auto-generated method stub
		for (Job job : jobs) {
			if(job.getId().equals(id)) {
				jobs.remove(job);
				return true;
			}
		}
		return false;
		
		/*Or different code
		 * Iterator<Job> iterator = jobs.iterator(); while(iterator.hasNext()) { Job job
		 * = iterator.next(); if(job.getId().equals(id)) { iterator.remove(); return
		 * true; } }
		 */
	}

	@Override
	public boolean updateJob(Long id, Job updatedJob) {
		// TODO Auto-generated method stub
		for (Job job : jobs) {
			if(job.getId().equals(id)) {
				job.setTitle(updatedJob.getTitle());
				job.setDescription(updatedJob.getDescription());
				job.setMinSalary(updatedJob.getMinSalary());
				job.setMaxSalary(updatedJob.getMaxSalary());
				job.setLocation(updatedJob.getLocation());
				job.setCompanyName(updatedJob.getCompanyName());
				
				return true;
			}
		}
		return false;
	}

}
