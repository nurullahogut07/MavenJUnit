package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_ExtentReport extends TestBase {
    @Test
    public void test01() {
        extentReport("Chrome","Amazon Testi");
        extentTest=extentReports.createTest("ExtentReport","Test Raporu");

        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");

        // Sayfanin resmini aliniz
        tumSayfaResmi();
        extentTest.info("Sayfanin resmi alindi");

        //arama kutusuna iphone aratiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");
        extentTest.pass("Sayfa kapatildi");




    }
}
