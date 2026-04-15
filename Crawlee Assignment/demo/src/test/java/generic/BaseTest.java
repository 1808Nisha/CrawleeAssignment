package generic;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.google.common.io.Files;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BaseTest implements IAutoConstant{
	public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test; // Declared here as you requested
	@BeforeMethod
	public void setUp(Method method) throws IOException
	{
		test = extent.createTest(method.getName());
		Flib flib = new Flib();
		String url = flib.readPropertyData(PROP_PATH,"url");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);


	}

	public void failed(String methodName)
	{
		try{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(SCREENSHOT_PATH+methodName+".png");
			Files.copy(src, dest);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}


		@BeforeSuite
    public void initReport() {
        // 1. Initialize the Reporter and the Extent Object
        ExtentSparkReporter spark = new ExtentSparkReporter("./test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

public static void report( boolean condition, 
                              String testName, String passText, String failText) {
        
        // Capture screenshot as Base64 to embed in HTML
        String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

        if (condition) {
            test.log(Status.PASS, "**" + testName + "** - " + passText,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        } else {
            test.log(Status.FAIL, "**" + testName + "** - " + failText,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
            
            // Hard fail the test after reporting
            Assert.assertTrue(condition, failText);
        }
    }	


	@AfterSuite
    public void saveReport() {
        // This saves the report to the file
        if (extent != null) {
            extent.flush();
        }
    }

	}
