package cn.home.modules.component.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import cn.home.modules.component.dao.UserDao;
@Repository
public class UserDaoImpl implements UserDao {
	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
	@Override
	public void saveUser() {
		log.info("save user success...");
	}
}
