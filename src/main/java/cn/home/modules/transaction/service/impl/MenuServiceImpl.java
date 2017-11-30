package cn.home.modules.transaction.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.home.modules.transaction.entity.Menu;
import cn.home.modules.transaction.service.MenuService;
/**
 * @Transactional，用于在开启spring事务注解的情况下（<tx:annotation-driven transaction-manager="txManager" />），
 * 配置事务，事务注解@Transactional，可以配置在类和public方法上，当类和方法都配置时，
 * 方法的事务注解将会覆盖类上的事务注解。
 * @author donald
 * 2017年11月30日
 * 下午9:18:20
 */
@Service
public class MenuServiceImpl implements MenuService{
	private static Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);
	 @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveMenu(Menu menu) {
		log.info("save menu...");
	}
//  @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void updateMenu(Menu menu) {
		log.info("update menu...");
	}
	@Transactional(readOnly = true)
	@Override
	public Menu findMenu(Integer menuId) {
		Menu menu = new Menu();
		log.info("find menu...");
		return menu;
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW,rollbackFor=UnsupportedOperationException.class)
	@Override
	public void deleteMenu(Integer menuId) {
		throw new UnsupportedOperationException();
	}

}
