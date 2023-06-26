package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    @Test
    public void name() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com ");
       String sayfa1= driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String  amazonUrl =driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
       String sayfa2= driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
       String bestTitle= driver.getTitle();
       Assert.assertTrue(bestTitle.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(sayfa1);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement aramaSonuclari =driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonuclari.getText().contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(sayfa2);

        // 8- logonun gorundugunu test edelim
        WebElement  logoGorunum= driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logoGorunum.isDisplayed());



    }
}
