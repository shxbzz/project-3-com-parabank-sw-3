package utility;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Utility extends BaseTest {


    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();

    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    //************************ Alert Methods ************************
    //Switch to method instead of typing it out all the time
    public void switchToAlert(){
        driver.switchTo().alert();
    }

    //Homework 4 Method acceptAlert, dismissAlert, String getTextFromAlert, sendTextToAlert(String text)

    //*********************** Select Class Methods ******************

    public void selectByVisibleTextFromDropdown(By by ,String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectByValueFromDropdown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(value);

    }
    public void selectByIndex(){

    }


}

