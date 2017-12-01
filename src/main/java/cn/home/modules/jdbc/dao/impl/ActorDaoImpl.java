package cn.home.modules.jdbc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import cn.home.modules.jdbc.dao.ActorDao;
import cn.home.modules.jdbc.entity.Actor;

/**
 * @author donald
 * 2017年12月1日
 * 上午8:55:52
 */
@Repository
public class ActorDaoImpl implements ActorDao {
	private static final Logger log = LoggerFactory.getLogger(ActorDaoImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int[] batchUpdate(final List<Actor> actors) {
		int[] updateCounts = jdbcTemplate.batchUpdate("update t_actor set first_name = ?, last_name = ? where id = ?",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, actors.get(i).getFirstName());
						ps.setString(2, actors.get(i).getLastName());
						ps.setLong(3, actors.get(i).getId().longValue());
					}

					public int getBatchSize() {
						return actors.size();
					}
				});
		return updateCounts;
	}
	@Override
	public int[] batchUpdateWithObject(final List<Actor> actors) {
        List<Object[]> batch = new ArrayList<Object[]>();
        for (Actor actor : actors) {
            Object[] values = new Object[] {
                    actor.getFirstName(),
                    actor.getLastName(),
                    actor.getId()};
            batch.add(values);
        }
        int[] updateCounts = jdbcTemplate.batchUpdate(
                "update t_actor set first_name = ?, last_name = ? where id = ?",
                batch);
        return updateCounts;
    }
	@Override
	 public int[][] batchUpdateParameterized(final Collection<Actor> actors) {
	        int[][] updateCounts = jdbcTemplate.batchUpdate(
	                "update t_actor set first_name = ?, last_name = ? where id = ?",
	                actors,
	                100,
	                new ParameterizedPreparedStatementSetter<Actor>() {
	                    public void setValues(PreparedStatement ps, Actor argument) throws SQLException {
	                        ps.setString(1, argument.getFirstName());
	                        ps.setString(2, argument.getLastName());
	                        ps.setLong(3, argument.getId().longValue());

	                     }
	                 } );
	        return updateCounts;
	    }


}
