package Testcases;
import utilities.Login_Unsuccessfull;

import java.io.File;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.jxlClass;
public class LoginUnSuccessful {
  @Test
  public void f() throws BiffException, IOException {
	  Login_Unsuccessfull ls=new Login_Unsuccessfull();
	  ls.incorrectPass();
	  ls.withoutEmail();
	  ls.withoutPassword();
	  ls.NullTest();
	  
			  
  }
}

