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
 * The SimpleJdbcInsert and SimpleJdbcCall classes provide a simplified
 * configuration by taking advantage of database metadata that can be retrieved
 * through the JDBC driver. This means there is less to configure up front,
 * although you can override or turn off the metadata processing if you prefer
 * to provide all the details in your code.
 * 
 * @author donald 2017年12月1日 上午8:55:52
 */
@Repository
public class ActorDaoImpl2 {
	private static final Logger log = LoggerFactory.getLogger(ActorDaoImpl2.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertActor;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertActor = new SimpleJdbcInsert(dataSource).withTableName("t_actor");
	}

	/**
	 * @param actor
	 */
	public void add(Actor actor) {
		Map<String, Object> parameters = new HashMap<String, Object>(3);
		parameters.put("id", actor.getId());
		parameters.put("first_name", actor.getFirstName());
		parameters.put("last_name", actor.getLastName());
		insertActor.execute(parameters);
	}
}
