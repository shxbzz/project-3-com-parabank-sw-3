package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignUpPageDisplay(){
        //Click on register link
        clickOnElement(By.xpath("//a[text()='Register']"));
        //Expected message
        String expectedMessage = "Signing up is easy!";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        //Verifying expected vs actual
        Assert.assertEquals("Did not navigate to register page",expectedMessage,actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //Click on register link
        clickOnElement(By.xpath("//a[text()='Register']"));
        //First Name
        sendTextToElement(By.name("customer.firstName"),"Masala");
        //Last Name
        sendTextToElement(By.name("customer.lastName"),"Dosa");
        //Address
        sendTextToElement(By.name("customer.address.street"),"10 Downing Street");
        //City
        sendTextToElement(By.name("customer.address.city"),"London");
        //State
        sendTextToElement(By.name("customer.address.state"),"New York");
        //Zip Code
        sendTextToElement(By.name("customer.address.zipCode"),"LA10 0VX");
        //Phone Number
        sendTextToElement(By.name("customer.phoneNumber"),"08001222211");
        //SSN
        sendTextToElement(By.name("customer.ssn"),"1221121212");

        //Username
        sendTextToElement(By.name("customer.username"),"MasalaDosa10");
        //Password
        sendTextToElement(By.name("customer.password"),"password");
        //Confirm
        sendTextToElement(By.name("repeatedPassword"),"password");

        //Click on Register
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));

        //Expected message
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        //Verifying expected vs actual
        Assert.assertEquals("Did not register account successfully",expectedMessage,actualMessage);

    }



    @After
    public void tearDown(){
        closeBrowser();
    }

}
