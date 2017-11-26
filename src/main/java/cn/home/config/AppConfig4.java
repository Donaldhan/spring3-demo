package cn.home.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ClassUtils;

import cn.home.modules.beans.service.FooService;
import cn.home.modules.beans.service.impl.FooServiceImpl;

@Configuration
@ImportResource("classpath:properties-config.xml")
public class AppConfig4 {
	
    private @Value("#{jdbc.url}") String jdbcUrl;
    private @Value("#{jdbc.username}") String username;
    private @Value("#{jdbc.password}") String password;
    @Bean
    public FooService fooService() {
        return new FooServiceImpl("fooService");
    }
    /*
    @Bean
    public FooService fooService() {
        return new FooServiceImpl(fooRepository());
    }
    @Bean
    public FooRepository fooRepository() {
        return new HibernateFooRepository(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {
        // wire up a session factory
        AnnotationSessionFactoryBean asFactoryBean =
            new AnnotationSessionFactoryBean();
        asFactoryBean.setDataSource(dataSource());
        // additional config
        return asFactoryBean.getObject();
    }

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(jdbcUrl, username, password);
    }
    */
}
