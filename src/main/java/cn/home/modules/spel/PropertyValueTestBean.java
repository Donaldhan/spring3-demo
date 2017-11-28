package cn.home.modules.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import cn.home.modules.autowired.dao.MovieFinder;

public class PropertyValueTestBean {

	private String defaultLocale;
	private MovieFinder movieFinder;

	@Autowired
	public void configure(MovieFinder movieFinder,
			@Value("#{ systemProperties['user.region'] }") String defaultLocale) {
		this.movieFinder = movieFinder;
		this.defaultLocale = defaultLocale;
	}

	@Value("#{ systemProperties['user.region'] }")
	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	public String getDefaultLocale() {
		return this.defaultLocale;
	}

}
