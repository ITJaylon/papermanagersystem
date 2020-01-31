package com.paper.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paper.pojo.Writer;
import com.paper.service.WriterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class WriterServiceTest {
	@Autowired
	WriterService ws;
	
	@Test
	public void writerTest() {
		Writer writer = new Writer();
		writer.setWriterId("w009");
		writer.setWriterName("ÕÅÈý");
		writer.setWriterPasswd("123123");
		writer.setWriterPhone("12123123");
		writer.setWriterEmail("123@qq.com");
		System.out.println(ws.insertWriter(writer));
		
	}
	
	@Test
	public void articleTest() {
		//System.out.println(ws.getArticleByArticleWriterId("w001"));
		System.out.println(ws.articleIsExist("a98"));
	}
	
	@Test
	public void checkInfoTest() {
		System.out.println(ws.getCheckInfoByWriterId("w002"));
	}
	
	@Test
	public void accountTest() {
		System.out.println(ws.getAccountByAccountWriterId("w001"));
	}
}
