package cn.home.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.home.modules.component.FactoryMethodComponent;
import cn.home.modules.component.dao.UserDao;
import cn.home.modules.component.service.UserService;

/**
 * @author donald
 * 2017年11月22日
 * 下午9:40:07
 */
public class AnnotationConfigApplicationContextBoot2 {
	private static final Logger log = LoggerFactory.getLogger(AnnotationConfigApplicationContextBoot2.class); 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext  ctx = new AnnotationConfigApplicationContext();
	    ctx.scan("cn.home.modules.component");
	    ctx.refresh();
	    FactoryMethodComponent factoryComponent = ctx.getBean(FactoryMethodComponent.class);
	    log.info("factoryComponent class:{}",factoryComponent.getClass().getName());
	    factoryComponent.doWork();
	    UserDao userDao = ctx.getBean(UserDao.class);
	    userDao.saveUser();
	    UserService userService = ctx.getBean(UserService.class);
	    userService.registerUser();
	}
}
