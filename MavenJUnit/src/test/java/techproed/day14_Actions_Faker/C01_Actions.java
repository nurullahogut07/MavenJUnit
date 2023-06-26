package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın altına doğru gidelim
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        bekle(2);

        //sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın en altına scroll yapalim
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.END);   // her action dan sonra perform yapmamamiz gerekiyorsa en son action a perform ekleriz.
        bekle(2);
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar . release() -->>> methodu mouse'i serbest birakir .

        //sayfanın en üstüne scroll yapalim
        actions.sendKeys(Keys.HOME).build().perform();  //build islemi cok hizli gerceklesir
    }

    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın altına doğru gidelim   (kordinanta vererek sistedigimiz yere goturur bizi )
        Actions actions =new Actions(driver);
       actions.scrollByAmount(0,1500).perform();
        bekle(2);

        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0,-1500).perform();
        bekle(2);

    }
}
