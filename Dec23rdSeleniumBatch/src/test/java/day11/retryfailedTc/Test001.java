package day11.retryfailedTc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test001 {
	static int num=5;

	@Test(retryAnalyzer = day11.retryfailedTc.MyRetryAnalyzer.class)
	public void Test1()
	{
		Assert.assertEquals(false, true);//1-skip,2-skip,3-failed
	}
	@Test
	public void Test2()
	{
		Assert.assertEquals(false, true);//1-failed
	}	
	@Test(retryAnalyzer = day11.retryfailedTc.MyRetryAnalyzer.class)
	public void Test3()
	{
		num--;
		Assert.assertTrue(num<4);//4<4--skip | 3<4 -->pass
	}
}
