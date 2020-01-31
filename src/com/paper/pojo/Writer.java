package com.paper.pojo;

public class Writer{
	private String writerId;
	private String writerName;
	private String writerPasswd;
	private String writerPhone;
	private String writerEmail;
	private int writerAccount;
	
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	
	public String getWriterPasswd() {
		return writerPasswd;
	}
	public void setWriterPasswd(String writerPasswd) {
		this.writerPasswd = writerPasswd;
	}
	public String getWriterPhone() {
		return writerPhone;
	}
	public void setWriterPhone(String writerPhone) {
		this.writerPhone = writerPhone;
	}
	public String getWriterEmail() {
		return writerEmail;
	}
	public void setWriterEmail(String writerEmail) {
		this.writerEmail = writerEmail;
	}
	public int getWriterAccount() {
		return writerAccount;
	}
	public void setWriterAccount(int writerAccount) {
		this.writerAccount = writerAccount;
	}
	@Override
	public String toString() {
		return "Writer [writerId=" + writerId + ", writerName=" + writerName + ", writerPasswd=" + writerPasswd
				+ ", writerPhone=" + writerPhone + ", writerEmail=" + writerEmail + ", writerAccount=" + writerAccount
				+ "]";
	}
	
	
	
	
}
