package cn.home.modules.rmi.service;

import java.rmi.RemoteException;
import java.util.List;

import cn.home.modules.rmi.entity.Account;

public interface RemoteAccountService {
	public void insertAccount(Account account) throws RemoteException;
	public List<Account> getAccounts(String name) throws RemoteException;
}
