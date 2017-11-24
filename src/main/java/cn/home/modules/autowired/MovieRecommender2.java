package cn.home.modules.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.home.modules.autowired.entity.MovieCatalog;

/**
 * 
 * @author donald 2017年11月24日 上午10:20:35
 */
public class MovieRecommender2 {
	/**
	 * Because autowiring by type may lead to multiple candidates, it is often
	 * necessary to have more control over the selection process. One way to
	 * accomplish this is with Spring's @Qualifier annotation. You can associate
	 * qualifier values with specific arguments, narrowing the set of type
	 * matches so that a specific bean is chosen for each argument. In the
	 * simplest case, this can be a plain descriptive value:
	 */
	@Autowired
	@Qualifier("main")
	private MovieCatalog movieCatalog;

	// ...
}
