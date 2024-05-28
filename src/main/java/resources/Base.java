package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException, InterruptedException {

		
		prop = new Properties();
		String propPath = System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

    
	public String takeScreenshot(String testName, WebDriver driver) throws IOException {
	
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
	FileUtils.copyFile(src, new File(destFilePath));
	
	return destFilePath;
	
	}
}
