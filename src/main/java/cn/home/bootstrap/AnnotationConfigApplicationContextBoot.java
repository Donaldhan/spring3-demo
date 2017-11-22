package cn.home.bootstrap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.home.config.AppConfig;
import cn.home.modules.beans.service.FooService;

/**
 * @author donald
 * 2017年11月22日
 * 下午9:40:07
 */
public class AnnotationConfigApplicationContextBoot {
	public static void main(String[] args) {
	    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	    FooService fooService = ctx.getBean(FooService.class);
	    fooService.doStuff();
	}
}
