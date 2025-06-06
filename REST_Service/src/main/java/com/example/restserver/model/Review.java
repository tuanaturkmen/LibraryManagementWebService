package com.example.restserver.model;

public class Review {
	
	private Long id;
	private Long studentId;
	private String studentName;
    private String bookName;
    private int rating;
    private String reviewText;

    public Review(Long id, Long studentId, String studentName, String bookName, int rating, String reviewText) {
        this.id = id;
        this.studentId = studentId;
    	this.studentName = studentName;
        this.bookName = bookName;
        this.rating = rating;
        this.reviewText = reviewText;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
    

}
