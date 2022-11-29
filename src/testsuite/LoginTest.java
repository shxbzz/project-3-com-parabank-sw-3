package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
        sendTextToElement(By.name("username"), "MasalaDosa10");
        //Enter valid password
        sendTextToElement(By.name("password"), "password");
        //Click on login button
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //Verify account overview text is display
        String expectedMessage = "Accounts Overview";

        WebElement actualTextFromElement = driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));

        String actualMessage = actualTextFromElement.getText();

        Assert.assertEquals("Accounts Overview", expectedMessage, actualMessage);


    }

    @Test
    public void verifyTheErrorMessage() {

        //Enter valid username
        sendTextToElement(By.name("username"), "invalid");
        //Enter valid password
        sendTextToElement(By.name("password"), "invalid123");
        //Click on login button
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //Verify account overview text is display
        String expectedMessage = "The username and password could not be verified.";

        WebElement actualTextFromElement = driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));

        String actualMessage = actualTextFromElement.getText();

        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);


    }

    @Test
    public void userShouldLogOutSuccessfully() {

        //Website does not work, can't log in or log out




    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
