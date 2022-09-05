package com.alok.aut.project.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public class DbManager {

	public static Connection conn;
	static LinkedList<String> resultList = new LinkedList();
	static HashMap<String, LinkedList<String>> SqlResultMap = new HashMap<>();
	
	public static HashMap<String, LinkedList<String>> getResultMap(){
		
		return SqlResultMap;
	}
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}


}
