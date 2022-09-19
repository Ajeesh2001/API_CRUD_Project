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

public class InvalidDelete {
	@Test
	public void deleteMethod() throws BiffException, IOException {
		jxlClass j = new jxlClass();
		j.open("C:\\Users\\Ajeesh\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestCase.xls");
		String baseURI = j.readexcel(1, 18);
		RestAssured.baseURI = baseURI;
		String endpoint = j.readexcel(7, 24);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response1 = requestSpecification.delete(endpoint);
		System.out.println(response1.getStatusCode());
		String responsestring = response1.asPrettyString();
		System.out.println(responsestring);
		if (response1.getStatusCode() == 204) {
			j.writexcel("TestCase", 12, 22, "passed");
		} else {
			j.writexcel("TestCase", 12, 22, "failed");
		}
	}
}
