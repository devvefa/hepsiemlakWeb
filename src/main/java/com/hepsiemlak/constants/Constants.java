package com.hepsiemlak.constants;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class Constants {
    //----------Home Page---------
    public static final By ALISVERISE_BASLA_BUTTON = By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore");


    public static final String URL_HEPSIEMLAK = "https://www.hurriyetemlak.com";
    public static final String HEPSIEMLAK_PAGE_TITLE = "Hepsiemlak | Satılık, Kiralık Ev & Emlak İlanları";
    public static final By COOKIE_POLICY_BTN = By.xpath("//section[@class='cookie-policy']/span");

    public static final By SATILIK_BTN = By.xpath("//a[span[text()='Satılık']]");

    //----------Satılık Page---------

    public static final String SATILIK_PAGE_TITLE = "Satılık Konut İlanları ve Fiyatları | hepsiemlak";
    public static final By LOCATION_SELECT = By.xpath("//section[contains(@class,'locationCitySec')]");
    public static final By COUNTRY_SELECT = By.xpath("//section[contains(@class,'locationCountySec')]");
    public static final By BUILDINIG_AGE_SELECT = By.xpath("//section[contains(@class,'buildingAgeSec')]");

    public static final By CATEGORY_RADIO_BUTTON = By.xpath("//label[contains(text(),'İşyeri')]");


    public static final By MIN_PRICE_INPUT = By.xpath("//input[contains(@class,'priceMin')]");
    public static final By MAX_PRICE_INPUT = By.xpath("//input[contains(@class,'priceMax')]");
    public static final By SEARCH_BTN = By.xpath("//a[@class='btn btn-red btn-large']");

    public static final By FILTERED_ELEMENTS = By.xpath("//span[@data-v-6292e3e6 and @data-v-00f705b2]");


    //----------Kiralık Page---------
    public static final String KIRALIK_PAGE_TITLE = "Kiralık Konut Fiyatları ve İlanları | hepsiemlak";
    public static final By HOUSE_CAT_RADIO_BUTTON = By.xpath("//label[contains(text(),'Konut')]");

    public static final By KIRALIK_BTN = By.xpath("//a[span[text()='Kiralık']]");
    public static final By ROOM_TYPE_lABEL = By.xpath("//section[@class='roomTypeSec']/span");
    public static final By WITH_IN_SITE = By.xpath("//section[@class='filter-switch withinSiteSec']/label/input");
    public static final By ROOM_TYPE = By.xpath("//section[contains(@class,'roomTypeSec')]");
    public static final By THIRD_ITEM = By.xpath("//div[@class='listing-item'][2]");


    //----------Detail Page---------


    public static final By TEL_BTN = By.xpath("//div[@class='owner-phone-numbers']/button");
    public static final By PHONE_NUMBERS = By.xpath("//div[@class='owner-phone-numbers']/div/ul/li");












}

