package com.paper.pojo;

public class Checkinfo {
	private int checkInfoId;
	private String articleId;
	private String reviewerId;
	private String writerId;
	private int firstCheckStatus;
	private String managerId;
	private int secondCheckStatus;
	public int getCheckInfoId() {
		return checkInfoId;
	}
	public void setCheckInfoId(int checkInfoId) {
		this.checkInfoId = checkInfoId;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getReviewerId() {
		return reviewerId;
	}
	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public int getFirstCheckStatus() {
		return firstCheckStatus;
	}
	public void setFirstCheckStatus(int firstCheckStatus) {
		this.firstCheckStatus = firstCheckStatus;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public int getSecondCheckStatus() {
		return secondCheckStatus;
	}
	public void setSecondCheckStatus(int secondCheckStatus) {
		this.secondCheckStatus = secondCheckStatus;
	}
	@Override
	public String toString() {
		return "Checkinfo [checkInfoId=" + checkInfoId + ", articleId=" + articleId + ", reviewerId=" + reviewerId
				+ ", writerId=" + writerId + ", firstCheckStatus=" + firstCheckStatus + ", managerId=" + managerId
				+ ", secondCheckStatus=" + secondCheckStatus + "]";
	}
	
	
}
