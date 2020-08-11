package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	public static Properties pro= new Properties();




	public static String configreader() throws Exception
	{
		String chromepath;
		try {
			File src= new File("C:\\Users\\abita\\Desktop\\Automationloginjava\\Configuration\\config.property");
			FileInputStream fi = new FileInputStream(src);

			//pro= new Properties();

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

	/*public String  getchromepath() throws Exception
	{

		String path =pro.getProperty("ChromeDriver");
		System.out.println("path is" +path);
		return path;


	}


	public String  getchromeURL()
	{

		String path1 =pro.getProperty("URL");

		return path1;

	}
*/
}
