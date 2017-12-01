package cn.home.modules.orm.dao;

import org.springframework.dao.DataAccessException;

import cn.home.modules.orm.entity.Account;
import cn.home.modules.orm.exception.IbatisDaoException;

public interface AccountDao {

	Account getAccount(String email) throws IbatisDaoException;

	void insertAccount(Account account) throws DataAccessException, IbatisDaoException;

}
