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

	    addReview(new Review(currentID, 1L, "Ali Yılmaz", "The Hunger Games", 5, "Action-packed and surprisingly deep. Great for a weekend read."));
	    addReview(new Review(currentID, 1L, "Ali Yılmaz", "Harry Potter and the Sorcerer's Stone", 4, "Classic fantasy. Loved the world-building!"));


	    addReview(new Review(currentID, 2L, "Ayşe Demir", "Divergent", 3, "Interesting premise, but the logic of the factions was confusing."));
	    addReview(new Review(currentID, 2L, "Ayşe Demir", "The Maze Runner", 4, "Mysterious and fast-paced. Enjoyed the puzzle-like setting."));


	    addReview(new Review(currentID, 3L, "Mehmet Koç", "Mockingjay", 2, "Felt like a rushed ending to a good trilogy."));
	    addReview(new Review(currentID, 3L, "Mehmet Koç", "The Death Cure", 5, "Loved the suspense and moral dilemmas. One of the best in the series."));


	    addReview(new Review(currentID, 4L, "Zeynep Çelik", "Harry Potter and the Chamber of Secrets", 5, "Magical and nostalgic. Chamber plot was darker and more exciting."));
	    addReview(new Review(currentID, 4L, "Zeynep Çelik", "Allegiant", 2, "Not a satisfying conclusion, and the ending felt forced."));


	    addReview(new Review(currentID, 5L, "Can Arslan", "The Scorch Trials", 3, "Good continuation but started to feel repetitive."));
	    addReview(new Review(currentID, 5L, "Can Arslan", "Insurgent", 4, "More character depth than the first book. Some parts dragged, though."));
	}
	
	public Review addReview(Review review) {
		review.setId(currentID++);
		reviewList.put(review.getId(), review);
		return review;
	}
	
	public boolean deleteReviewById(Long reviewId) {
	    return reviewList.remove(reviewId) != null;
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
