package cn.home.modules.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class FactoryMethodComponent {
	private static final Logger log = LoggerFactory.getLogger(FactoryMethodComponent.class);

	@Bean
	@Qualifier("public")
	public TestBean publicInstance() {
		return new TestBean("publicInstance");
	}

	public void doWork() {
		log.info("componet working ...");
	}
}