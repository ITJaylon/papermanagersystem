package com.paper.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paper.service.ManagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManagerServiceTest {
	@Autowired
	ManagerService managerService;
	@Test
	public void test() {
		System.out.println(managerService.getCheckInfoByManagerId("m001"));
	}
}
