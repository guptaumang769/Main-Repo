package com.job.firstJobApp.companies;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	/*
	 * public CompanyController() { // TODO Auto-generated constructor stub }
	 */
	
	@GetMapping
	public ResponseEntity<List<Company>> findAll() {
		return ResponseEntity.ok(companyService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		companyService.createCompany(company);
		return new ResponseEntity<>("Company Added Successfully", HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> findJobById(@PathVariable Long id) {
		Company company = companyService.findCompanyById(id);
		if(company != null) 
			return new ResponseEntity<>(company, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
		boolean deleted = companyService.deleteCompany(id);
		if(deleted) {
			return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK); 
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Company updatedCompany) {
		boolean updated = companyService.updateCompany(id, updatedCompany);
		if(updated)
			return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
