package com.paper.mapper;

import java.util.List;

import com.paper.pojo.Distribute;

public interface DistributeMapper {
	
	public List<Distribute> getDistribute();
	
	public Distribute getDistributeByDistributeId(int distributeId);
		
	public int insertDistribute(Distribute distribute);
	
	public int updateDistribute(Distribute distribute);
}
