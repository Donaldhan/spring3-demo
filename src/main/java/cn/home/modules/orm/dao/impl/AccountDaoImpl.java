package cn.home.modules.orm.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import cn.home.modules.orm.dao.AccountDao;
import cn.home.modules.orm.entity.Account;
import cn.home.modules.orm.exception.IbatisDaoException;

/**
 * @author donald 2017年12月1日 下午1:27:02
 */
@Repository
public class AccountDaoImpl implements AccountDao{
	@Autowired
	private SqlMapClient sqlMapClient;

   @Override
	public Account getAccount(String email) throws IbatisDaoException {
		try {
			return (Account) this.sqlMapClient.queryForObject("getAccountByEmail", email);
		} catch (SQLException ex) {
			throw new IbatisDaoException(ex);
		}
	}
   @Override
	public void insertAccount(Account account) throws DataAccessException, IbatisDaoException {
		try {
			this.sqlMapClient.update("insertAccount", account);
		} catch (SQLException ex) {
			throw new IbatisDaoException(ex);
		}
	}
}
