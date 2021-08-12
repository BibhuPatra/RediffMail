import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Scanner;

public class Rediff {
	public static WebDriver driver;
	@BeforeTest
	public void RediffMail() {
		System.out.println(" hello Rediff application gm ");System.setProperty("webdriver.chrome.driver", "C:\\Users\\bibhpatr\\Downloads\\Selenium_Jars\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=1,enabled=false)
	public void sign_link_click() throws Exception{
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(3000);
		String str1=driver.getTitle();
		System.out.println(str1);
	}
	@Test(priority=2)

	public void alert_handling(){
		System.out.println(" alert handling ");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.name("proceed")).click();
		Alert al =driver.switchTo().alert();
		String str=al.getText();
		System.out.println(str);
		//Thread.sleep(2000);
		al.accept();
		driver.findElement(By.id("login1")).sendKeys("bibhu");
		//al.dismiss();
	}
	@Test(priority=3)
	public void Create_Account() {
		
		Scanner data = new Scanner(System.in);
		
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[2]/div/a/u")).click();
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("Bibhu Prasad Patra");

		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("bibhuptr123456");
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]")).click();
//		System.out.println(driver.findElement(By.xpath("//*[@id=\"check_availability\"]/font/b")).getText());
//		String str=driver.findElement(By.id("recommend_text")).getText();
//		System.out.println("The Suggestions :"+str);
		String Password = "Admin@123";
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).click();
	    Select s2=new Select(driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[3]/select")));
        s2.selectByVisibleText("What is your favourite food?");
        driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).sendKeys("biriyani");
        driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).sendKeys("Mothers Name");
        
		System.out.println("Enter your phone number");
		String phoneNumber = data.nextLine();
		driver.findElement(By.id("mobno")).sendKeys(phoneNumber);
		
		System.out.println("Day for your DOB");
		String day_DOB = data.nextLine();
		Select day1 = new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]")));
		day1.selectByVisibleText(day_DOB);
		
		System.out.println("Month for your DOB");
		String month_DOB = data.nextLine();
		Select month1 = new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]")));
		month1.selectByValue(month_DOB);
		
		System.out.println("Year for your DOB");
		String year_DOB = data.nextLine();
		Select year1 = new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]")));
		year1.selectByVisibleText(year_DOB);
		
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[1]")).click();
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select")).sendKeys("Bhubaneswar");
		
		System.out.println("Mannually put the captcha");
		String captchInput = data.nextLine();
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[32]/td[3]/input")).sendKeys(captchInput);
		
		driver.findElement(By.id("Register")).click();
	}

}
