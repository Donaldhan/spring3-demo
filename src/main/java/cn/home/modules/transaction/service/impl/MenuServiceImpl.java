package cn.home.modules.transaction.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.home.modules.transaction.entity.Menu;
import cn.home.modules.transaction.service.MenuService;

public class MenuServiceImpl implements MenuService{
	private static Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);
	@Override
	public void saveMenu(Menu menu) {
		log.info("save menu...");
	}

	@Override
	public void updateMenu(Menu menu) {
		log.info("update menu...");
	}

	@Override
	public void deleteMenu(Menu menu) {
		log.info("delete menu...");
	}

}
