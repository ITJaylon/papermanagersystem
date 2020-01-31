package com.paper.service;

import java.util.List;

import com.paper.pojo.Account;
import com.paper.pojo.Article;
import com.paper.pojo.Checkinfo;
import com.paper.pojo.Writer;

public interface WriterService {

	//����writerId��ȡwriter
	public Writer getWriterById(String writerId);
	
	//��֤ע���˺��Ƿ����
	public Boolean writerIsExist(String writerId);
	
	//����writer
	public int insertWriter(Writer writer);
	
	//�޸�writer
	public int updateWriter(Writer writer);
	
	//������и����Ϣ
	public List<Article> getAllArticle();
	
	//����WriterId��ȡ�������
	public List<Article> getArticleByArticleWriterId(String articleWriterId);
	
	//����ArticleId��ȡ���
	public Article getArticleByArticleId(String articleId);
	
	//��֤������Ƿ����
	public Boolean articleIsExist(String articleId);
	
	//�������
	public int insertArticle(Article article);
	
	//�޸ĸ����Ϣ
	public int updateArticle(Article article);
	
	//����WriterId��ȡ����¼��Ϣ
	public List<Checkinfo> getCheckInfoByWriterId(String writerId);
	
	//����WriterId��ȡ�˻���Ϣ
	public Account getAccountByAccountWriterId(String writerId);
	
	//����AccountId��ȡ�˻���Ϣ
	public Account getAccountByAccountId(String accountId);
	
	//�޸��˻���Ϣ
	public int updateAccount(Account account);
}
