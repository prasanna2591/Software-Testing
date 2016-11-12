package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TripPage {

	WebDriver driver;
	String url="https://www.expedia.com/";
	
@Given("^the Make my Trip home page$")
public void the_Make_my_Trip_home_page() throws Throwable {
driver = new FirefoxDriver();
driver.get(url);
}


@When("^I click on Login My Account and I enter the valid username as \"([^\"]*)\" and password as \"([^\"]*)\"$")public void i_click_on_Login_My_Account_and_I_enter_the_valid_username_and_password(String uname , String pass) throws Throwable {
	driver.findElement(By.id("header-account-menu")).click();
     driver.findElement(By.id("header-account-signin-button")).click();
 /*if i try to click on the signin button 
  * without entering the username and password 
  * we get error message , so we try to validate it using assertions using getText() or getAttribute("innerHTML") */  
     driver.findElement(By.id("submitButton")).click();
     Thread.sleep(5000);
    // String actual =driver.findElement(By.id("userEmailidError")).getText();
     String actual1 =driver.findElement(By.id("userEmailidError")).getAttribute("innerHTML");

   //  String expected= "Please enter your email address.";
    // Assert.assertEquals(actual,expected);
     Assert.assertTrue(actual1.contains("Please enter"));
     
     driver.findElement(By.id("signin-loginid")).sendKeys(uname);
     driver.findElement(By.id("signin-password")).sendKeys(pass);

}

@When("^clicked on continue$")
public void clicked_on_continue() throws Throwable {
	driver.findElement(By.id("submitButton")).click();
}

@Then("^verify the user succesfully loggedin$")
public void verify_the_user_succesfully_loggedin() throws Throwable {
String actTitle= driver.getTitle();
System.out.println(actTitle);
String expTitle= "Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares";
Assert.assertEquals(expTitle, actTitle);

}

@When("^clicked on Hotel and enter the values in the displayed fields$")
public void clicked_on_Hotel_and_enter_the_values_in_the_displayed_fields() throws Throwable {
   driver.findElement(By.id("primary-header-hotel")).click();
   driver.findElement(By.className("tab-label")).click();
   driver.findElement(By.id("package-origin")).sendKeys("vijayawada");
}

@Then("^verify search results$")
public void verify_search_results() throws Throwable {
   
}
}

	
	
	
	
	
