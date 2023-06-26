package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_iframe  extends TestBase {
    @Test
    public void name() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz  ( actions objesi olusturmamiz gerekiyor .perform ile bittigini belirtiriz )
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();


        // Videoyu izlemek icin Play tusuna basiniz

        /*
        Play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı
        bunun üzerine HTML kodlarını inceleyince
        play'in aslında bir iframe icerisinde oldugunu gördük
        bu durumda once iframe'i locate edip
        switchTo() ile iframe'e gecmeliyiz
         */

        WebElement iframe =driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

     WebElement play= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
     play.click();

        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());


        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
    driver.switchTo().defaultContent();   //parentFrame();  ile de distaki web sayfasina gecebiliriz
   WebElement yaziGorunum= driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));
    Assert.assertTrue(yaziGorunum.isDisplayed());




    }
}
