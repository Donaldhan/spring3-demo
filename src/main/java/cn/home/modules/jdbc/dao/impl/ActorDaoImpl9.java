package cn.home.modules.jdbc.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import cn.home.modules.jdbc.entity.Actor;

/**
 * @author donald 2017年12月1日 上午8:55:52
 */
@Repository
public class ActorDaoImpl9 {
	private static final Logger log = LoggerFactory.getLogger(ActorDaoImpl9.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertActor;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertActor = new SimpleJdbcInsert(dataSource).withTableName("lob_table").usingGeneratedKeyColumns("id");
	}

	/**
	 * @param actor
	 * @throws IOException 
	 */
	public void add(Actor actor) throws IOException {
		final LobHandler  lobHandler = new DefaultLobHandler();
		final File blobIn = new File("spring2004.jpg");
		final InputStream blobIs = new FileInputStream(blobIn);
		final File clobIn = new File("large.txt");
		final InputStream clobIs = new FileInputStream(clobIn);
		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		jdbcTemplate.execute("INSERT INTO lob_table (id, a_clob, a_blob) VALUES (?, ?, ?)",
				new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
					protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException {
						ps.setLong(1, 1L);
						lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int) clobIn.length());
						lobCreator.setBlobAsBinaryStream(ps, 3, blobIs, (int) blobIn.length());
					}
				});
		blobIs.close();
		clobReader.close();
	}

	public void getActor(Actor actor) {
		final LobHandler  lobHandler = new DefaultLobHandler();
		List<Map<String, Object>> l = jdbcTemplate.query("select id, a_clob, a_blob from lob_table",
		        new RowMapper<Map<String, Object>>() {
		          public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		            Map<String, Object> results = new HashMap<String, Object>();
		            String clobText = lobHandler.getClobAsString(rs, "a_clob");
		            results.put("CLOB", clobText);
		            byte[] blobBytes = lobHandler.getBlobAsBytes(rs, "a_blob");
		            results.put("BLOB", blobBytes);
		            return results;
		          }
		        });
	}

}
