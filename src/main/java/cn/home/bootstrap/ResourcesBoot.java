package cn.home.bootstrap;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;


/**
 * All application contexts implement the ResourceLoader interface, and
 * therefore all application contexts may be used to obtain Resource instances.
 * 
 * ClassPathXmlApplicationContext instance:
 * 
 * Resource template = ctx.getResource("some/resource/path/myTemplate.txt");
 * 
 * What would be returned would be a ClassPathResource; if the same method was
 * executed against a FileSystemXmlApplicationContext instance, you'd get back a
 * FileSystemResource. For a WebApplicationContext, you'd get back a
 * ServletContextResource, and so on.
 * 
 * 
 * As such, you can load resources in a fashion appropriate to the particular
 * application context.
 * 
 * On the other hand, you may also force ClassPathResource to be used,
 * regardless of the application context type, by specifying the special
 * classpath: prefix:
 * 
 * Resource template =
 * ctx.getResource("classpath:some/resource/path/myTemplate.txt");
 * 
 * Similarly, one can force a UrlResource to be used by specifying any of the
 * standard java.net.URL prefixes:
 * 
 * Resource template =
 * ctx.getResource("file:/some/resource/path/myTemplate.txt");
 * 
 * Resource template =
 * ctx.getResource("http://myhost.com/resource/path/myTemplate.txt");
 * 
 * @author donald 2017年11月26日 下午12:45:55
 */
public class ResourcesBoot {
	private static final Logger log = LoggerFactory.getLogger(ResourcesBoot.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "ApplicationContext.xml" });
		Resource resource = context.getResource("classpath:jdbc.properties");
		log.info("file name:{}", resource.getFilename());
		try {
			log.info("file uri:{}", resource.getURI().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			log.info("file url:{}", resource.getURL().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
