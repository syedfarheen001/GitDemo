package rahulShettyAcademy.ExtendReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config()  {
		
		//ExtentReports is main class that creates report and ExtentSparkReporter is helper class to configure our report
	
      String path=  System.getProperty("user.dir")+"\\reports\\index.html";
    	ExtentSparkReporter reporter =new ExtentSparkReporter(path);
    	reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Farheen");
		
		
		
	}
	
	
	
	@Test
	public void initialDemo()  {
		
		
		ExtentTest test=extent.createTest("Initial Demo");  //this is written at start of execution
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
	    driver.close();
		test.fail("Result do not match");
	    
		
		extent.flush();  //this step should be written at end of complete execution
		
	}

	

	
}
