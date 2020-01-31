package com.paper.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paper.service.ReviewerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ReviewerServiceTest {
	
	@Autowired
	ReviewerService reviewerService;
	
	@Test
	public void getReviewerByReviewerId() {
		System.out.println(reviewerService.getReviewerByReviewerId("r001"));
	}
}	
