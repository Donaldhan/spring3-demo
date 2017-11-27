package cn.home.config.modules.beanfactory;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author donald
 * 2017年11月27日
 * 上午9:22:42
 */
public class TestXmlBeanFactory {
	public static void main(String[] args) {
		XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));

		// bring in some property values from a Properties file
		PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
		cfg.setLocation(new FileSystemResource("jdbc.properties"));
		// now actually do the replacement
		cfg.postProcessBeanFactory(factory);
		
		
		// now register any needed BeanPostProcessor instances
		/*MyBeanPostProcessor postProcessor = new MyBeanPostProcessor();
		factory.addBeanPostProcessor(postProcessor);*/
		// now start using the factory
	}
}
