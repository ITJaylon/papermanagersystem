package com.paper.mapper;

import java.util.List;

import com.paper.pojo.Checkinfo;

public interface CheckinfoMapper {
	
	
	public List<Checkinfo> getCheckInfo();
	
	public Checkinfo getCheckInfoById(int checkInfoId);
	
	public List<Checkinfo> getCheckInfoByWriterId(String writerId);
	
	public List<Checkinfo> getCheckInfoByReviewerId(String reviewerId);
	
	public List<Checkinfo> getCheckInfoByManagerId(String managerId);
	
	public int insertCheckInfo(Checkinfo checkInfo);
	
	public int updateCheckInfo(Checkinfo checkInfo);
}
