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
 * 
 * You can limit the columns for an insert by specifying a list of column names
 * with the usingColumns method:
 * 
 * @author donald 2017年12月1日 上午8:55:52
 */
@Repository
public class ActorDaoImpl4 {
	private static final Logger log = LoggerFactory.getLogger(ActorDaoImpl4.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertActor;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertActor = new SimpleJdbcInsert(dataSource).withTableName("t_actor")
				.usingColumns("first_name", "last_name").usingGeneratedKeyColumns("id");
	}

	public void add(Actor actor) {
		Map<String, Object> parameters = new HashMap<String, Object>(2);
		parameters.put("first_name", actor.getFirstName());
		parameters.put("last_name", actor.getLastName());
		Number newId = insertActor.executeAndReturnKey(parameters);
		actor.setId(newId.longValue());
	}
}
