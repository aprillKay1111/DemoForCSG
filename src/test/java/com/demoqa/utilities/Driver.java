package com.demoqa.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    // create a private constructor to remove access to this object

    public Driver() {
    }

    /*
    We make the webdriver private because we want to close access from outside the class
    We are making it static becuase we will use it in a static method.
     */

    private static WebDriver driver; // default value == null


    // create a reusable util method which will return the same driver instance once we call it
    // if an instance doesnt exist it will create first and then it will always return the same instance

    public static WebDriver getDriver() {

        if (driver == null) {

            // we will read our browser type from config.properties file
            String browserType = ConfigReader.getProperty("browser");


            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;


            }

        }
        return driver;
    }

    // create a new driver.closeDriver() method; it will use the .quit() method to quit browsers and then set the driver value back to null

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}



