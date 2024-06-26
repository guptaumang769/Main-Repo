package com.job.firstJobApp.reviews;

import java.util.List;

public interface ReviewService {
	
	List<Reviews> getAllReviews(Long companyId);
	
	boolean addReview(Reviews review, Long companyId);
	
	Reviews getReview(Long companyId, Long reviewId);
	
	boolean updateReview(Long companyId, Long reviewId, Reviews review);
	
	boolean deleteReview(Long companyId, Long reviewId);
}
