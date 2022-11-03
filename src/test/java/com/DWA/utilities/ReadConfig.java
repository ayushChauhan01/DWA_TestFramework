package com.DWA.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadConfig {
	public static Properties property;
	public static String path = "configuration/config.properties";
	
	public static void InitializeConfigFile() {
		try {
			FileInputStream fis = new FileInputStream(path);
			property = new Properties();
			property.load(fis);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
			