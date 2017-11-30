package cn.home.modules.transaction.boot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.home.modules.transaction.entity.Menu;
import cn.home.modules.transaction.service.MenuService;

public class TransactionBoot {
	public static void main(final String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		MenuService menuService = (MenuService) ctx.getBean(MenuService.class);
		menuService.saveMenu(new Menu());
	}
}
