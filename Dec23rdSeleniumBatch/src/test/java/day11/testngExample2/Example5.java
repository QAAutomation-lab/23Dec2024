package day11.testngExample2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Example5 {
  @Test
  public void testOrangeHrm() {
	  System.out.println("----- Login in OrangeHRM is done -----");
  }
  
  @Test
  public void testActitime() {
	  System.out.println("----- Login in Actitime is done -----");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("@@@@@@@@@@@@@@@ BeforeMethod @@@@@@@@@@@@@@@@@@@@");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("@@@@@@@@@@@@@@@ AfterMethod @@@@@@@@@@@@@@@@@@@@");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("#################BeforeClass#######################");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("#################AfterClass#######################");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("************BeforeTest****************");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("************AfterTest****************");
  }

}
