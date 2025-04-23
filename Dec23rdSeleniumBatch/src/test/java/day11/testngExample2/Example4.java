package day11.testngExample2;

import org.testng.annotations.Test;

public class Example4 {
	@Test(priority=1,enabled=true)
	public void testLoginOrangeHrm() throws InterruptedException {
		System.out.println("Hello Login");
	}	
	@Test(priority=2,enabled=true)
	public void testPIMCreationOrangeHrm() {
		System.out.println("Hello PIMCreation");
		int num=10/0;
	}	
	@Test(priority=4,enabled=true, dependsOnMethods = "testPIMCreationOrangeHrm")
	public void testPIMDeleteOrangeHrm() {
		System.out.println("Hello PIMDelete");
	}	
	@Test(priority=5,enabled=true)
	public void testLogoutOrangeHrm() {
		System.out.println("Hello Logout");
	}	
}
/*
 * TestNG method should public, nonstatic  and return type as void
 * 
 * TestNG file can have more then one @Test method in such cases it will be
 * executed alphabetically
 * 
 * Tests run count depends on @test method
 * 
 * By default all @Test has priority as zero due to which all method will be executed in alphabetically order
 * in order control the execution flow keep the priority based on requirement
 *
 * By default all @test methods are enabled for execution, to exclude any @test method provide enable=false in the parameter
  */