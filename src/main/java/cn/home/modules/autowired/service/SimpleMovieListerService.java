package cn.home.modules.autowired.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.home.modules.autowired.dao.MovieFinder;

public class SimpleMovieListerService {
	  private MovieFinder movieFinder;

	  @Autowired
	  public void SimpleMovieLister(MovieFinder movieFinder) {
	      this.movieFinder = movieFinder;
	  }
}
