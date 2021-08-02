package com.hepsiemlak.steps;


import com.hepsiemlak.base.Driver;
import com.hepsiemlak.page.MainPage;
import com.hepsiemlak.page.SatilikPage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.hepsiemlak.constants.Constants.*;
import static org.junit.Assert.assertEquals;

public class SatilikStepImp  {
     ArrayList<String> satilik = new ArrayList<>();

    public static MainPage mainPage;
    public static SatilikPage satilikPage;
    private static final Logger logger = Logger.getLogger(SatilikStepImp.class.getName());


    public SatilikStepImp() {

        mainPage=new MainPage(Driver.driver);
        satilikPage=new SatilikPage(Driver.driver);
    }

    @Step({"Anasayafa'ya gidilir",
            "Go to Main Page"})
    public void goToMainPage() {
        mainPage.getHomePage();
        logger.info("hepsiemlak sitesi açıldı");

    }


    @Step({"Ana sayfanın açıldığı kontrol edilir.", "Check the main page is opened"})
    public void checkMainPageIsOpened() {
        try {
            assertEquals(HEPSIEMLAK_PAGE_TITLE, mainPage.getTitle());
            logger.info("Ana sayfanın açıldığı kontrol edilidi");

        } catch (Exception e) {
            logger.warn("Yanlış Siteye Gidildi ");
        }
    }


    @Step({"Satılık sayfasına gidilir.", "Click on “Satılık”"})
    public void clickOnSatilik() {
        mainPage.clickOnSatilik();
        logger.info("Menüden satılığa tıklanır");

    }

    @Step( "Check the satılık page is opened.")
    public void checkSatilikPageIsOpened() {
        try {
            satilikPage.sleep(500L);
            assertEquals(SATILIK_PAGE_TITLE, satilikPage.getSatilikTitle());
            logger.info("Satılık sayfasının  açıldığı kontrol edilidi");

        } catch (Exception e) {
            logger.warn("Yanlış Siteye gidildi");
        }
    }


    @Step("select City as  <name>")
    public void selectCity (String name) {
        satilikPage.choiceCity(name);
        satilik.add(name);
        logger.info("İl seçildi ");

    }

    @Step("select Country as <table>")
    public void selectCountry(Table table) {
        satilikPage.clickOnCountry();
        String country;
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        ArrayList<String>  isimler =new ArrayList<>()  ;

        for (TableRow row : rows) {
            country = row.getCell(columnNames.get(0));
            isimler.add(country);
            satilikPage.choiceCountry(country);

        }

        Collections.sort(isimler);
        satilik.addAll(isimler);

        satilikPage.clickOnCountry();
        logger.info("Ilçeler seçildi ");


    }

    @Step("select category as  <arg0>")
    public void selcetCategory(String arg0) {

        satilikPage.choiceCategory();
        satilik.add(arg0);
        logger.info("Kategori seçildi ");

    }

    @Step("Enter minprice  as <value>")
    public void enterMinPrice(String value) {
        satilikPage.enterMinPrice(value);
        satilik.add(value);
        logger.info("En Az fiyat girildi ");

    }

    @Step("Enter maxprice  as <value>")
    public void enterMaxPrice(String value) {
        satilikPage.enterMaxPrice(value);
        satilik.add(value);
        logger.info("En Çok fiyat girildi ");

    }


    @Step("select building age as <table>")
    public void selectBuildingAge(Table table) {
        satilikPage.clickBuildingAge();
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        String bulildingAge;
        for (TableRow row : rows) {
            bulildingAge = row.getCell(columnNames.get(0));
            satilikPage.choiceBuildingAge(bulildingAge);
            satilik.add(bulildingAge);
        }
        logger.info("Bina yaşları seçildi ");


    }
    @Step("Click on “Ara” Button")
    public void clickOnSeachButton() {
        satilikPage.clickSearchBtn();
        satilikPage.sleep(2000L);
        logger.info("Ara button'una tıklandı");

    }

    @Step("Check for Tags in the filter area:")
    public void testIfTagsInFilterAreaAsEntered() {
        assertEquals(satilik, satilikPage.filtredData());
        logger.info("filtre alanındaki değerler girilen değerler ile aynı olduğu kontrol edildi");


    }
}
