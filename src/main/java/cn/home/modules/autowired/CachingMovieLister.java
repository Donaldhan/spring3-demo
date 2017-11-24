package cn.home.modules.autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * the cache will be pre-populated upon initialization and cleared upon destruction.
 * @author donald
 * 2017年11月24日
 * 上午10:55:35
 */
public class CachingMovieLister {

	  @PostConstruct
	  public void populateMovieCache() {
	      // populates the movie cache upon initialization...
	  }

	  @PreDestroy
	  public void clearMovieCache() {
	      // clears the movie cache upon destruction...
	  }
	}