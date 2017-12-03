package cn.home.modules.webmvc;

import javax.servlet.Filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class MyWebAppInitializer1 extends AbstractDispatcherServletInitializer {

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		return null;
	}

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		XmlWebApplicationContext cxt = new XmlWebApplicationContext();
		cxt.setConfigLocation("classpath:spring-config.xml");
		return cxt;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	// ...

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new HiddenHttpMethodFilter(),
				new CharacterEncodingFilter() };
	}
}