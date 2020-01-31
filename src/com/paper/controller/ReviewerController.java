package com.paper.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paper.pojo.Account;
import com.paper.pojo.Article;
import com.paper.pojo.Checkinfo;
import com.paper.pojo.Manager;
import com.paper.pojo.Reviewer;
import com.paper.pojo.Writer;
import com.paper.service.ManagerService;
import com.paper.service.ReviewerService;
import com.paper.service.WriterService;

@Controller
@RequestMapping("")
public class ReviewerController {
	@Autowired
	WriterService writerService;

	@Autowired
	ReviewerService reviewerService;

	@Autowired
	ManagerService managerService;
	
	public Map<String,String> articleId_Title(){
		Map<String,String> articleMap = new HashMap();
		List<Article> articleList = writerService.getAllArticle();
		for (Article a : articleList) {
			articleMap.put(a.getArticleId(),a.getArticleTitle());
		}
		return articleMap;
	}
	
	public Map<String,String> reviewerId_Name(){
		Map<String,String> reviewerMap = new HashMap();
		List<Reviewer> reviewerList = reviewerService.getAllReviewer();
		for (Reviewer reviewer : reviewerList) {
			reviewerMap.put(reviewer.getReviewerId(),reviewer.getReviewerName());
		}
		return reviewerMap;
	}
	
	public Map<String,String> managerId_Name(){
		Map<String,String> managerMap = new HashMap();
		List<Manager> managerList = managerService.getAllManager();
		for (Manager m : managerList) {
			managerMap.put(m.getManagerId(),m.getManagerName());
		}
		return managerMap;
	}
	
	
	
	@RequestMapping("getFirstCheckInfo")
	public ModelAndView getFirstCheckInfo(@RequestParam("reviewerId") String reviewerId) {
		ModelAndView mav = new ModelAndView();
		List<Checkinfo> checkInfoList = reviewerService.getCheckInfoByReviewerId(reviewerId);
		mav.addObject("checkInfoList", checkInfoList);
		mav.addObject("articleMap", articleId_Title());		
		mav.addObject("reviewerMap", reviewerId_Name());
		mav.addObject("managerMap", managerId_Name());
		
		mav.setViewName("CheckInfo_first");
		return mav;
		
	}
	
	@RequestMapping("firstCheck")
	public ModelAndView firstCheck(@RequestParam("checkInfoId") String checkInfoId) {
		int cId = Integer.parseInt(checkInfoId);
		ModelAndView mav = new ModelAndView();
		Checkinfo checkInfo = managerService.getCheckInfoByCheckInfoId(cId);
		Article article = writerService.getArticleByArticleId(checkInfo.getArticleId());
		mav.addObject("checkInfo", checkInfo);
		mav.addObject("article", article);
		mav.addObject("articleMap", articleId_Title());	
		//System.out.println(reviewerId_Name());
		mav.addObject("reviewerMap", reviewerId_Name());			
		mav.addObject("managerMap", managerId_Name());
		mav.setViewName("CheckInfo_first_update");
		return mav;
		
	}
	

	@RequestMapping("firstCheck_2")
	public ModelAndView firstCheck_2(Checkinfo checkInfo) {
		//System.out.println(distribute);
		ModelAndView mav = new ModelAndView();
		Checkinfo cf = managerService.getCheckInfoByCheckInfoId(checkInfo.getCheckInfoId());
		
		int status = checkInfo.getFirstCheckStatus();
	
		cf.setFirstCheckStatus(status);	
		System.out.println(cf);
		//–ﬁ∏ƒ…Û∫À–≈œ¢
		int res = managerService.updateCheckInfo(cf);
		if(res == 1) {
			mav.addObject("msg", "≥ı…Û≥…π¶£°");
		}else {
			mav.addObject("msg", "≥ı…Û ß∞‹£°");
		}
		mav.setViewName("index");
		return mav;
		
	}
}
