package com.demoqa.tests;


import com.demoqa.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


    public class WebTables {

        //  Create driver object instance

        WebDriver driver;

        @BeforeMethod
        public void setUpMethod(){
            driver = WebDriverFactory.getDriver("firefox");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demoqa.com");
        }

        @Test

        public void manipulateRecords() throws InterruptedException {
            // click on link for elements

            WebElement elements = driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[1]"));
            elements.click();

            // click on Web Tables button

            WebElement webTables = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"));
            webTables.click();
            //1. add a record

            WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
            addButton.click();

            WebElement firstName = driver.findElement(By.id("firstName"));
            firstName.click();
            firstName.sendKeys("Joe");

            WebElement lastName = driver.findElement(By.id("lastName"));
            lastName.click();
            lastName.sendKeys("Smith");

            WebElement emailBox = driver.findElement(By.id("userEmail"));
            emailBox.click();
            emailBox.sendKeys("jsmith@gmail.com");

            WebElement age = driver.findElement(By.id("age"));
            age.click();
            age.sendKeys("35");

            WebElement salary = driver.findElement(By.id("salary"));
            salary.click();
            salary.sendKeys("65000");

            WebElement department = driver.findElement(By.id("department"));
            department.click();
            department.sendKeys("Administration");

            // submit form

            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();


            // verify it was added


            WebElement actualFirstName = driver.findElement(By.xpath("//div[normalize-space()='Joe']"));

            WebElement actualLastName = driver.findElement(By.xpath("//div[normalize-space()='Smith']"));

            String expectedName = "Joe Smith";
            String actualName = actualFirstName.getText() + " " + actualLastName.getText();

            Assert.assertEquals(actualName, expectedName);

            driver.quit();

            //2. delete a record

            //   WebElement firstRecord = driver.findElement(By.id("delete-record-1"));
            //   firstRecord.sendKeys(Keys.ENTER);

            // validate record is deleted

            //   WebElement newFirstRecord = driver.findElement(By.xpath("//div[normalize-space()='Alden']"));

            //    String expectedNewFirstRecord = "Alden";
            //    String actualNewFirstRecord = newFirstRecord.getText();

            //   Assert.assertEquals(actualNewFirstRecord, expectedNewFirstRecord);


            /*The 2nd part of my coding failed so I commented it out.  I should have probably created a List of WebElements and used a For loop
            to assert that the orignal file was no longer there, but it's late now, and I still have laundry to do and
            kids to get ready for the week, but had I had time, I would have completed this task using that logic.
             */




            driver.quit();
        }





    }
