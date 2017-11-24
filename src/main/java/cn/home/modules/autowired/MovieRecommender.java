package cn.home.modules.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * You can also use @Autowired for interfaces that are well-known resolvable
 * dependencies: BeanFactory, ApplicationContext, Environment, ResourceLoader,
 * ApplicationEventPublisher, and MessageSource. These interfaces and their
 * extended interfaces, such as ConfigurableApplicationContext or
 * ResourcePatternResolver, are automatically resolved, with no special setup
 * necessary.
 * 
 * @Autowired, @Inject, @Resource, and @Value annotations are handled by a
 * Spring BeanPostProcessor implementations which in turn means that you cannot
 * apply these annotations within your own BeanPostProcessor or
 * BeanFactoryPostProcessor types (if any). These types must be 'wired up'
 * explicitly via XML or using a Spring @Bean method.
 * 
 * @author donald 2017年11月24日 上午10:12:46
 */
public class MovieRecommender {

	@Autowired
	private ApplicationContext context;

	public MovieRecommender() {
	}

	// ...
}
