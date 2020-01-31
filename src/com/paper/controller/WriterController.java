package com.paper.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
public class WriterController {

	
	@Autowired
	WriterService writerService;
	
	@Autowired
	ReviewerService reviewerService;
	
	@Autowired
	ManagerService managerService;
	/*
	 * @RequestMapping("getWriterInfo") public ModelAndView
	 * getWriterInfo(@PathParam("writerId") String writerId) { ModelAndView mav =
	 * new ModelAndView(); Writer writer = writerService.getWriterById(writerId);
	 * System.out.println(writer); mav.addObject("writer", writer);
	 * mav.setViewName("userInfo"); return mav; }
	 */
	
	
	@RequestMapping("getArticleInfo")
	public ModelAndView getArticleInfo(@RequestParam("articleWriterId") String articleWriterId) {
		ModelAndView mav = new ModelAndView();
		List<Article> articleList = writerService.getArticleByArticleWriterId(articleWriterId);
		mav.addObject("articleList", articleList);
		mav.addObject("articleWriterId", articleWriterId);
		mav.setViewName("articleInfo");
		return mav;
	}
	
	@RequestMapping("insertWriter")
	public ModelAndView insertWriter(Writer writer) {
		
		writer.setWriterAccount(0);
		ModelAndView mav = new ModelAndView();
		
		int res = writerService.insertWriter(writer);
		if(res == 1) {
			mav.addObject("result", "注册成功！");
		}else {
			mav.addObject("result", "注册失败");
		}
		mav.setViewName("login");
		return mav;
	}
	
	 @RequestMapping("writer-exist")
	    @ResponseBody
	    public void checkout(@RequestParam("writerId") String writerId,HttpServletResponse
	    		response){
	    	System.out.println("检验writerId执行");
	    	PrintWriter out = null;
	    	 try {
	    		out = response.getWriter();
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	//调用service层方法findXueyuan(xueyuan_name)
	    	
	    	//if(null != list && !list.isEmpty())  判断集合是否为空，如果为空说明当前没有学院名，否则改学院已经存在
	        if(null == writerService.getWriterById(writerId)){
	        	out.print("1");
	        }else{
	        	out.print("2");
	        }
	        out.flush();
	        out.close();
	    }
	 
	
	 @RequestMapping("Article-exist")
	    @ResponseBody
	    public void checkArticleId(@RequestParam("articleId") String articleId,HttpServletResponse
	    		response){
	    	System.out.println("检验articleId执行");
	    	PrintWriter out = null;
	    	 try {
	    		out = response.getWriter();
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	//调用service层方法findXueyuan(xueyuan_name)
	    	
	    	//if(null != list && !list.isEmpty())  判断集合是否为空，如果为空说明当前没有学院名，否则改学院已经存在
	        if(true == writerService.articleIsExist(articleId)){
	        	out.print("2");
	        }else{
	        	out.print("1");
	        }
	        out.flush();
	        out.close();
	    }
	 
	 @RequestMapping("insertArticle")
	
		public ModelAndView insertArticle(Article article,@RequestParam("articleWriterId") String articleWriterId) {			
		 	article.setArticleCheck("未审核");
			article.setArticleWriterid(articleWriterId);
			//System.out.println(article);
			ModelAndView mav = new ModelAndView();
			int res = writerService.insertArticle(article);
			
			//扣除审稿费
			Account account = writerService.getAccountByAccountWriterId(articleWriterId);
			if(account.getAccountBalance()<20) {
				mav.addObject("msg", "账户余额不足，请先充值！");
			}else {
				account.setAccountBalance(account.getAccountBalance()-20);
				writerService.updateAccount(account);
			}
			
			Distribute distribute = new Distribute();
			distribute.setDistributeArticleId(article.getArticleId());
			managerService.insertDistribute(distribute);
			if(res == 1) {
				mav.addObject("msg", "投稿成功,已扣除审稿费20元");
				
			}else {
				mav.addObject("msg", "投稿失败");
			}
			mav.setViewName("index");
			return mav;
			
		}
	 
	 @RequestMapping("getCheckInfo")
		public ModelAndView getCheckInfo(@RequestParam("writerId") String writerId) {
			ModelAndView mav = new ModelAndView();
			List<Checkinfo> checkInfoList = writerService.getCheckInfoByWriterId(writerId);
			
			System.out.println(checkInfoList);
			Map<String,String> articleMap = new HashMap();
			Map<String,String> reviewerMap = new HashMap();
			Map<String,String> managerMap = new HashMap();
			if(null == checkInfoList) {
				mav.setViewName("index");
				mav.addObject("msg","暂无审核记录");
				return mav;
			}
			for (Checkinfo checkinfo : checkInfoList) {
				Article article = writerService.getArticleByArticleId(checkinfo.getArticleId());	
				
				String aId = article.getArticleId();
				String aTitle = article.getArticleTitle();
				articleMap.put(aId, aTitle);
				
				Reviewer reviewer = reviewerService.getReviewerByReviewerId(checkinfo.getReviewerId());
				String rId = reviewer.getReviewerId();
				String rName = reviewer.getReviewerName();
				reviewerMap.put(rId, rName);
				
				Manager manager = managerService.getManagerById(checkinfo.getManagerId());
				String mId = manager.getManagerId();
				String mName = manager.getManagerName();
				managerMap.put(mId, mName);
				
			}
			
			//System.out.println(articleMap);
			mav.addObject("checkInfoList", checkInfoList);
			mav.addObject("articleMap", articleMap);		
			mav.addObject("reviewerMap", reviewerMap);
			mav.addObject("managerMap", managerMap);
			
			mav.setViewName("CheckInfo");
			return mav;
		}
	 
	 @RequestMapping("getAccountInfo")
	 	public ModelAndView getAccountInfo(@RequestParam("writerId") String writerId) {
	 		ModelAndView mav = new ModelAndView();
	 		
	 		Account account = writerService.getAccountByAccountWriterId(writerId);
	 		mav.addObject("account",account);
	 		Writer writer = writerService.getWriterById(account.getAccountWriterId());
	 		mav.addObject("writer",writer);
	 		mav.setViewName("accountInfo");
	 		return mav;
	 		
	 	}
	 
	 @RequestMapping("addMoney")
	 	public ModelAndView addMoney(@RequestParam("accountId") String accountId) {
		 	ModelAndView mav = new ModelAndView();	
		 	Account account = writerService.getAccountByAccountId(accountId);
		 	mav.addObject("account", account);
		 	mav.setViewName("addMoney");
		 	return mav;
	 	}
	 @RequestMapping("updateAccount")
	 	public ModelAndView updateAccount(Account account) {
		 	ModelAndView mav = new ModelAndView();
		 	System.out.println(account);
		 	//获取原账户
		 	Account ac = writerService.getAccountByAccountId(account.getAccountId());
		 	//余额计算
		 	int money = ac.getAccountBalance() + account.getAccountBalance();
		 	ac.setAccountBalance(money);
		 	//更新账户余额
		 	int res = writerService.updateAccount(ac);
		 	if(res == 1) {
		 		mav.addObject("msg", "充值成功");
		 	}else {
		 		mav.addObject("msg", "充值失败");
		 	}
		 	mav.addObject("account", account);
		 	mav.setViewName("index");
		 	return mav;
	 	}
	 
	 
	   
}
