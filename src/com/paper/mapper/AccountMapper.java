package com.paper.mapper;

import com.paper.pojo.Account;

public interface AccountMapper {
	public Account getAccountByAccountWriterId(String accountWriterId);
	
	public Account getAccountByAccountId(String accountId);
	
	public int updateAccount(Account account);
}	
