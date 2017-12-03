package cn.home.modules.webmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author donald
 * 2017年12月3日
 * 上午10:20:54
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@SuppressWarnings("resource")
	@Override
	public void onStartup(ServletContext container) {
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setConfigLocation("classpath:spring-config.xml");
		ServletRegistration.Dynamic registration = container.addServlet("springmvc", new DispatcherServlet());
		registration.setLoadOnStartup(1);
		registration.addMapping("*.do");
	}

}
