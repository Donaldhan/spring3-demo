package cn.home.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.home.modules.webmvc.interceptor.LocaleInterceptor;
import cn.home.modules.webmvc.interceptor.SecurityInterceptor;
import cn.home.modules.webmvc.interceptor.ThemeInterceptor;

@Configuration
@EnableWebMvc
@PropertySource("claspath:application.properties")
public class WebConfig extends WebMvcConfigurerAdapter {
	@Autowired
	Environment env;
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// Add formatters and/or converters
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// Configure the list of HttpMessageConverters to use
	}
	 @Override
	  public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new LocaleInterceptor());
	    registry.addInterceptor(new ThemeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
	    registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");
	 }

}
