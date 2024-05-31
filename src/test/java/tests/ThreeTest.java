package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	
	@Test
	public void testThree() throws IOException, InterruptedException {
		
		System.out.println("TestThree");
		WebDriver driver = initializeDriver();

		//Editing from GitHub
		System.out.println("This line is updated by Priyanka from GitHub");
		
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		driver.close();
	}

}
