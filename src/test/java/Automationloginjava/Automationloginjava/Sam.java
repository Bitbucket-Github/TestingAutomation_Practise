package Automationloginjava.Automationloginjava;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import stepdefinitions.ConfigReader;


public class Sam extends ConfigReader
{
	 
		public void confir() throws Exception
		{
			
		
			configreader();
			System.out.println(pro.getProperty("ChromeDrive"));
	    
		}
}