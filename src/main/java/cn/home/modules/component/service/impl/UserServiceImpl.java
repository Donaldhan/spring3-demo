package cn.home.modules.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.home.modules.component.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public void registerUser() {
		log.info("register user success...");
	}

}
