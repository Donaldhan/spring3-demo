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
 * When constructing an XML-based application context, a location string may use
 * the special classpath*: prefix:
 * 
 * ApplicationContext ctx = new
 * ClassPathXmlApplicationContext("classpath*:conf/appContext.xml");
 * 
 * This special prefix specifies that all classpath resources that match the
 * given name must be obtained (internally, this essentially happens via a
 * ClassLoader.getResources(...) call), and then merged to form the final
 * application context definition.
 * 
 * A FileSystemResource that is not attached to a FileSystemApplicationContext
 * (that is, a FileSystemApplicationContext is not the actual ResourceLoader)
 * will treat absolute vs. relative paths as you would expect. Relative paths
 * are relative to the current working directory, while absolute paths are
 * relative to the root of the filesystem.
 * 
 * For backwards compatibility (historical) reasons however, this changes when
 * the FileSystemApplicationContext is the ResourceLoader. The
 * FileSystemApplicationContext simply forces all attached FileSystemResource
 * instances to treat all location paths as relative, whether they start with a
 * leading slash or not. In practice, this means the following are equivalent:
 * 
 * ApplicationContext ctx = new
 * FileSystemXmlApplicationContext("conf/context.xml");
 * 
 * ApplicationContext ctx = new
 * FileSystemXmlApplicationContext("/conf/context.xml");
 * 
 * As are the following: (Even though it would make sense for them to be
 * different, as one case is relative and the other absolute.)
 * 
 * FileSystemXmlApplicationContext ctx = ...;
 * ctx.getResource("some/resource/path/myTemplate.txt");
 * 
 * FileSystemXmlApplicationContext ctx = ...;
 * ctx.getResource("/some/resource/path/myTemplate.txt");
 * 
 * In practice, if true absolute filesystem paths are needed, it is better to
 * forgo the use of absolute paths with FileSystemResource /
 * FileSystemXmlApplicationContext, and just force the use of a UrlResource, by
 * using the file: URL prefix.
 * 
 * // actual context type doesn't matter, the Resource will always be
 * UrlResource ctx.getResource("file:/some/resource/path/myTemplate.txt");
 * 
 * // force this FileSystemXmlApplicationContext to load its definition via a
 * UrlResource ApplicationContext ctx = new
 * FileSystemXmlApplicationContext("file:/conf/context.xml");
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
