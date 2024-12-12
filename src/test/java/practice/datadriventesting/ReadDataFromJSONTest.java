package practice.datadriventesting;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSONTest {

	public static void main(String[] args) throws IOException, ParseException {

		// Step 1: Parse JSON Physical file in to Java Object using JSONparser class

		/*
		 * FileReader fr = new
		 * FileReader("D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\appCommonData.json"); 
		 * we can use first create object of FileReader class and pass the json filepath and use it again in parse() method
		 * path int it. or GO DIRECTLY
		 */

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\appCommonData.json"));
       
		//Step 2: convert java object in to JSON object using downcasting
		JSONObject map = (JSONObject) obj;

		//Step 3:get the value from json file using key 
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOut"));

	}
}
