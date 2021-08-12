import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest{
	WebDriver driver;

	@DataProvider(name = "suyash")

	public static Object[][] credentials() {

		return new Object[][] {
			{ "niveditha", "password123" },
			{ "deepika", "password456" },
			{ "saurabh", "password567" },

		};

	}

	@DataProvider(name="pravin")
	public static Object[][] logindata99(){
		return new Object[][]{
			{ "archana", "password123" },
			{ "bhavya", "password456" },
			{ "chandra", "password567" },
		};
	}

	@DataProvider(name="Mine")
	public static Object[][] logindata991(){
		return new Object[][]{
			{ "ajay", "password123" },
			//			{ "aakash", "password456" },
			//			{ "sahil", "password567" },
			{ "bibhuptr1@rediffmail.com", "Admin@123" },
		};
	}

	//Here we are calling the Data Provider object with its Name

	@Test(dataProvider = "Mine")

	public void invalid_login(String Username, String Password) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bibhpatr\\Downloads\\Selenium_Jars\\chromedriver.exe");

		//Create Browser object
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("login")).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.name("passwd")).sendKeys(Password);
		Thread.sleep(2000);
		driver.findElement(By.name("proceed")).click();
		String str2=  driver.getTitle();
		System.out.println(str2);

		if(driver.findElement(By.xpath("//*[@id=\"div_login_error\"]/b")).getText().equalsIgnoreCase(
				"Wrong username and password combination."
				));
		{
			driver.quit();
		}

		//            
		//System.out.println("test passed");
		//            Assert.assertEquals(10, 10);
		//            System.out.println("9 is equal to 10 ");
		//            Assert.assertFalse(false);






	}



}
