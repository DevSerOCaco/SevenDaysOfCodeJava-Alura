package com.devserocaco.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	
	Properties keys; 
	FileInputStream fileInputStream;
	
	
	
	public PropertiesFile() throws FileNotFoundException {
		super();
		this.keys = new Properties();
		this.fileInputStream = new FileInputStream("src/main/resources/config.properties");
	}



	public String getApiKey () {
		try {
			keys.load(fileInputStream);
			return keys.getProperty("apiKey");
		}	catch (IOException e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
}
