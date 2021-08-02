package com.hepsiemlak.steps;


import com.hepsiemlak.base.Driver;
import com.hepsiemlak.page.KiralikPage;
import com.hepsiemlak.page.MainPage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.hepsiemlak.constants.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KiralikStepImp  {

    public static MainPage mainPage;
    public static KiralikPage kiralikPage;
    private static final Logger logger = Logger.getLogger(KiralikStepImp.class.getName());


    public KiralikStepImp() {

        mainPage=new MainPage(Driver.driver);
        kiralikPage=new KiralikPage(Driver.driver);

    }


    @Step({"Anasayafa'ya gidilir",
            "Go to Home Page"})
    public void goToMainPage() {
        mainPage.getHomePage();
        mainPage.closeCookie();
        logger.info("hepsiemlak sitesi açıldı");

    }


    @Step({"Ana sayfanın açıldığı kontrol edilir.", "Check the home page is opened"})
    public void checkMainPageIsOpened() {
        try {
            assertEquals(HEPSIEMLAK_PAGE_TITLE, mainPage.getTitle());
            logger.info("Ana sayfanın açıldığı kontrol edilidi");

        } catch (Exception e) {
            logger.warn("Yanlış Siteye Gidildi ");
        }
    }


    @Step({"Kiralık sayfasına gidilir.", "Click on “Kiralık”"})
    public void clickOnKiralik() {
        mainPage.clickOnKiralik();
        logger.info("Kiralık sayfasına gidilidi");
        logger.info("Menüden Kiralığa tıklanır");


    }

    @Step({"Kiralık Sayfasının açıldığı kontrol edilir.", "Check the Kiralık page is opened."})
    public void checkKiralikPageIsOpened() {
        try {
            assertEquals(KIRALIK_PAGE_TITLE, kiralikPage.getKiralikTitle());
            logger.info("Ana sayfanın açıldığı kontrol edilidi");

        } catch (Exception e) {
            logger.warn("Yanlış Siteye Giris Yapildi");
        }
    }

    @Step("Choice City as <name>")
    public void choiceCity(String name) {
        kiralikPage.choiceCity(name);
        logger.info("İl seçildi ");

    }

    @Step("select Countries as <table>")
    public void selectCountries(Table table) {
        kiralikPage.clickOnCountry();
        String country;
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {
            country = row.getCell(columnNames.get(0));

            kiralikPage.choiceCountry(country);

        }


        kiralikPage.clickOnCountry();
        logger.info("Ilçeler seçildi ");


    }

    @Step("select category as <konut>")
    public void selectCategory(String konut) {
        kiralikPage.choiceCategory(konut);
        kiralikPage.sleep(700L);
        logger.info("Kategori seçildi ");

    }

    @Step("select room type as <room_type>")
    public void selectRoomType(Table room_type) {
        kiralikPage.scrolltoRoomType();
        kiralikPage.clickOnRoomType();
        String room;
        List<TableRow> rows = room_type.getTableRows();
        List<String> columnNames = room_type.getColumnNames();
        for (TableRow row : rows) {
            room = row.getCell(columnNames.get(0));

            kiralikPage.choiceRoomType(room);

        }

        kiralikPage.clickOnRoomType();
        logger.info("Oda Sayısı seçildi ");


    }

    @Step("Select with in Site")
    public void clickOnSwitchButtonWithInSite() {
        kiralikPage.clickWithInSite();
        logger.info("Site içinde Toggle button akif edildi ");


    }

    @Step("Click on Ara Button")
    public void clickOnSeachButton() {
        kiralikPage.clickSearchBtn();
        kiralikPage.sleep(1000L);
        logger.info("ara buttonuna tıklandı");

    }


    @Step("select 3rd item from list")
    public void clickOnThirdItemFromList() {

        kiralikPage.clickOnThirdItem();
        logger.info("Listeden 3.ilan seçildi");


    }

    @Step("Show telefon number")
    public void clickToShowPhone() {
        kiralikPage.clickToShowPhone();
        logger.info("telefon numarsını göster buttonuna tıklandı");


    }


    @Step("validate phone Number is real Number")
    public void validPhoneNumberIsReal() {
        kiralikPage.phoneNumberRealAndValid();

        for(String number :kiralikPage.getNumbers()){
            Pattern pattern = Pattern.compile("(0)[1-9][0-9][0-9][\\s]([0-9]){3}[\\s]([0-9]){2}[\\s]([0-9]){2}");
            Matcher matcher = pattern.matcher(number);
            assertTrue (matcher.matches());
        }
        logger.info("ilan sahibinin telefon numaraları gerçek olup olmadığı kontrol edildi  ");

    }
}
