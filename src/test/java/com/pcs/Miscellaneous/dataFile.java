package com.pcs.Miscellaneous;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class dataFile {
  @Test
	public void f() throws IOException {

	  Properties prop=new Properties();

	  FileInputStream fis =new FileInputStream("E:\\git\\NewExcelUtil2020_ApachePOI-master\\data.properties");
	  prop.load(fis);
	  System.out.println(prop.getProperty("browser"));
	  System.out.println(prop.getProperty("url"));

	  prop.setProperty("browser", "firefox");
	  FileOutputStream fos =new FileOutputStream("E:\\git\\NewExcelUtil2020_ApachePOI-master\\data.properties");
	  prop.store(fos, null);
		System.out.println(prop.getProperty("browser"));
}

}