package com.paper.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paper.mapper.DistributeMapper;
import com.paper.pojo.Account;
import com.paper.pojo.Article;
import com.paper.pojo.Checkinfo;
import com.paper.pojo.Distribute;
import com.paper.pojo.Manager;
import com.paper.pojo.Reviewer;
import com.paper.pojo.Writer;
import com.paper.service.ManagerService;
import com.paper.service.ReviewerService;
import com.paper.service.WriterService;

@Controller
@RequestMapping("")
public class ManagerController {
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
	
	@RequestMapping("reviewerInfo")
	public ModelAndView reviewerInfo() {
		ModelAndView mav = new ModelAndView();
		List<Reviewer> reviewerList= reviewerService.getAllReviewer();
		mav.addObject("reviewerList", reviewerList);
		mav.addObject("reviewerMap", reviewerId_Name());
		mav.setViewName("reviewerInfo");
		return mav;
	}
	
	@RequestMapping("insertReviewer")
	public ModelAndView insertReviewer(Reviewer reviewer) {
		
		
		ModelAndView mav = new ModelAndView();
		
		int res = managerService.insertReviewer(reviewer);
		if(res == 1) {
			mav.addObject("msg", "添加成功！");
		}else {
			mav.addObject("msg", "添加失败！");
		}
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("reviewer_update")
	public ModelAndView reviewer_update(@RequestParam("reviewerId") String reviewerId) {

		ModelAndView mav = new ModelAndView();
		Reviewer reviewer = reviewerService.getReviewerByReviewerId(reviewerId);
		mav.addObject("reviewer", reviewer);

		mav.setViewName("reviewer_update");
		return mav;
	}
	
	@RequestMapping("updateReviewer")
	public ModelAndView updateReviewer(Reviewer reviewer) {
		//System.out.println(distribute);
		ModelAndView mav = new ModelAndView();
		System.out.println(reviewer);
		int res = managerService.updateReviewer(reviewer);
		if(res == 1) {
			mav.addObject("msg", "修改成功！");
		}else {
			mav.addObject("msg", "修改失败！");
		}
		mav.setViewName("index");
		return mav;
		
	}
	
	@RequestMapping("reviewer_delete")
	public ModelAndView reviewer_delete(@RequestParam("reviewerId")String reviewerId) {
		//System.out.println(distribute);
		ModelAndView mav = new ModelAndView();
		
		int res = managerService.deleteReviewerByReviewerId(reviewerId);
		if(res == 1) {
			mav.addObject("msg", "删除成功！");
		}else {
			mav.addObject("msg", "删除失败！");
		}
		mav.setViewName("index");
		return mav;
		
	}
	
	
	@RequestMapping("distributeInfo")
	public ModelAndView distributeInfo(@RequestParam("managerId") String managerId) {
		ModelAndView mav = new ModelAndView();
		List<Distribute> distributeList = managerService.getAllDistribute();
		mav.addObject("distributeList", distributeList);
		Manager manager = managerService.getManagerById(managerId);
		mav.addObject("manager", manager);
				
		mav.addObject("articleMap", articleId_Title());		
		mav.addObject("reviewerMap", reviewerId_Name());			
		mav.addObject("managerMap", managerId_Name());
		
		mav.setViewName("distributeInfo");
		return mav;
	}
	
	@RequestMapping("updateDistribute")
	public ModelAndView updateDistribute(@RequestParam("distributeId") String distributeId) {
		int dId = Integer.parseInt(distributeId);
		ModelAndView mav = new ModelAndView();
		Distribute distribute = managerService.getDistributeByDistributeId(dId);
		mav.addObject("distribute", distribute);
		mav.addObject("articleMap", articleId_Title());	
		//System.out.println(reviewerId_Name());
		mav.addObject("reviewerMap", reviewerId_Name());			
		mav.addObject("managerMap", managerId_Name());
		mav.setViewName("distribute_update");
		return mav;
	}
	@RequestMapping("updateDistribute_2")
	public ModelAndView updateDistribute_2(Distribute distribute) {
		//System.out.println(distribute);
		ModelAndView mav = new ModelAndView();
		int res = managerService.updateDistribute(distribute);
		if(res == 1) {
			mav.addObject("msg", "分配成功！");
			//分配成功后，添加审稿记录
			Checkinfo checkInfo = new Checkinfo();
			Distribute dt = managerService.getDistributeByDistributeId(distribute.getDistributeId());
			String writerId = writerService.getArticleByArticleId(dt.getDistributeArticleId()).getArticleWriterId(); 
			checkInfo.setArticleId(dt.getDistributeArticleId());
			checkInfo.setReviewerId(distribute.getDistributeReviewerId());
			checkInfo.setManagerId(distribute.getDistributeManagerId());
			checkInfo.setWriterId(writerId);
			managerService.insertCheckInfo(checkInfo);
		}else {
			mav.addObject("msg", "分配失败！");
		}
		mav.setViewName("index");
		return mav;
		
	}
	
	@RequestMapping("showCheckInfo")
	public ModelAndView showCheckInfo() {
		ModelAndView mav = new ModelAndView();
		List<Checkinfo> checkInfoList = managerService.getCheckInfo();
		mav.addObject("checkInfoList", checkInfoList);
		mav.addObject("articleMap", articleId_Title());		
		mav.addObject("reviewerMap", reviewerId_Name());
		mav.addObject("managerMap", managerId_Name());
		
		mav.setViewName("CheckInfo");
		return mav;
	}
	
	@RequestMapping("showMySecondCheckInfo")
	public ModelAndView showMySecondCheckInfo(@RequestParam("managerId") String managerId) {
		ModelAndView mav = new ModelAndView();
		List<Checkinfo> checkInfoList = managerService.getCheckInfoByManagerId(managerId);
		mav.addObject("checkInfoList", checkInfoList);
		mav.addObject("articleMap", articleId_Title());		
		mav.addObject("reviewerMap", reviewerId_Name());
		mav.addObject("managerMap", managerId_Name());
		
		mav.setViewName("CheckInfo_second");
		return mav;
	}
	
	@RequestMapping("secondCheck")
	public ModelAndView secondCheck(@RequestParam("checkInfoId") String checkInfoId) {
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
		mav.setViewName("CheckInfo_second_update");
		return mav;
		
	}
	
	@RequestMapping("secondCheck_2")
	public ModelAndView secondCheck_2(Checkinfo checkInfo) {
		//System.out.println(distribute);
		ModelAndView mav = new ModelAndView();
		Checkinfo cf = managerService.getCheckInfoByCheckInfoId(checkInfo.getCheckInfoId());
		
		int status = checkInfo.getSecondCheckStatus();
		cf.setSecondCheckStatus(status);
		//审核通过自动发放稿费
		if(status == 1) {
			Account account = writerService.getAccountByAccountWriterId(cf.getWriterId());
			int money = account.getAccountBalance()+180;
			account.setAccountBalance(money);
			writerService.updateAccount(account);
		}
		//自动修改稿件的审核属性为已审核
		Article article = writerService.getArticleByArticleId(cf.getArticleId());
		//System.out.println(article);
		article.setArticleCheck("已审核");
		if(status == 1) {
			article.setArticlePay(1);//修改稿件的稿费属性，已支付
		}
		writerService.updateArticle(article);
		
		//修改审核信息
		int res = managerService.updateCheckInfo(cf);
		if(res == 1) {
			mav.addObject("msg", "复审成功！");
		}else {
			mav.addObject("msg", "复审失败！");
		}
		mav.setViewName("index");
		return mav;
		
	}
}
