package com.paper.service;

import java.util.List;

import com.paper.pojo.Checkinfo;
import com.paper.pojo.Reviewer;

public interface ReviewerService {
	
	public Reviewer getReviewerByReviewerId(String reviewerId);
	
	public List<Reviewer> getAllReviewer();
	
	public List<Checkinfo> getCheckInfoByReviewerId(String reviewerId);
}
