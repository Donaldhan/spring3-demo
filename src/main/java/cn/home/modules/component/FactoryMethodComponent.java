package cn.home.modules.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FactoryMethodComponent {

  @Bean @Qualifier("public")
  public TestBean publicInstance() {
      return new TestBean("publicInstance");
  }

  public void doWork() {
      // Component method implementation omitted
  }
}