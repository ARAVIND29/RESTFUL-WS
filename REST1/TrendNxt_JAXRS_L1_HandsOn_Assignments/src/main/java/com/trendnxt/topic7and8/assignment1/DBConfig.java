package com.trendnxt.topic7and8.assignment1;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBConfig implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			H2MemoryDatabase.insertWithStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
