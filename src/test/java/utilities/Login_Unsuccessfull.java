package utilities;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.read.biff.BiffException;

public class Login_Unsuccessfull {
	public void incorrectPass() throws BiffException, IOException {

		jxlClass j = new jxlClass();
		j.open("C:\\Users\\Ajeesh\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestCase.xls");
		String baseURI = j.readexcel(1, 18);
		RestAssured.baseURI = baseURI;
		String endpoint = j.readexcel(7, 22);
		System.out.println(endpoint);
		String email = j.readexcel(4, 22);
		String password = j.readexcel(5, 22);
		String jsonstring = "{\n"

				+ "    \"email\": \"" + email + "\",\n"

				+ "    \"password\": \"" + password + "\"\n"

				+ "}";

		RequestSpecification requestSpecification = RestAssured.given();

		requestSpecification.contentType(ContentType.JSON);

		requestSpecification.body(jsonstring);

		Response response = requestSpecification.post(endpoint);

		System.out.println(response.getStatusCode());

		System.out.println(response.asPrettyString());

		System.out.println("user login unsuccessful");
		if (response.getStatusCode() == 400) {
			j.writexcel("TestCase", 12, 20, "passed");
		} else {
			j.writexcel("TestCase", 12, 20, "failed");
		}
	}
	public void withoutEmail() throws BiffException, IOException {

		jxlClass j = new jxlClass();
		j.open("C:\\Users\\Ajeesh\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestCase.xls");
		String baseURI = j.readexcel(1, 18);
		RestAssured.baseURI = baseURI;
		String endpoint = j.readexcel(7, 23);
		System.out.println(endpoint);
		String email = j.readexcel(4, 23);
		String password = j.readexcel(5, 23);
		String jsonstring = "{\n"

				+ "    \"email\": \"" + email + "\",\n"

				+ "    \"password\": \"" + password + "\"\n"

				+ "}";

		RequestSpecification requestSpecification = RestAssured.given();

		requestSpecification.contentType(ContentType.JSON);

		requestSpecification.body(jsonstring);

		Response response = requestSpecification.post(endpoint);

		System.out.println(response.getStatusCode());

		System.out.println(response.asPrettyString());

		System.out.println("user login unsuccessful");
		if (response.getStatusCode() == 400) {
			j.writexcel("TestCase", 12, 20, "passed");
		} else {
			j.writexcel("TestCase", 12, 20, "failed");
		}
	}
	public void withoutPassword() throws BiffException, IOException {

		jxlClass j = new jxlClass();
		j.open("C:\\Users\\Ajeesh\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestCase.xls");
		String baseURI = j.readexcel(1, 18);
		RestAssured.baseURI = baseURI;
		String endpoint = j.readexcel(7, 24);
		System.out.println(endpoint);
		String email = j.readexcel(4, 24);
		String password = j.readexcel(5, 24);
		String jsonstring = "{\n"

				+ "    \"email\": \"" + email + "\",\n"

				+ "    \"password\": \"" + password + "\"\n"

				+ "}";

		RequestSpecification requestSpecification = RestAssured.given();

		requestSpecification.contentType(ContentType.JSON);

		requestSpecification.body(jsonstring);

		Response response = requestSpecification.post(endpoint);

		System.out.println(response.getStatusCode());

		System.out.println(response.asPrettyString());

		System.out.println("user login unsuccessful");
		if (response.getStatusCode() == 400) {
			j.writexcel("TestCase", 12, 20, "passed");
		} else {
			j.writexcel("TestCase", 12, 20, "failed");
		}
	}
	public void NullTest() throws BiffException, IOException {

		jxlClass j = new jxlClass();
		j.open("C:\\Users\\Ajeesh\\eclipse-workspace\\ApiProject\\src\\test\\java\\Testcases\\TestCase.xls");
		String baseURI = j.readexcel(1, 18);
		RestAssured.baseURI = baseURI;
		String endpoint = j.readexcel(7, 25);
		System.out.println(endpoint);
		String email = j.readexcel(4, 25);
		String password = j.readexcel(5, 25);
		String jsonstring = "{\n"

				+ "    \"email\": \"" + email + "\",\n"

				+ "    \"password\": \"" + password + "\"\n"

				+ "}";

		RequestSpecification requestSpecification = RestAssured.given();

		requestSpecification.contentType(ContentType.JSON);

		requestSpecification.body(jsonstring);

		Response response = requestSpecification.post(endpoint);

		System.out.println(response.getStatusCode());

		System.out.println(response.asPrettyString());

		System.out.println("user login unsuccessful");
		
	}

}
