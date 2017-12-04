package cn.home.modules.rmi.service;

import java.util.List;

import cn.home.modules.rmi.entity.Account;

public interface AccountService {
	public void insertAccount(Account account);
	public List<Account> getAccounts(String name);
}
