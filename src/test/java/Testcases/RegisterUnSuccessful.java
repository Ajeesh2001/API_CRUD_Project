package Testcases;

import utilities.jxlClass;
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

public class RegisterUnSuccessful {
	@Test
	public void registerUnSuccessful() throws BiffException, IOException {
		
		jxlClass j = new jxlClass();
		j.open("C:\\Users\\Ajeesh\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestCase.xls");
		String baseURI = j.readexcel(1, 18);
		RestAssured.baseURI = baseURI;
		String endpoint = j.readexcel(7, 26);
		System.out.println(endpoint);
		String email = j.readexcel(4, 26);
		String jsonstring = "{\n" + "    \"email\": \"" + email + "\"\n" + "}";
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(jsonstring);
		Response response = requestSpecification.post(endpoint);
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		System.out.println("user not registered");
		if (response.getStatusCode() == 400) {
			j.writexcel("TestCase", 12, 18, "passed");
		} else {
			j.writexcel("TestCase", 12, 18, "failed");
		}

	}
}
