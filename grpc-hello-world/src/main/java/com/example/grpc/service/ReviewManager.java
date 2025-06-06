package com.example.grpc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.grpc.model.Review;

import jakarta.annotation.PostConstruct;

@Service
public class ReviewManager {
	
	private Map<Long, Review> reviewList = new HashMap<>();
	private long currentID  = 1;
	
	@PostConstruct
	public void initReviewList() {
		addReview(new Review(currentID, (long) 1, "Ali",  "TestBook",  5, "So good!"));
		addReview(new Review(currentID, (long) 1, "Ali",  "TestBook2", 1, "Bad!"));
		addReview(new Review(currentID, (long) 1, "Ali",  "TestBook3", 3, "It was ok.."));
		addReview(new Review(currentID, (long) 2, "Ayşe", "TestBook3", 4, "Good one!!!"));
	}
	
	public Review addReview(Review review) {
		review.setId(currentID++);
		reviewList.put(review.getId(), review);
		return review;
	}
	
	public Collection<Review> getReviewsByStudentID(Long studentId) {
		Collection<Review> studentReviews = new ArrayList<Review>();
		for (Review review : reviewList.values()) {
			if (review.getStudentId() == studentId) {
				studentReviews.add(review);
			}
		}
		return studentReviews;
	}
	
}	
