package com.paper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paper.pojo.Manager;
import com.paper.pojo.Reviewer;
import com.paper.pojo.Writer;
import com.paper.service.ManagerService;
import com.paper.service.ReviewerService;
import com.paper.service.WriterService;

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	WriterService writerService;

	@Autowired
	ReviewerService reviewerService;

	@Autowired
	ManagerService managerService;
	
	@RequestMapping("userLogin")
	public ModelAndView userLogin(@RequestParam("userId") String userId, @RequestParam("password") String userPwd,
			@RequestParam("userType") String userType) {
		ModelAndView mav = new ModelAndView();

		if (userType.equals("1")) {
			Writer writer = writerService.getWriterById(userId);
			// System.out.println(writer);
			if (userPwd.equals(writer.getWriterPasswd())) {
				mav.setViewName("writerIndex");
				mav.addObject("writer", writer);
			}else {
				mav.setViewName("login");
				mav.addObject("result","登录失败！");
			}
		} else if (userType.equals("2")) {
			Reviewer reviewer = reviewerService.getReviewerByReviewerId(userId);
			 System.out.println(reviewer);
			if (userPwd.equals(reviewer.getReviewerPasswd())) {
				mav.setViewName("reviewerIndex");
				mav.addObject("reviewer", reviewer);
			}
		} else if (userType.equals("3")) {
			Manager manager = managerService.getManagerById(userId);
			if (userPwd.equals(manager.getManagerPasswd())) {
				mav.setViewName("managerIndex");
				mav.addObject("manager", manager);
			}
		} else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@RequestMapping("userInfo")
	public ModelAndView userInfo(@RequestParam("writerId") String writerId) {
		ModelAndView mav = new ModelAndView();
		Writer writer = writerService.getWriterById(writerId);
		mav.addObject("writer", writer);
		mav.setViewName("userInfo");
		return mav;
	}
	
	//修改用户信息
	@RequestMapping("userUpdate")
	public ModelAndView userUpdate(Writer writer) {
		ModelAndView mav = new ModelAndView();
		int res = writerService.updateWriter(writer);
		if(res == 1) {
			mav.addObject("msg", "修改信息成功！");
		}
		mav.addObject("writer", writer);
		mav.setViewName("userInfo");
		return mav;
	}
	
}
