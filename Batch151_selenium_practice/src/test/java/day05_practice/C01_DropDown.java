package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDown extends TestBase {
    @Test
    public void test1() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com");

        // dropdown'dan "Books" secenegini secin
    WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        // DropDown 3 adımda handle edilir

        // 1 - dropdown locate edilmelidir
        WebElement ddmenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- select objesi olusturulur
        Select select = new Select(ddmenu);

        // 3- optionlardan bir tanesi secilir
        //select.selectByVisibleText("Books");
        //select.selectByIndex(5);
        select.selectByValue("search-alias=stripbooks-intl-ship");

        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
WebElement aramaSonuclari =driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonuclari.getText().contains("Java"));

    }
}
