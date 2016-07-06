package com.tyaer.basic.datebase.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * mysql操作工具
 * */
public class MysqlHelper extends DatabaseImpl{
	// 驱动信息
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	public MysqlHelper(String USERNAME, String PASSWORD, String URL) {
		super(DRIVER, USERNAME, PASSWORD, URL);
	}

	public static void main(String[] args) throws SQLException {
		MysqlHelper mysqlHelper = new MysqlHelper("root","123456","jdbc:mysql://127.0.0.1:3306/traffic");
		String sql="select * from hh_v_acd_dutysimple";
		List<Map<String, Object>> modeResult = mysqlHelper.findModeResult(sql, null);
		mysqlHelper.showQueryResult(modeResult);
	}

}
