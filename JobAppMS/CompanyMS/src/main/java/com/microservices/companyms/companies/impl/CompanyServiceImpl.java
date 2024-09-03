package com.microservices.companyms.companies.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservices.companyms.companies.Company;
import com.microservices.companyms.companies.CompanyRepository;
import com.microservices.companyms.companies.CompanyService;
import com.microservices.companyms.companies.clients.ReviewClient;
import com.microservices.companyms.companies.dto.ReviewMessage;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	CompanyRepository companyRepository;
	
	private ReviewClient reviewClient;
	
	private Long nextId = 1L;

	public CompanyServiceImpl(CompanyRepository companyRepository, ReviewClient reviewClient) {
		this.companyRepository = companyRepository;
		this.reviewClient = reviewClient;
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
	public boolean deleteCompanyById(Long id) {
		// TODO Auto-generated method stub
		if(companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		}
			return false;
		
	}

	@Override
	public boolean updateCompany(Long id, Company updatedCompany) {
		Optional<Company> companyOptional = companyRepository.findById(id);

		if(companyOptional.isPresent()) {
			Company company = companyOptional.get();
			company.setAboutCompany(updatedCompany.getAboutCompany());
			company.setName(updatedCompany.getName());
			
			companyRepository.save(company);
			return true;
		}
		return false;
	}

	@Override
	public void updateCompanyRating(ReviewMessage reviewMessage) {
		// TODO Auto-generated method stub
		System.out.println(reviewMessage.getDescription());
		Company company = companyRepository.findById(reviewMessage.getCompanyId())
						.orElseThrow();
		double averageRating = reviewClient.getAverageRatingForCompany(reviewMessage.getCompanyId());
		company.setRating(averageRating);
		companyRepository.save(company);
	}

}
