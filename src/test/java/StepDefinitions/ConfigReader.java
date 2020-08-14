package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public  class ConfigReader {

	public static Properties pro = new Properties();
	
	public static String configreader() throws Exception
	{
		String chromepath;
		try {
			//Object user;
			//String projectPath = System.getProperty(user.dir);
			File src= new File("Configuration\\config.property");
			FileInputStream fi = new FileInputStream(src);

			pro.load(fi);

			chromepath = pro.getProperty("ChromeDriver");
			System.out.println("hey path for chorme== "+chromepath);
			return chromepath;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("exception is" +e.getMessage());
			return null;
		}
	}
	
	public String  getprop(String Data) throws Exception
	{
		configreader();
		String path =pro.getProperty(Data);
		return path;
	}

	public static String  getchromeURL(String URL) throws Exception
	{
		configreader();
		String path1 =pro.getProperty("URL");
		return path1;
	}
}