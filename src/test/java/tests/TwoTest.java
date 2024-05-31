package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base{
	
	@Test
	public void testTwo() throws IOException, InterruptedException  {
		
		System.out.println("TestTwo");
		System.out.println("Priyanka has updated this code with this statement");
		WebDriver driver = initializeDriver();
		
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		driver.close();
	}
}


