package com.microservices.reviewms.reviews.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.reviewms.reviews.ReviewRepository;
import com.microservices.reviewms.reviews.ReviewService;
import com.microservices.reviewms.reviews.Reviews;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
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
		if(companyId != null && review != null) {
			review.setCompanyId(companyId);
			reviewRepository.save(review);
			return true;
		}
		return false;
	}


	@Override
	public Reviews getReview(Long reviewId) {
		// TODO Auto-generated method stub
		return reviewRepository.findById(reviewId).orElse(null);
	}


	@Override
	public boolean updateReview(Long reviewId, Reviews updatedReview) {
		Reviews review = reviewRepository.findById(reviewId).orElse(null);
		// TODO Auto-generated method stub
		if(reviewId != null) {
			review.setTitle(updatedReview.getTitle());
			review.setDescription(updatedReview.getDescription());
			review.setRating(updatedReview.getRating());
			review.setCompanyId(updatedReview.getCompanyId());
			reviewRepository.save(review);
			return true;
		}
		return false;		
	}

	@Override
	public boolean deleteReview(Long reviewId) {
		// TODO Auto-generated method stub
		Reviews review = reviewRepository.findById(reviewId).orElse(null);
		if(review != null) {
			reviewRepository.delete(review);			
			return true;
		}
		
		return false;
	}

}
