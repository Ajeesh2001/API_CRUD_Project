package Testcases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.jxlClass;

public class Patch {
	@Test
	public void update() throws BiffException, IOException {

		jxlClass j = new jxlClass();
		j.open("C:\\Users\\Ajeesh\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestCase.xls");
		String baseURI = j.readexcel(1, 18);
		RestAssured.baseURI = baseURI;
		String endpoint = j.readexcel(7, 9);
		String name = j.readexcel(2, 9);
		String job = j.readexcel(3, 9);
		String jsonString = "{\n" + "    \"name\": \"" + name + "\",\n" + "    \"job\": \"" + job + "\"\n" + "}";
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		requestspecification.body(jsonString);
		Response response = requestspecification.patch(endpoint);
		System.out.println("Put Updation successful");
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		if (response.getStatusCode() == 200) {
			j.writexcel("TestCase", 12, 23, "passed");
		} else {
			j.writexcel("TestCase", 12, 23, "failed");
		}
	}
}
