package com.job.firstJobApp.companies.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.job.firstJobApp.companies.Company;
import com.job.firstJobApp.companies.CompanyRepository;
import com.job.firstJobApp.companies.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	CompanyRepository companyRepository;
	private Long nextId = 1L;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public void createCompany(Company company) {
		// TODO Auto-generated method stub
		company.setId(nextId++);
		companyRepository.save(company);
		
	}

	@Override
	public Company findCompanyById(Long id) {
		// TODO Auto-generated method stub
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteCompany(Long id) {
		// TODO Auto-generated method stub
		try {
			companyRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean updateCompany(Long id, Company updatedCompany) {
		Optional<Company> companyOptional = companyRepository.findById(id);

		if(companyOptional.isPresent()) {
			Company company = companyOptional.get();
			company.setAboutCompany(updatedCompany.getAboutCompany());
			company.setEmployeeSize(updatedCompany.getEmployeeSize());
			company.setName(updatedCompany.getName());
			company.setEstDate(updatedCompany.getEstDate());
			company.setJobs(updatedCompany.getJobs());
			
			companyRepository.save(company);
			return true;
		}
		return false;
	}

}
