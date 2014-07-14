package edu.java.ishop.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfiguration {

	private static class AppConfigHolder {
		private static Properties PROPS = new Properties();

		static {
			InputStream is = ApplicationConfiguration.class.getClassLoader().getResourceAsStream("application.properties");
			try {
				PROPS.load(is);
			} catch (IOException e) {
					throw new ExceptionInInitializerError("Failed to load application.properties");
			}
		}
	}
	
	private ApplicationConfiguration() {
	}

	public static String getItem(String key){
		return AppConfigHolder.PROPS.getProperty(key);
	}
}
