package com.hepsiemlak.page;

import com.hepsiemlak.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.hepsiemlak.constants.Constants.*;

public class SatilikPage extends BasePage {



    public SatilikPage(WebDriver driver) {
        super(driver);
    }


    public String getSatilikTitle(){
        return getTitle();
    }

    public void choiceCity(String temp) {


        clickElement(LOCATION_SELECT);
        scrollAndClick(By.xpath("//li[./span[contains(text(),'" + temp + "')]]"));
    }

    public void clickOnCountry() {
        clickElement(COUNTRY_SELECT);
    }

    public void choiceCountry(String temp) {
        scrollAndClick(By.xpath("//li[./span[contains(text(),'" + temp + "')]]"));

    }
    public void choiceCategory() {
        clickElement(CATEGORY_RADIO_BUTTON);
    }

    public void enterMinPrice(String price) {
        sendKeys(MIN_PRICE_INPUT, price);
    }

    public void enterMaxPrice(String price) {
        sendKeys(MAX_PRICE_INPUT, price);
    }

    public void clickBuildingAge() {
        scrollAndClick(BUILDINIG_AGE_SELECT);
    }

    public void choiceBuildingAge(String temp) {

        clickElement(By.xpath("//li[./label/span[contains(text(),'" + temp + "')]]"));
     }

    public void clickSearchBtn() {
        clickElement(SEARCH_BTN);
    }

    public  ArrayList<String> filtredData() {
        ArrayList<String> filteredSatilik = new ArrayList();

        List<WebElement> elements = findElements(FILTERED_ELEMENTS);
        for (WebElement webElement : elements) {
            String name = webElement.getText();
            if (name.contains("TL - ")) {
                String[] arrOfStr = name.split("-", 2);
                for (String price : arrOfStr) {
                    price = price.replaceAll("\\D+", "");
                     filteredSatilik.add(price);
                }
                continue;
            }
             filteredSatilik.add(name);
        }
        System.out.println(filteredSatilik);
        return  filteredSatilik;
    }


}
