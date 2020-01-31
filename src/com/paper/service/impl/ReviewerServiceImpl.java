package com.paper.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paper.mapper.CheckinfoMapper;
import com.paper.mapper.ReviewerMapper;
import com.paper.pojo.Checkinfo;
import com.paper.pojo.Reviewer;
import com.paper.service.ReviewerService;

@Service
public class ReviewerServiceImpl implements ReviewerService{

	
	@Autowired
	ReviewerMapper reviewerMapper;
	
	@Autowired
	CheckinfoMapper checkInfoMapper;
	
	@Override	
	public Reviewer getReviewerByReviewerId(String reviewerId) {
		
		return reviewerMapper.getReviewerByReviewerId(reviewerId);
	}

	@Override
	public List<Reviewer> getAllReviewer() {
		// TODO Auto-generated method stub
		return reviewerMapper.getAllReviewer();
	}

	@Override
	public List<Checkinfo> getCheckInfoByReviewerId(String reviewerId) {
		// TODO Auto-generated method stub
		return checkInfoMapper.getCheckInfoByReviewerId(reviewerId);
	}
	
	
}
