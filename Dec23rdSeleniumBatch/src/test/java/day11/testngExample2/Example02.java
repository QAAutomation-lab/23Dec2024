package day11.testngExample2;

import org.testng.annotations.Test;

public class Example02 {
  @Test
  public void TC2() {
	  System.out.println("TC2 running");
  }
  
 
  public void TC1() {
	  System.out.println("TC1 running");
  }
  
  @Test
  public void TC3() {
	  System.out.println("TC3 running");
	  TC1();
  }
}
