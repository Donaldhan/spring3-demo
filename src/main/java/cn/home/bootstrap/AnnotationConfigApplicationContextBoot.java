package cn.home.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.home.config.AppConfig;
import cn.home.modules.beans.service.FooService;
import cn.home.util.JacksonUtil;

/**
 * @author donald
 * 2017年11月22日
 * 下午9:40:07
 */
public class AnnotationConfigApplicationContextBoot {
	private static final Logger log = LoggerFactory.getLogger(AnnotationConfigApplicationContextBoot.class); 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext  ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	    FooService fooService = ctx.getBean(FooService.class);
	    log.info("fooService:{}",JacksonUtil.getInstance().toJson(fooService));
	    fooService.doStuff(1);
	}
}
