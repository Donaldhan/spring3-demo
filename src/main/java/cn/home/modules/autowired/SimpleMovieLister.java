package cn.home.modules.autowired;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import cn.home.modules.autowired.dao.MovieFinder;

/**
 * This annotation simply indicates that the affected bean property must be
 * populated at configuration time, through an explicit property value in a bean
 * definition or through autowiring. The container throws an exception if the
 * affected bean property has not been populated; this allows for eager and
 * explicit failure, avoiding NullPointerExceptions or the like later on. It is
 * still recommended that you put assertions into the bean class itself, for
 * example, into an init method. Doing so enforces those required references and
 * values even when you use the class outside of a container
 * 
 * @author donald 2017年11月24日 上午10:07:08
 */
@Service("myMovieLister")
public class SimpleMovieLister {

	private MovieFinder movieFinder;

	@Required
	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

	// ...
}