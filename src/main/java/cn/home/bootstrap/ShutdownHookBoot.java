package cn.home.bootstrap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Shutting down the Spring IoC container gracefully in non-web applications
 * [Note]
 * This section applies only to non-web applications. Spring's web-based ApplicationContext 
 * implementations already have code in place to shut down the Spring IoC container gracefully 
 * when the relevant web application is shut down.
 * If you are using Spring's IoC container in a non-web application environment; 
 * for example, in a rich client desktop environment; 
 * you register a shutdown hook with the JVM. Doing so ensures a graceful shutdown 
 * and calls the relevant destroy methods on your singleton beans so that all resources
 * are released. Of course, you must still configure and implement these destroy callbacks correctly.
 */
public class ShutdownHookBoot {
	public static void main(final String[] args) throws Exception {
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		// add a shutdown hook for the above context...
		//在非web应用中，使用Spring IOC容器时，可以注册一个shutdown hook到JVM，以便在关闭应用时，关闭容器中的单例bean和相关资源。
		ctx.registerShutdownHook();

		// app runs here...

		// main method exits, hook is called prior to the app shutting down...
	}
}
