package cn.home.modules.jdbc.dao.impl;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import cn.home.modules.jdbc.entity.Actor;

/**
 * 
 * @author donald 2017年12月1日 上午8:55:52
 */
@Repository
public class ActorDaoImpl5 {
	private static final Logger log = LoggerFactory.getLogger(ActorDaoImpl5.class);
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
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(actor);
		Number newId = insertActor.executeAndReturnKey(parameters);
		actor.setId(newId.longValue());
	}
}
