package cn.home.modules.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
/**
 * Multiple lifecycle mechanisms configured for the same bean, 
 * with different initialization methods, are called as follows:
 * Methods annotated with @PostConstruct
 * afterPropertiesSet() as defined by the InitializingBean callback interface
 * A custom configured init() method
 * Destroy methods are called in the same order:
 * Methods annotated with @PreDestroy
 * destroy() as defined by the DisposableBean callback interface
 * A custom configured destroy() method
 * */

public class LifecycleBean implements InitializingBean, DisposableBean, BeanPostProcessor {
	@PostConstruct
	public void init() {

	}
	@PreDestroy
	public void dispose() {

	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
