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

public class LoginSuccessful {
	@Test
	public void loginSucessful() throws BiffException, IOException {
		jxlClass j = new jxlClass();
		j.open("C:\\Users\\Ajeesh\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestCase.xls");
		String baseURI = j.readexcel(1, 18);
		RestAssured.baseURI = baseURI;
		String endpoint = j.readexcel(7, 13);
		String email = j.readexcel(4, 13);
		String password = j.readexcel(5, 13);
		String jsonstring = "{\n"
				+ "    \"email\": \"" + email + "\",\n"
				+ "    \"password\": \"" + password + "\"\n"
				+ "}";
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(jsonstring);
		Response response = requestSpecification.post(endpoint);
		System.out.println(response.getStatusCode());
		System.out.println("user login successful");
		System.out.println(response.asPrettyString());
		System.out.println();
		if (response.getStatusCode() == 200) {
			j.writexcel("TestCase", 12, 19, "passed");
		} else {
			j.writexcel("TestCase", 12, 19, "failed");
		}
	
	}
	}

