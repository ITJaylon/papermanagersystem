package com.paper.mapper;

import java.util.List;

import com.paper.pojo.Article;

public interface ArticleMapper {
	
	
	public List<Article> getAllArticle();
	//获取writer的稿件信息
	public List<Article> getArticleByArticleWriterId(String ArticleWriterId);
	
	//根据稿件ID获取稿件
	public Article getArticleByArticleId(String articleId);
	
	//新增稿件
	public int insertArticle(Article article);
	
	//修改稿件
	public int updateArticle(Article article);

	
	
}
