package com.microservices.reviewms.reviews.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.microservices.reviewms.reviews.Reviews;
import com.microservices.reviewms.reviews.dto.ReviewMessage;

public class ReviewMessageProducer {
	
	private final RabbitTemplate rabbitTemplate;

	public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(Reviews review) {
		ReviewMessage reviewMessage = new ReviewMessage();
		reviewMessage.setId(reviewMessage.getId());
		reviewMessage.setTitle(review.getTitle());
		reviewMessage.setDescription(review.getDescription());
		reviewMessage.setRating(review.getRating());
		reviewMessage.setCompanyId(review.getCompanyId());
		rabbitTemplate.convertAndSend("companyRatingQueue", reviewMessage);
	}
	
	

}
