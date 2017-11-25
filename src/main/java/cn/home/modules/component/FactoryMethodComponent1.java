package cn.home.modules.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class FactoryMethodComponent1 {
	private static int i;

	  @Bean @Qualifier("public")
	  public TestBean publicInstance() {
	      return new TestBean("publicInstance");
	  }

	  // use of a custom qualifier and autowiring of method parameters

	  @Bean
	  protected TestBean protectedInstance(@Qualifier("public") TestBean spouse,
	                                       @Value("#{privateInstance.age}") String country) {
	      TestBean tb = new TestBean("protectedInstance", 1);
	      tb.setSpouse(tb);
	      tb.setCountry(country);
	      return tb;
	  }
      /*
	  @Bean @Scope(BeanDefinition.SCOPE_SINGLETON)
	  private TestBean privateInstance() {
	      return new TestBean("privateInstance", i++);
	  }

	  @Bean @Scope(value = WebApplicationContext.SCOPE_SESSION,
	               proxyMode = ScopedProxyMode.TARGET_CLASS)
	  public TestBean requestScopedInstance() {
	      return new TestBean("requestScopedInstance", 3);
	  }
	  */
}
