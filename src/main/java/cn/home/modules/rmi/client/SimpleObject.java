package cn.home.modules.rmi.client;

import cn.home.modules.rmi.service.AccountService;

public class SimpleObject {
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	// additional methods using the accountService

}
