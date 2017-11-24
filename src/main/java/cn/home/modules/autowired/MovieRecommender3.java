package cn.home.modules.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.home.modules.autowired.dao.CustomerPreferenceDao;
import cn.home.modules.autowired.entity.MovieCatalog;

/**
 * 
 * @author donald
 * 2017年11月24日
 * 上午10:20:35
 */
public class MovieRecommender3 {
	  private MovieCatalog movieCatalog;

	  private CustomerPreferenceDao customerPreferenceDao;
	  
	  @Autowired
	  public void prepare(@Qualifier("main") MovieCatalog movieCatalog,
	                      CustomerPreferenceDao customerPreferenceDao) {
	      this.movieCatalog = movieCatalog;
	      this.customerPreferenceDao = customerPreferenceDao;
	  }

	  // ...
}
