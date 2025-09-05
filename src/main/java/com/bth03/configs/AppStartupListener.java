package com.bth03.configs;

import com.bth03.utils.InitDB;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppStartupListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		InitDB.init(); // chạy khi ứng dụng start
	}
}
