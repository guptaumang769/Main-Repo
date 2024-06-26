package com.job.firstJobApp.reviews;

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
@RequestMapping("/companies/{companyId}")
public class ReviewController {
	
	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Reviews>> getAllReviews(@PathVariable Long companyId){
		return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
	}
	
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@RequestBody Reviews review, @PathVariable Long companyId) {
		boolean isReviewSaved = reviewService.addReview(review, companyId);
		if(isReviewSaved) {
			return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);		
	}
	
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Reviews> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
		return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
	}
	
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Reviews review) {
		boolean isUpdated = reviewService.updateReview(companyId, reviewId, review);
		if(isUpdated) {
			return new ResponseEntity<>("Review updated successfully", HttpStatus.ACCEPTED);
		}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
		boolean isReviewDeleted = reviewService.deleteReview(companyId, reviewId);
		if(isReviewDeleted) {
			return new ResponseEntity<>("Review updated successfully", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
	}

}
