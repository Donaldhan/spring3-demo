package cn.home.modules.autowired;

import org.springframework.beans.factory.annotation.Autowired;

import cn.home.modules.autowired.dao.MovieFinder;

/**
 * 
 * 
 * @author donald 2017年11月24日 上午10:07:08
 */
public class SimpleMovieLister2 {

	private MovieFinder movieFinder;

	/**
	 * By default, the autowiring fails whenever zero candidate beans are
	 * available; the default behavior is to treat annotated methods,
	 * constructors, and fields as indicating required dependencies. This
	 * behavior can be changed as demonstrated below.
	 * 
	 * @param movieFinder
	 */
	@Autowired(required = false)
	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

	// ...
}