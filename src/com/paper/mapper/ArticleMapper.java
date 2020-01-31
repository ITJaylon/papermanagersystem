package com.paper.mapper;

import java.util.List;

import com.paper.pojo.Article;

public interface ArticleMapper {
	
	
	public List<Article> getAllArticle();
	//��ȡwriter�ĸ����Ϣ
	public List<Article> getArticleByArticleWriterId(String ArticleWriterId);
	
	//���ݸ��ID��ȡ���
	public Article getArticleByArticleId(String articleId);
	
	//�������
	public int insertArticle(Article article);
	
	//�޸ĸ��
	public int updateArticle(Article article);

	
	
}
