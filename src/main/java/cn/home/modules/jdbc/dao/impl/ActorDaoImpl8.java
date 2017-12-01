package cn.home.modules.jdbc.dao.impl;

import java.sql.Types;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import cn.home.modules.jdbc.entity.Actor;

/**
 * The SimpleJdbcCall class leverages metadata in the database to look up names
 * of in and out parameters, so that you do not have to declare them explicitly.
 * You can declare parameters if you prefer to do that, or if you have
 * parameters such as ARRAY or STRUCT that do not have an automatic mapping to a
 * Java class. The first example shows a simple procedure that returns only
 * scalar values in VARCHAR and DATE format from a MySQL database. The example
 * procedure reads a specified actor entry and returns first_name, last_name,
 * and birth_date columns in the form of out parameters.
 * 
 * CREATE PROCEDURE read_actor ( IN in_id INTEGER, OUT out_first_name
 * VARCHAR(100), OUT out_last_name VARCHAR(100), OUT out_birth_date DATE) BEGIN
 * SELECT first_name, last_name, birth_date INTO out_first_name, out_last_name,
 * out_birth_date FROM t_actor where id = in_id; END;
 * 
 * @author donald 2017年12月1日 上午8:55:52
 */
@Repository
public class ActorDaoImpl8 {
	private static final Logger log = LoggerFactory.getLogger(ActorDaoImpl8.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall procReadActor;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        this.procReadActor =
                new SimpleJdbcCall(jdbcTemplate)
                        .withProcedureName("read_actor")
                        .withoutProcedureColumnMetaDataAccess()
                        .useInParameterNames("in_id")
                        .declareParameters(
                                new SqlParameter("in_id", Types.NUMERIC),
                                new SqlOutParameter("out_first_name", Types.VARCHAR),
                                new SqlOutParameter("out_last_name", Types.VARCHAR),
                                new SqlOutParameter("out_birth_date", Types.DATE)
                        );
    }

    public Actor readActor(Long id) {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", id);
        Map out = procReadActor.execute(in);
        Actor actor = new Actor();
        actor.setId(id);
        actor.setFirstName((String) out.get("out_first_name"));
        actor.setLastName((String) out.get("out_last_name"));
        actor.setBirthDate((Date) out.get("out_birth_date"));
        return actor;
    }

}
