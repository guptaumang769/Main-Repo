package com.job.firstJobApp.companies;

import java.util.List;

public interface CompanyService {
	
	List<Company> findAll();
	
	void createCompany(Company company);

	Company findCompanyById(Long id);

	boolean deleteCompanyById(Long id);

	boolean updateCompany(Long id, Company updatedCompany);

}
