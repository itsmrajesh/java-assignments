package com.noobs.cj.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DBUtil {
	obj;
	Connection con;

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/javaproduct?autoReconnect=true&useSSL=false";
		String user = "rajesh";
		String password = "mysql123";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
