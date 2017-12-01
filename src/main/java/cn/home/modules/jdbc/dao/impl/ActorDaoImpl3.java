package cn.home.modules.jdbc.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import cn.home.modules.jdbc.entity.Actor;

/**
 * This example uses the same insert as the preceding, but instead of passing in
 * the id it retrieves the auto-generated key and sets it on the new Actor
 * object. When you create the SimpleJdbcInsert, in addition to specifying the
 * table name, you specify the name of the generated key column with the
 * usingGeneratedKeyColumns method.
 * 
 * @author donald 2017年12月1日 上午8:55:52
 */
@Repository
public class ActorDaoImpl3 {
	private static final Logger log = LoggerFactory.getLogger(ActorDaoImpl3.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertActor;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertActor = new SimpleJdbcInsert(dataSource).withTableName("t_actor").usingGeneratedKeyColumns("id");
	}

	/**
	 * @param actor
	 */
	public void add(Actor actor) {
		Map<String, Object> parameters = new HashMap<String, Object>(2);
		parameters.put("first_name", actor.getFirstName());
		parameters.put("last_name", actor.getLastName());
		Number newId = insertActor.executeAndReturnKey(parameters);
		actor.setId(newId.longValue());
	}
}
