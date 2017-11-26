package cn.home.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.home.modules.beans.entity.ExampleBean;
import cn.home.util.JacksonUtil;

/**
 * @author donald
 * 2017年11月26日
 * 下午12:45:55
 */
public class ClassPathXmlApplicationContextBoot {
	private static final Logger log = LoggerFactory.getLogger(ClassPathXmlApplicationContextBoot.class);
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {"ApplicationContext.xml"});
		ExampleBean exampleBean = context.getBean(ExampleBean.class);
		log.info("exampleBean:{}",JacksonUtil.getInstance().toJson(exampleBean));
	}
}
