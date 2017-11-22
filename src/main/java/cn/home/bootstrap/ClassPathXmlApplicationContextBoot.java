package cn.home.bootstrap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextBoot {
	public static void main(String[] args) {
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {"services.xml", "daos.xml"});
		/*
		// retrieve configured instance
		PetStoreServiceImpl service = context.getBean("petStore", PetStoreServiceImpl.class);

		// use configured instance
		List userList = service.getUsernameList();
		*/
	}
}
