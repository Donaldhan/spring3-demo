package cn.home.modules.transaction.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.home.modules.transaction.dao.MenuDao;

/**
 * DataAccessException 
 * @author donald
 * 2017年11月30日
 * 下午10:15:03
 */
@Repository
public class MenuDaoImpl implements MenuDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
