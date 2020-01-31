package com.paper.pojo;

public class Account {
	private String accountId;
	private String accountWriterId;
	//’Àªß”‡∂Ó
	private int accountBalance;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountWriterId() {
		return accountWriterId;
	}
	public void setAccountWriterId(String accountWriterId) {
		this.accountWriterId = accountWriterId;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountWriterId=" + accountWriterId + ", accountBalance="
				+ accountBalance + "]";
	}
	
	
}
