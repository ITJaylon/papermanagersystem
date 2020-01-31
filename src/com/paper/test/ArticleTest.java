package com.paper.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paper.mapper.ArticleMapper;
import com.paper.pojo.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ArticleTest {
	
	@Autowired
	ArticleMapper articleMapper;
	
	@Test
	public void fun() {
		Article article = new Article();
		article.setArticleId("a010");
		article.setArticleTitle("javaEE");
		article.setArticleType("教育");
		article.setArticleCheck("未审核");
		article.setArticleWriterid("w001");
		article.setArticleText("程序设计与应用开发");
		
		
		System.out.println(articleMapper.insertArticle(article));
	}
}
