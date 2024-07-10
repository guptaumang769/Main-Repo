package com.microservices.reviewms.reviews;

import java.util.List;

public interface ReviewService {
	
	List<Reviews> getAllReviews(Long companyId);
	
	boolean addReview(Reviews review, Long companyId);
	
	Reviews getReview(Long reviewId);
	
	boolean updateReview(Long reviewId, Reviews review);
	
	boolean deleteReview(Long reviewId);
}
