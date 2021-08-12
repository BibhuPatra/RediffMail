
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Rediff_Create_Account {
	static WebDriver driver ;

	@BeforeTest
	public void launch_chrome_browser(){
		System.out.println(" hello Rediff application gm ");System.setProperty("webdriver.chrome.driver", "C:\\Users\\bibhpatr\\Downloads\\Selenium_Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		String str=driver.getTitle();
		System.out.println(str);
	}

	@AfterTest

	public void close_browser(){

		driver.quit();
	}

	@Test(priority=1,enabled=true)

	public void country_exits_validation() throws Exception {


		WebElement full_name=driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input"));
		full_name.sendKeys("pravin");
		WebElement choose_rediff_mail_id=driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[7]/td[3]/input[1]"));
		choose_rediff_mail_id.sendKeys("pravin876543456");
		WebElement choose_availability_button=driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[7]/td[3]/input[2]"));
		Boolean b1=choose_availability_button.isEnabled();
		System.out.println(b1);
		choose_availability_button.click();
		Thread.sleep(2000);
		WebElement message_availabilibity=driver.findElement(By.xpath("//*[@id='check_availability']/font/b"));

		String str1=message_availabilibity.getText();

		System.out.println(str1);
		driver.findElement(By.xpath("//img[@src='https://register.rediff.com/utilities/newforgot/img/darrow_country.png']")).click();
		Thread.sleep(4000);
		List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='country_id']/ul/li"));
		int number=allElements.size();
		System.out.println(number);
		//System.out.println(allElements);

		for (WebElement element: allElements) {
			System.out.println(element.getText());
			//element.click();
		}
		String countryName="India (+91)";
		for(int i=0;i<allElements.size();i++){
			if(countryName.equals(allElements.get(i).getText())){
				System.out.println(allElements.get(i).getText() +" --- "+" country exist ");
				System.out.println(i);
				allElements.get(i).click();


				// driver.findElement(By.xpath("//*[@id='country_id']/ul/li[2]")).click();
				break;
			}
		}


	}

}