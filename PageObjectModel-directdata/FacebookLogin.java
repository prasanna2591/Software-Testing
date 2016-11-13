package directdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookLogin {
	
	WebDriver driver;
	
	@BeforeMethod
	public void start()
	{
		 driver=new FirefoxDriver();
	        driver.get("https://www.facebook.com/");
	}
	
    @Test(dataProvider="method2")
	public void method1(String fbusername, String fbpassword)
	{
        
        driver.findElement(By.id("email")).sendKeys(fbusername);
        driver.findElement(By.id("pass")).sendKeys(fbpassword);
        driver.findElement(By.id("u_0_n")).click();    
	}

    @DataProvider
    public Object[][] method2()
    {
    	Object[][] ar= new Object[2][2];
    	ar[0][0]="user1";
    	ar[0][1]="pswd1";
    	ar[1][0]="user2";
    	ar[1][1]="pswd2";
		return ar;	
    }
    @AfterMethod
	public void closing()
    {
    	driver.quit();
    } 
    
    
}
