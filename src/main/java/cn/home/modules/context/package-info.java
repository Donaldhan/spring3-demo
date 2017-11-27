/**
 * WebApplicationContext 
 * BeanFactory 
 * ClassPathXmlApplicationContext
 * FileSystemXmlApplicationContext
 * =======================
 * MessageSource
 * HierarchicalMessageSource
 * ===ResourceBundleMessageSource 
 * ===StaticMessageSource
 * ReloadableResourceBundleMessageSource 
 * ===========================
 * 
 * ApplicationEvent
 * ApplicationListener
 * 
 * 
 * 
 * 
 * ContextRefreshedEvent==|
 * ContextStartedEvent====|ConfigurableApplicationContext 
 * ContextStoppedEvent====|XmlWebApplicationContext 
 * ContextClosedEvent=====|GenericApplicationContext 
 * 
 * RequestHandledEvent:DispatcherServlet
 * =============================
 * Resource 
 * UrlResource
 * ClassPathResource
 * FileSystemResource
 * ServletContextResource
 * InputStreamResource
 * ByteArrayResource
 * 
 * 
 * ResourceLoader
 * ResourceLoaderAware
 * PropertyEditor 
 * ==============================
 * ContextLoader
 * ContextLoaderListener 
 * @author donald
 * 2017年11月23日
 * 上午11:29:41
 */
package cn.home.modules.context;

