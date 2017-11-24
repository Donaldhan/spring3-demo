/**
 * <context:annotation-config/> (The implicitly registered post-processors
 * include AutowiredAnnotationBeanPostProcessor,
 * CommonAnnotationBeanPostProcessor, PersistenceAnnotationBeanPostProcessor, as
 * well as the aforementioned RequiredAnnotationBeanPostProcessor.)
 * 
 * <context:annotation-config/> only looks for annotations on beans in the same
 * application context in which it is defined. This means that, if you put
 * <context:annotation-config/> in a WebApplicationContext for a
 * DispatcherServlet, it only checks for @Autowired beans in your controllers,
 * and not your services. See Section 17.2, “The DispatcherServlet” for more
 * information.
 * 
 * 
 * @author donald 2017年11月24日 上午9:59:59
 */
package cn.home.modules.autowired;