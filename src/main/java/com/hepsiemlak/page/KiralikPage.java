package com.hepsiemlak.page;

import com.hepsiemlak.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.hepsiemlak.constants.Constants.*;

public class KiralikPage extends BasePage {


    ArrayList<String> numbers = new ArrayList<>();

    public KiralikPage(WebDriver driver) {
        super(driver);
    }

    public String getKiralikTitle(){
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

    public void choiceCategory(String temp) {
        clickElement(HOUSE_CAT_RADIO_BUTTON);

    }


    public void scrolltoRoomType() {
        scrollToElement(ROOM_TYPE_lABEL);
    }

    public void clickOnRoomType() {

        clickElement(ROOM_TYPE);
    }

    public void choiceRoomType(String temp) {

        scrollAndClick(By.xpath("//li[./label/span[contains(text(),'" + temp + "')]]"));
    }

    public void clickSearchBtn() {
        clickElement(SEARCH_BTN);
    }

    public void clickOnThirdItem() {
        clickElement(THIRD_ITEM);
    }

    public void clickToShowPhone() {
        clickElement(TEL_BTN);
    }
    public void phoneNumberRealAndValid() {
        List<WebElement> elements = findElements(PHONE_NUMBERS);
        for (WebElement element:elements){
            numbers.add(element.getText());
        }
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public void clickWithInSite() {
        scrollAndClick(WITH_IN_SITE);
    }
}
