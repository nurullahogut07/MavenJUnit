package techproed.day21_Excell_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {
     /*
        Bir web sayfasinda bazi webelementler olusturulurken JAVASCRIPT kodlariyla olusturulmus olabilir.
    Bu webelementleri handle edebilmek icin JavaScriptExecutor arayuzunu kullanmamiz gerekir.
    Bir webelement JavaScript kodlari ile yazilmamis olsa da javaScriptExecutor ile o webelementi handle edebiliriz
    Normal bildigimiz methodlardan daha yavas calisacagi icin bildigimiz methodlar isimizi goruyorsa onlari kullaniriz
    <script> tagi ile olusturdugumuz webelementleri de js executor ile handle edebiliriz
     */

    @Test
    public void test01() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test02() {
        // amazon sayfasina gidelim
        driver.get("https://amazon.com");
        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki=  driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine  tiklayiniz
       sellLinki.click();  // org.openqa.selenium.ElementClickInterceptedException: hatasi aliriz
        /*
        JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
        Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
        hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
 */

        //Başlığın sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        bekle(2);

        //sell linkinin resmini alalım
        driver.findElement(By.xpath("(//*[@class='a-button-inner'])[1]")).click();//-->uyarı kapatıldı

        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        bekle(2);
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        click(sellLinki);    //click() methoduyla once normal click yapmayi denedi olmadi ve Js executor ile click yapti
        /*
        JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
        Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
        hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
        */

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();

    }
}
