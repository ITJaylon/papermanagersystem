package com.paper.mapper;

import java.util.List;

import com.paper.pojo.Manager;

public interface ManagerMapper {
	
	public Manager getManagerByManagerId(String managerId);
	
	public List<Manager> getAllManager();
}
