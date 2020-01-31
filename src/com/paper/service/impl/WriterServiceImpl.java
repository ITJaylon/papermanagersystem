package com.paper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paper.mapper.AccountMapper;
import com.paper.mapper.ArticleMapper;
import com.paper.mapper.CheckinfoMapper;
import com.paper.mapper.WriterMapper;
import com.paper.pojo.Account;
import com.paper.pojo.Article;
import com.paper.pojo.Checkinfo;
import com.paper.pojo.Writer;
import com.paper.service.WriterService;

@Service
public class WriterServiceImpl implements WriterService{
	
	@Autowired
	WriterMapper writerMapper;
	
	@Autowired
	ArticleMapper articleMapper;
	
	@Autowired
	CheckinfoMapper checkinfoMapper;
	
	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public Writer getWriterById(String writerId) {
		return writerMapper.getWriterByWriterId(writerId);		
	}




	@Override
	public Boolean writerIsExist(String writerId) {
		// TODO Auto-generated method stub
		if(null == writerMapper.getWriterByWriterId(writerId)) {
			return true;
		}else {
			return false;
		}
	}


	@Override
	public int insertWriter(Writer writer) {
		return writerMapper.insertWriter(writer);
	}


	@Override
	public int updateWriter(Writer writer) {
		return writerMapper.updateWriter(writer);
	}



	@Override
	public List<Article> getAllArticle() {
		// TODO Auto-generated method stub
		return articleMapper.getAllArticle();
	}

	

	@Override
	public List<Article> getArticleByArticleWriterId(String articleWriterId) {
		// TODO Auto-generated method stub
		return articleMapper.getArticleByArticleWriterId(articleWriterId);
	}
	
	@Override
	public Article getArticleByArticleId(String articleId) {
		// TODO Auto-generated method stub
		return articleMapper.getArticleByArticleId(articleId);
	}
	
	
	@Override
	public int insertArticle(Article article) {
		
		return articleMapper.insertArticle(article);
	}

	@Override
	public int updateArticle(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.updateArticle(article);
	}



	@Override
	public Boolean articleIsExist(String articleId) {
		if(null != articleMapper.getArticleByArticleId(articleId)) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public List<Checkinfo> getCheckInfoByWriterId(String writerId){
		return checkinfoMapper.getCheckInfoByWriterId(writerId);		
	}




	@Override
	public Account getAccountByAccountWriterId(String writerId) {
		
		return accountMapper.getAccountByAccountWriterId(writerId);
	}




	@Override
	public Account getAccountByAccountId(String accountId) {
		// TODO Auto-generated method stub
		return accountMapper.getAccountByAccountId(accountId);
	}




	@Override
	public int updateAccount(Account account) {
		
		return accountMapper.updateAccount(account);
	}




	







	
	
}
