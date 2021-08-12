import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class All_Annotation_Testing {

	@BeforeTest
	public void beforetest(){
		System.out.println("i m in @BeforeTest ");

	}

	@Test
	public void test1(){
		System.out.println("i m in @Test1 ");
	}
	@Test
	public void test2(){
		System.out.println("i m in @Test2 ");
	}
	@Test
	public void test3(){
		System.out.println("i m in @Test3 ");
	}
	@AfterTest
	public void AfterTest(){
		System.out.println("i m in @AfterTest ");
	}
	@BeforeMethod
	public void BeforeMethod(){
		System.out.println("i m in @BeforeMethod ");
	}
	@AfterMethod
	public void AfterMethod(){
		System.out.println("i m in @AfterMethod ");
	}
	@BeforeClass
	public void BeforeClass(){
		System.out.println("i m in @BeforeClass ");
	}
	@AfterClass
	public void AfterClass(){
		System.out.println("i m in @AfterClass ");
	}

	@BeforeSuite
	public void BeforeSuite(){
		System.out.println("i m in @BeforeSuite ");
	}
	@AfterSuite
	public void AfterSuite(){
		System.out.println("i m in @AfterSuite ");
	}
}