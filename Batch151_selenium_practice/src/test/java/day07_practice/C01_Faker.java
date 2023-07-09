package day07_practice;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void test01() {
        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//*[@type='submit'])[3]")).click();

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        // isim kutusunu locate ediniz
        WebElement isimKutusu= driver.findElement(By.xpath("//*[@name='firstname']"));

        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker =new Faker();

        Actions actions =new Actions(driver);
        actions.click(isimKutusu).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Aralik").
                sendKeys(Keys.TAB).
                sendKeys("1997").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                perform();

        driver.findElement(By.xpath("//*[@class='_1lch']")).click();

    }
}
