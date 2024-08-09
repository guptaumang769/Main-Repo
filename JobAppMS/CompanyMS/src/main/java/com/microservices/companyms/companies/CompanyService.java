package com.microservices.companyms.companies;

import java.util.List;

import com.microservices.companyms.companies.dto.ReviewMessage;

public interface CompanyService {
	
	List<Company> findAll();
	
	void createCompany(Company company);

	Company findCompanyById(Long id);

	boolean deleteCompanyById(Long id);

	boolean updateCompany(Long id, Company updatedCompany);

	public void updateCompanyRating(ReviewMessage reviewMessage);

}
