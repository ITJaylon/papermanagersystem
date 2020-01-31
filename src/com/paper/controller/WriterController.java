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
			mav.addObject("result", "ע��ɹ���");
		}else {
			mav.addObject("result", "ע��ʧ��");
		}
		mav.setViewName("login");
		return mav;
	}
	
	 @RequestMapping("writer-exist")
	    @ResponseBody
	    public void checkout(@RequestParam("writerId") String writerId,HttpServletResponse
	    		response){
	    	System.out.println("����writerIdִ��");
	    	PrintWriter out = null;
	    	 try {
	    		out = response.getWriter();
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	//����service�㷽��findXueyuan(xueyuan_name)
	    	
	    	//if(null != list && !list.isEmpty())  �жϼ����Ƿ�Ϊ�գ����Ϊ��˵����ǰû��ѧԺ���������ѧԺ�Ѿ�����
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
	    	System.out.println("����articleIdִ��");
	    	PrintWriter out = null;
	    	 try {
	    		out = response.getWriter();
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	//����service�㷽��findXueyuan(xueyuan_name)
	    	
	    	//if(null != list && !list.isEmpty())  �жϼ����Ƿ�Ϊ�գ����Ϊ��˵����ǰû��ѧԺ���������ѧԺ�Ѿ�����
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
		 	article.setArticleCheck("δ���");
			article.setArticleWriterid(articleWriterId);
			//System.out.println(article);
			ModelAndView mav = new ModelAndView();
			int res = writerService.insertArticle(article);
			
			//�۳�����
			Account account = writerService.getAccountByAccountWriterId(articleWriterId);
			if(account.getAccountBalance()<20) {
				mav.addObject("msg", "�˻����㣬���ȳ�ֵ��");
			}else {
				account.setAccountBalance(account.getAccountBalance()-20);
				writerService.updateAccount(account);
			}
			
			Distribute distribute = new Distribute();
			distribute.setDistributeArticleId(article.getArticleId());
			managerService.insertDistribute(distribute);
			if(res == 1) {
				mav.addObject("msg", "Ͷ��ɹ�,�ѿ۳�����20Ԫ");
				
			}else {
				mav.addObject("msg", "Ͷ��ʧ��");
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
				mav.addObject("msg","������˼�¼");
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
		 	//��ȡԭ�˻�
		 	Account ac = writerService.getAccountByAccountId(account.getAccountId());
		 	//������
		 	int money = ac.getAccountBalance() + account.getAccountBalance();
		 	ac.setAccountBalance(money);
		 	//�����˻����
		 	int res = writerService.updateAccount(ac);
		 	if(res == 1) {
		 		mav.addObject("msg", "��ֵ�ɹ�");
		 	}else {
		 		mav.addObject("msg", "��ֵʧ��");
		 	}
		 	mav.addObject("account", account);
		 	mav.setViewName("index");
		 	return mav;
	 	}
	 
	 
	   
}
