package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_GetAttribute extends TestBase {

    @Test
    public void test01() {
        //  https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //  Tarih kısmını JS ile locate ediniz.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript(" return document.getElementById('checkin_date')"); // casting yaptik
       // WebElement date = (WebElement) js.executeScript(" return document.querySelector(\"input[id='checkin_date']\")"); diger yol
        /*
           Java Script kodlariyla webelementleri bizim bildigimiz findElement() methoduyla locate edemeyebiliriz.
           js executer kullanarak ister HTML ister Java script yazilmis olsun bir webelementin locate'ini js executer ile
           alabiliriz. Yukaridaki ornekte sayfadaki tarih webelementini js executer ile locate ettik
       */
        date.clear();  // webelemetin icini bosalttik
        date.sendKeys("5/21/2023"); // webelemete yeni tarih atadik

        // Date webelemetinin  Attribute degerlerini yazdiralim
       String idAttributeDegeri= js.executeScript(" return document.getElementById('checkin_date').id").toString();
        String typeAttributeDegeri= js.executeScript(" return document.getElementById('checkin_date').type").toString();
        String nameAttributeDegeri=js.executeScript(" return document.getElementById('checkin_date').name").toString();
        String valueAttributeDegeri=js.executeScript(" return document.getElementById('checkin_date').value").toString();

        System.out.println("idAttributeDegeri = " + idAttributeDegeri);
        System.out.println("typeAttributeDegeri = " + typeAttributeDegeri);
        System.out.println("nameAttributeDegeri = " + nameAttributeDegeri);
        System.out.println("valueAttributeDegeri = " + valueAttributeDegeri);

        /*
        Java Script kodlarıyla yazılmış webelementleri bizim bildiğimiz findElement() methoduyla locate edemeyebiliriz.
        js executor kullanarak ister html ister java script ile yazılmış olsun bir webelementin locatini js executor
        ile alabiliriz. Yukarıdaki örnekte sayfadaki tarih webelementini js executor ile locate ettik.
        */

    }

    @Test
    public void test02() {
        //https://www.priceline.com/ adresine gidiniz
        driver.get("https://www.priceline.com");
        bekle(2);
     WebElement cookie =driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']"));
        cookie.click();
            //Submit butonunun rengini Kirmizi yazınız
        WebElement button =driver.findElement(By.xpath("//*[text()='Find Your Hotel']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.color='red';",button);
    }
}
