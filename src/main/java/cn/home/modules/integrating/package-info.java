/**
 * Integrating with other web frameworks
 * 
 * Find below the <listener/> configuration:
 * <listener> <listener-class>org.springframework.web.context.
 * ContextLoaderListener</listener-class> </listener>
 * 
 * Find below the <context-param/> configuration:
 * <context-param> <param-name>contextConfigLocation</param-name>
 * <param-value>/WEB-INF/applicationContext*.xml</param-value> </context-param>
 * 
 * If you don't specify the contextConfigLocation context parameter, the
 * ContextLoaderListener will look for a file called
 * /WEB-INF/applicationContext.xml to load. Once the context files are loaded,
 * Spring creates a WebApplicationContext object based on the bean definitions
 * and stores it in the ServletContext of the web application.
 * 
 * All Java web frameworks are built on top of the Servlet API, and so one can
 * use the following code snippet to get access to this 'business context'
 * ApplicationContext created by the ContextLoaderListener.
 * 
 * WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
 * 
 * WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUT
 * 
 * 
 * @author donald 2017年12月4日 下午12:37:43
 */
package cn.home.modules.integrating;