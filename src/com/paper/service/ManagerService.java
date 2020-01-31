package com.paper.service;

import java.util.List;

import com.paper.pojo.Checkinfo;
import com.paper.pojo.Distribute;
import com.paper.pojo.Manager;
import com.paper.pojo.Reviewer;

public interface ManagerService {

	public Manager getManagerById(String ManagerId);
	
	public List<Manager> getAllManager();
	
	public int insertReviewer(Reviewer reviewer);
	
	public int updateReviewer(Reviewer reviewer);
	
	public int deleteReviewerByReviewerId(String reviewerId);
	
	public List<Distribute> getAllDistribute();
	
	public Distribute getDistributeByDistributeId(int distributeId);
	
	public int updateDistribute(Distribute distribute);
	
	public int insertDistribute(Distribute distribute);
	
	public List<Checkinfo> getCheckInfo();
	
	public Checkinfo getCheckInfoByCheckInfoId(int checkInfoId);
	
	public List<Checkinfo> getCheckInfoByManagerId(String managerId);
	
	public int insertCheckInfo(Checkinfo checkInfo);
	
	public int updateCheckInfo(Checkinfo checkInfo);
}
