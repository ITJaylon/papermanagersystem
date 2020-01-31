package com.paper.pojo;

public class Article {
	private String articleId; 
	private String articleTitle;
	private String articleType;
	private String articleWriterId;
	private String articleCheck;
	private String articleText;
	private int articlePay;
	
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleType() {
		return articleType;
	}
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}
	public String getArticleWriterId() {
		return articleWriterId;
	}
	public void setArticleWriterid(String articleWriterId) {
		this.articleWriterId = articleWriterId;
	}
	public String getArticleCheck() {
		return articleCheck;
	}
	public void setArticleCheck(String articleCheck) {
		this.articleCheck = articleCheck;
	}
	public String getArticleText() {
		return articleText;
	}
	public void setArticleText(String articleText) {
		this.articleText = articleText;
	}
	public int getArticlePay() {
		return articlePay;
	}
	public void setArticlePay(int articlePay) {
		this.articlePay = articlePay;
	}
	
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle=" + articleTitle + ", articleType=" + articleType
				+ ", articleWriterid=" + articleWriterId + ", articleCheck=" + articleCheck + ", articleText="
				+ articleText + ", articlePay=" + articlePay + "]";
	}
	
	
	
}
