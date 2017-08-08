package com.niit.listeners;

import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@WebListener

public class Log4jUtil implements ServletContextListener {
	Logger log = null;

	public Log4jUtil() {

		log = Logger.getLogger(Log4jUtil.class);
	}

	// initializing the log4j
	public void contextDestroyed(ServletContextEvent event) {

	}

	public void contextInitialized(ServletContextEvent event) {
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j system is initialized at Container Startup");

	}

}
