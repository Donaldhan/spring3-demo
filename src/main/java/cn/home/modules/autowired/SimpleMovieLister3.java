package cn.home.modules.autowired;

import javax.annotation.Resource;

import cn.home.modules.autowired.dao.MovieFinder;

/**
 * 
 * 
 * @author donald 2017年11月24日 上午10:07:08
 */
public class SimpleMovieLister3 {

	private MovieFinder movieFinder;
	@Resource(name="myMovieFinder")
	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

	// ...
}