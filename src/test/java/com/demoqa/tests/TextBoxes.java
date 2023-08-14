package com.demoqa.tests;

import com.demoqa.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;


public class TextBoxes {

    //  Create driver object instance

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com");
    }

    @Test

    public void formFill() throws InterruptedException {
        // click on link for elements

        WebElement elements = driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[1]"));
        elements.click();

        // click on Text Box button

        WebElement textBox = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"));
        textBox.click();

        // fill out form

        WebElement fullNameBox = driver.findElement(By.id("userName"));
        fullNameBox.click();
        fullNameBox.sendKeys("Aprill Sheppard");

        WebElement emailBox = driver.findElement(By.id("userEmail"));
        emailBox.click();
        emailBox.sendKeys("aprill.onq@gmail.com");

        WebElement currentAddressBox = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddressBox.click();
        currentAddressBox.sendKeys("3308 37th Avenue" + "\n" + "Council Bluffs, IA  51501");

        WebElement permanentAddressBox = driver.findElement(By.id("permanentAddress"));
        permanentAddressBox.click();
        permanentAddressBox.sendKeys("3308 37th Avenue" + "\n" + "Council Bluffs, IA  51501");

        // submit form

        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submitButton.sendKeys(Keys.ENTER);


        // verify it was accepted

        // if input was accepted, there will be an "output" box that appears below the "submit" button

        WebElement outputBox = driver.findElement(By.id("output"));

        Assert.assertTrue(outputBox.isDisplayed(), "This test failed");

        driver.quit();


    }
}
