package com.microservices.reviewms.reviews;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping
	public ResponseEntity<List<Reviews>> getAllReviews(@RequestParam Long companyId){
		return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addReview(@RequestBody Reviews review, @RequestParam Long companyId) {
		boolean isReviewSaved = reviewService.addReview(review, companyId);
		if(isReviewSaved) {
			return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);		
	}
	
	@GetMapping("/{reviewId}")
	public ResponseEntity<Reviews> getReview(@PathVariable Long reviewId) {
		return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
	}
	
	@PutMapping("/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Reviews review) {
		boolean isUpdated = reviewService.updateReview(reviewId, review);
		if(isUpdated) {
			return new ResponseEntity<>("Review updated successfully", HttpStatus.ACCEPTED);
		}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
		boolean isReviewDeleted = reviewService.deleteReview(reviewId);
		if(isReviewDeleted) {
			return new ResponseEntity<>("Review updated successfully", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
	}

}
