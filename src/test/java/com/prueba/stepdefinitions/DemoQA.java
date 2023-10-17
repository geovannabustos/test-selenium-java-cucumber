package com.prueba.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

public class DemoQA {
    WebDriver driver = new SafariDriver();
    private WebElement optionTextBox;
    private WebElement userName;
    private WebElement userEmail;
    private WebElement currentAddress;
    private WebElement permanentAddress;
    private WebElement buttonSubmit;
    private WebElement nameP;
    private WebElement emailP;
    private WebElement currentAddressP;
    private WebElement permanentAddressP;
    @Given("I have DemoQA url")
    public void i_have_demoQA_url(){
        driver.get("https://demoqa.com/elements");
    }
    @When("I fill out the form Text Box, with userName {string}, userEmail {string}, currentAddress {string}, permanentAddress {string}")
    public void i_fill_form_text_box(String userNameValue, String userEmailValue, String currentAddressValue, String permanentAddressValue) throws Exception {
        optionTextBox = driver.findElement(By.xpath("//span[contains(@class,'text')]  [contains(text(),'Text Box')]"));
        optionTextBox.click();
        userName = driver.findElement(By.id("userName"));
        userName.sendKeys(userNameValue);
        userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(userEmailValue);
        currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(currentAddressValue);
        permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(permanentAddressValue);
        takeSnapShot(driver, "target/snapshots/form_text_box.png") ;
    }
    @And("I press enter Submit")
    public void i_press_enter_submit() throws Exception {
        buttonSubmit = driver.findElement(By.id("submit"));
        buttonSubmit.click();
        takeSnapShot(driver, "target/snapshots/form_submit.png") ;
    }
    @Then("I see information, userName {string}, userEmail {string}, currentAddress {string}, permanentAddress {string}")
    public void i_see_search_head(String userNameValue, String userEmailValue, String currentAddressValue, String permanentAddressValue) throws Exception {
        nameP = driver.findElement(By.id("name"));
        Assert.assertEquals(nameP.getAttribute("innerHTML"), "Name:"+userNameValue);
        emailP = driver.findElement(By.id("email"));
        Assert.assertEquals(emailP.getAttribute("innerHTML"), "Email:"+userEmailValue);
        currentAddressP = driver.findElement(By.id("currentAddress"));
        Assert.assertEquals(currentAddressP.getAttribute("innerHTML"), "Current Address :"+currentAddressValue);
        permanentAddressP = driver.findElement(By.id("permanentAddress"));
        Assert.assertEquals(permanentAddressP.getAttribute("innerHTML"), "Permananet Address :"+permanentAddressValue);
    }
    @After
    public void closeDriver() {
        driver.close();
    }
    public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}