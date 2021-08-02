package com.hepsiemlak.base;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage {
    protected WebDriver driver;
    protected AppiumDriver androidDriver;

    WebDriverWait wait;
    JavascriptExecutor executor;

    public BasePage(AppiumDriver driver) {
        this.androidDriver = driver;
        this.wait = new WebDriverWait(this.androidDriver, 30L, 500L);
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30L, 500L);
    }

    public WebElement findElement(By by) {
        return  this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }




    public List<WebElement> findElements(By by) {
        return (List)this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public void clickElement(By by) {
        WebElement element = this.findElement(by);
        ((WebElement) this.wait.until(ExpectedConditions.elementToBeClickable(element))).click();
    }



    public void scrollToElement(By by) {
        WebElement element=findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollAndClick(By by) {
        WebElement element = findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void sendKeys(By by, CharSequence text) {
        sleep(440L);

        this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(new CharSequence[]{text});
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public String getText(By by) {
        return findElement(by).getText();
    }



    public void sleep(Long milliScond){
        try {
            Thread.sleep(milliScond);
        }catch (Exception e){

        }
    }
}
