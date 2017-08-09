package com.niit.listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

	public void contextInitialized(ServletContextEvent event) {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("log4j.properties"));
		} catch (Exception e) {

			e.printStackTrace();
		}
		PropertyConfigurator.configure(props);

		log.info("Log4j system is initialized at Container Startup*************");

	}

	// initializing the log4j
	public void contextDestroyed(ServletContextEvent event) {

		log.info("ServletContext destroyed**************");
	}

}
