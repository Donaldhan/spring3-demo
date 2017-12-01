package cn.home.modules.orm.exception;

import java.sql.SQLException;

public class IbatisDaoException extends Exception {

	public IbatisDaoException(SQLException ex) {
		super(ex);
	}

}
