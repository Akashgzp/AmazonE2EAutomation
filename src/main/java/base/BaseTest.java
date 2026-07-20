package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        driver = DriverFactory.getDriver();

        driver.get("https://www.amazon.in/");

        System.out.println("URL : " + driver.getCurrentUrl());
        System.out.println("TITLE : " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();

    }

}