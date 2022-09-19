package Testcases;

import utilities.jxlClass;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.jxlClass;

public class GetSingleResoursesNotFound {
	@Test
	public void getSingleResoursesNotFound() throws BiffException, IOException {
		jxlClass j = new jxlClass();
		j.open("C:\\Users\\Ajeesh\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestCase.xls");
		String baseURI = j.readexcel(1, 18);
		RestAssured.baseURI = baseURI;
		String endpoint = j.readexcel(7, 27);
		Response response = RestAssured.get(endpoint);
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asPrettyString());
		if (response.getStatusCode() == 404) {
			j.writexcel("TestCase", 12, 13, "passed");
		} else {
			j.writexcel("TestCase", 12, 13, "failed");
		}
	}
}
