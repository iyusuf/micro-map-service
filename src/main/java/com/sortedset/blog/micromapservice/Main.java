package com.sortedset.blog.micromapservice;

import java.io.File;

import org.apache.catalina.startup.Tomcat;
import org.apache.log4j.Logger;

public class Main 
{
private static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main( String[] args ) throws Exception
    {
	
		String webappDirLocation = "webcontent/";
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "20577";
        }

        tomcat.setPort(Integer.valueOf(webPort));
        
		// Add web application
        tomcat.addWebapp("/micromapserver", new File(webappDirLocation).getAbsolutePath());
        LOGGER.info("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());
		

        tomcat.start();
        tomcat.getServer().await();
		
    }
}
