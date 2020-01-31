package com.paper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paper.mapper.CheckinfoMapper;
import com.paper.mapper.DistributeMapper;
import com.paper.mapper.ManagerMapper;
import com.paper.mapper.ReviewerMapper;
import com.paper.pojo.Checkinfo;
import com.paper.pojo.Distribute;
import com.paper.pojo.Manager;
import com.paper.pojo.Reviewer;
import com.paper.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	ManagerMapper managerMapper;
	
	@Autowired
	ReviewerMapper reviewerMapper;
	
	@Autowired
	DistributeMapper distributeMapper;
	
	@Autowired
	CheckinfoMapper checkInfoMapper;
		
	@Override
	public List<Manager> getAllManager() {
		// TODO Auto-generated method stub
		return managerMapper.getAllManager();
	}
	
	@Override
	public Manager getManagerById(String managerId) {
		
		return managerMapper.getManagerByManagerId(managerId);
	}
	
	@Override
	public int insertReviewer(Reviewer reviewer) {
		// TODO Auto-generated method stub
		return reviewerMapper.insertReviewer(reviewer);
	}

	@Override
	public int updateReviewer(Reviewer reviewer) {
		// TODO Auto-generated method stub
		return reviewerMapper.updateReviewer(reviewer);
	}

	@Override
	public int deleteReviewerByReviewerId(String reviewerId) {
		// TODO Auto-generated method stub
		return reviewerMapper.deleteReviewerByReviewerId(reviewerId);
	}
	
	@Override
	public List<Distribute> getAllDistribute() {
		
		return distributeMapper.getDistribute();
	}

	@Override
	public Distribute getDistributeByDistributeId(int distributeId) {
		// TODO Auto-generated method stub
		return distributeMapper.getDistributeByDistributeId(distributeId);
	}

	@Override
	public int insertDistribute(Distribute distribute) {
		// TODO Auto-generated method stub
		return distributeMapper.insertDistribute(distribute);
	}
	
	@Override
	public int updateDistribute(Distribute distribute) {
		// TODO Auto-generated method stub
		return distributeMapper.updateDistribute(distribute);
	}

	@Override
	public List<Checkinfo> getCheckInfo() {
		// TODO Auto-generated method stub
		return checkInfoMapper.getCheckInfo();
	}

	@Override
	public List<Checkinfo> getCheckInfoByManagerId(String managerId) {
		// TODO Auto-generated method stub
		return checkInfoMapper.getCheckInfoByManagerId(managerId);
	}

	@Override
	public Checkinfo getCheckInfoByCheckInfoId(int checkInfoId) {
		// TODO Auto-generated method stub
		return checkInfoMapper.getCheckInfoById(checkInfoId);
	}

	@Override
	public int updateCheckInfo(Checkinfo checkInfo) {
		// TODO Auto-generated method stub
		return checkInfoMapper.updateCheckInfo(checkInfo);
	}

	@Override
	public int insertCheckInfo(Checkinfo checkInfo) {
		// TODO Auto-generated method stub
		return checkInfoMapper.insertCheckInfo(checkInfo);
	}




	
	
}
