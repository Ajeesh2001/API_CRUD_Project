package Testcases;

import utilities.jxlClass;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.jxlClass;

public class Post {
	private static final String JSON = null;

	@Test
	public void postCreate() throws BiffException, IOException {
		jxlClass j = new jxlClass();
		j.open("C:\\Users\\Ajeesh\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestCase.xls");
		String baseURI = j.readexcel(1, 18);
		RestAssured.baseURI = baseURI;
		String endpoint = j.readexcel(7, 7);
		String Name = j.readexcel(2, 7);
		String Job = j.readexcel(3, 7);
		String jsonString = "{\n" + "    \"name\": \"" + Name + "\",\n" + "    \"job\": \"" + Job + "\"\n" + "}";
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(jsonString);
		Response response = requestSpecification.post(endpoint);
		String responsestring = response.asPrettyString();
		System.out.println(responsestring);
		if (response.getStatusCode() == 201) {
			j.writexcel("TestCase", 12, 14, "passed");
		} else {
			j.writexcel("TestCase", 12, 14, "failed");
		}
	}
}
