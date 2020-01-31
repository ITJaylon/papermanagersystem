package com.paper.service;

import java.util.List;

import com.paper.pojo.Account;
import com.paper.pojo.Article;
import com.paper.pojo.Checkinfo;
import com.paper.pojo.Writer;

public interface WriterService {

	//根据writerId获取writer
	public Writer getWriterById(String writerId);
	
	//验证注册账号是否存在
	public Boolean writerIsExist(String writerId);
	
	//新增writer
	public int insertWriter(Writer writer);
	
	//修改writer
	public int updateWriter(Writer writer);
	
	//获得所有稿件信息
	public List<Article> getAllArticle();
	
	//根据WriterId获取稿件集合
	public List<Article> getArticleByArticleWriterId(String articleWriterId);
	
	//根据ArticleId获取稿件
	public Article getArticleByArticleId(String articleId);
	
	//验证稿件号是否存在
	public Boolean articleIsExist(String articleId);
	
	//新增稿件
	public int insertArticle(Article article);
	
	//修改稿件信息
	public int updateArticle(Article article);
	
	//根据WriterId获取审稿记录信息
	public List<Checkinfo> getCheckInfoByWriterId(String writerId);
	
	//根据WriterId获取账户信息
	public Account getAccountByAccountWriterId(String writerId);
	
	//根据AccountId获取账户信息
	public Account getAccountByAccountId(String accountId);
	
	//修改账户信息
	public int updateAccount(Account account);
}
