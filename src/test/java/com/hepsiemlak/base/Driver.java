package com.hepsiemlak.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Driver {

    public static WebDriver driver;

    @BeforeScenario
    public void initializeDriver()  {
        driver = DriverFactory.getDriver();
    }


    @AfterScenario
    public void closeDriver() {
        driver.quit();
    }

}
