package com.paper.mapper;

import java.util.List;

import com.paper.pojo.Reviewer;

public interface ReviewerMapper {
	public Reviewer getReviewerByReviewerId(String reviewerId);
	
	public List<Reviewer> getAllReviewer();
	
	public int insertReviewer(Reviewer reviewer);
	
	public int updateReviewer(Reviewer reviewer);
	
	public int deleteReviewerByReviewerId(String reviewerId);
}
