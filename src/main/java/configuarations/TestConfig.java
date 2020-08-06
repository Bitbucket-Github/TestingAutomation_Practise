package configuarations;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class TestConfig {
	
	@Test
	public void config() throws IOException {
	File src=new File("C:\\Users\\Guest\\eclipse-workspace2\\MyStore\\properties\\config.properties"); 	
	FileInputStream fis = new FileInputStream(src);
	Properties pro = new Properties();
	pro.load(fis);

}

}