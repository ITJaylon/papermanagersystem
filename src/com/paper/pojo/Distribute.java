package com.paper.pojo;

public class Distribute {
	private int distributeId;
	private String distributeArticleId;
	private String distributeReviewerId;
	private String distributeManagerId;
	public int getDistributeId() {
		return distributeId;
	}
	public void setDistributeId(int distributeId) {
		this.distributeId = distributeId;
	}
	public String getDistributeArticleId() {
		return distributeArticleId;
	}
	public void setDistributeArticleId(String distributeArticleId) {
		this.distributeArticleId = distributeArticleId;
	}
	public String getDistributeReviewerId() {
		return distributeReviewerId;
	}
	public void setDistributeReviewerId(String distributeReviewerId) {
		this.distributeReviewerId = distributeReviewerId;
	}
	public String getDistributeManagerId() {
		return distributeManagerId;
	}
	public void setDistributeManagerId(String distributeManagerId) {
		this.distributeManagerId = distributeManagerId;
	}
	
	@Override
	public String toString() {
		return "Distribute [distributeId=" + distributeId + ", distributeArticleId=" + distributeArticleId
				 + ", distributeReviewerId="
				+ distributeReviewerId + ", distributeManagerId=" + distributeManagerId + "]";
	}
	
}
