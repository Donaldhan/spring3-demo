package cn.home.modules.jdbc.dao;

import java.util.Collection;
import java.util.List;

import cn.home.modules.jdbc.entity.Actor;

/**
 * @author donald
 * 2017年12月1日
 * 上午8:53:53
 */
public interface ActorDao {
	/**
	 * @param actors
	 * @return
	 */
	public abstract int[] batchUpdate(final List<Actor> actors); 
	/**
	 * @param actors
	 * @return
	 */
	public abstract int[] batchUpdateWithObject(final List<Actor> actors);
	/**
	 * @param actors
	 * @return
	 */
	public abstract int[][] batchUpdateParameterized(final Collection<Actor> actors);
}
