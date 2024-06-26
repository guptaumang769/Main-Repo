package com.job.firstJobApp.reviews.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.job.firstJobApp.companies.Company;
import com.job.firstJobApp.companies.CompanyService;
import com.job.firstJobApp.reviews.ReviewRepository;
import com.job.firstJobApp.reviews.ReviewService;
import com.job.firstJobApp.reviews.Reviews;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewRepository reviewRepository;
	private CompanyService companyService;

	public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}


	@Override
	public List<Reviews> getAllReviews(Long companyId) {
		// TODO Auto-generated method stub
		List<Reviews> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}


	@Override
	public boolean addReview(Reviews review, Long companyId) {
		// TODO Auto-generated method stub
		Company company = companyService.findCompanyById(companyId);
		if(company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}
		return false;
	}


	@Override
	public Reviews getReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		List<Reviews> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews.stream()
				.filter(review -> review.getId().equals(reviewId))
				.findFirst()
				.orElse(null);
	}


	@Override
	public boolean updateReview(Long companyId, Long reviewId, Reviews updatedReview) {
		// TODO Auto-generated method stub
		if(companyService.findCompanyById(companyId) != null) {
			updatedReview.setCompany(companyService.findCompanyById(companyId));
			updatedReview.setId(reviewId);
			reviewRepository.save(updatedReview);
			return true;
		}
		return false;		
	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		if(companyService.findCompanyById(companyId) != null 
				&& reviewRepository.existsById(reviewId)) {
			Reviews review = reviewRepository.findById(reviewId).orElse(null);
			Company company = review.getCompany();
			company.getReviews().remove(review);
			review.setCompany(null); 	//For deleting references from both the tables.
			companyService.updateCompany(companyId, company);
			reviewRepository.deleteById(reviewId);
			
			return true;
		}
		
		return false;
	}

}
