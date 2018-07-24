package com.cottonon.rough;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Rough{

	public static Logger log=Logger.getLogger(Rough.class.getName());
	public static void main(String[] args) {
		String log4jConfPath = "E:\\eclipse\\cottonon\\src\\test\\resources\\properties\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		System.out.println("hi");
		log.debug("printing msg");
		
	}

}
