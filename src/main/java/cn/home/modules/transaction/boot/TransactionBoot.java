package cn.home.modules.transaction.boot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.home.modules.transaction.entity.Menu;
import cn.home.modules.transaction.service.MenuService;

/**
 * 测试Spring声明式事务
 * @author donald
 * 2017年11月30日
 * 下午8:52:50
 */
public class TransactionBoot {
	public static void main(final String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		MenuService menuService = (MenuService) ctx.getBean(MenuService.class);
		menuService.saveMenu(new Menu());
		menuService.deleteMenu(1);
		menuService.findMenu(1);
	}
}
