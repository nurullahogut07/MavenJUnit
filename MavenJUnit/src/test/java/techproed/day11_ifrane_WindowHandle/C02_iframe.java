package techproed.day11_ifrane_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_iframe extends TestBase {

    @Test
    public void iframe() {
    //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

    //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String editorYazisi =driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(editorYazisi.contains("Editor"));

    //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");  // frame icine gectik ve sildirdik
        WebElement textBox =driver.findElement(By.xpath("//p"));
        textBox.clear();
        bekle(1);
    //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        driver.findElement(By.xpath("//p")).sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(1);

    //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent() ; //frame icindeyiz suan ama elemental selenium yazisi ana sayfa da , o yuzden yazdik
   WebElement elementalSelenium = driver.findElement(By.xpath("(//a)[3]"));
   Assert.assertTrue(elementalSelenium.isDisplayed());

    }
}
