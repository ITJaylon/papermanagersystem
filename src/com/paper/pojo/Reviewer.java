package com.paper.pojo;

public class Reviewer {
	private String reviewerId;
	private String reviewerName;
	private String reviewerPasswd;
	private String reviewerPhone;
	private String reviewerType;
	public String getReviewerId() {
		return reviewerId;
	}
	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	public String getReviewerPasswd() {
		return reviewerPasswd;
	}
	public void setReviewerPasswd(String reviewerPasswd) {
		this.reviewerPasswd = reviewerPasswd;
	}
	public String getReviewerPhone() {
		return reviewerPhone;
	}
	public void setReviewerPhone(String reviewerPhone) {
		this.reviewerPhone = reviewerPhone;
	}
	public String getReviewerType() {
		return reviewerType;
	}
	public void setReviewerType(String reviewerType) {
		this.reviewerType = reviewerType;
	}
	
	
	@Override
	public String toString() {
		return "Reviewer [reviewerId=" + reviewerId + ", reviewerName=" + reviewerName + ", reviewerPasswd=" + reviewerPasswd
				+ ", reviewerPhone=" + reviewerPhone + ", reviewerType=" + reviewerType + "]";
	}
	
	
}
