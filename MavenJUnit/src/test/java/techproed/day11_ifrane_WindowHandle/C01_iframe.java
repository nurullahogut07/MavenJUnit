package techproed.day11_ifrane_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_iframe extends TestBase {
    /*
       Bir HTML dökümanının içine yerleştirilmiş başka bir HTML dökümanına inline frame yani IFRAME denir.
    Bir sayfada iframe varsa iframe içindeki webelementi handle edebilmek için switchTo() methoduyla iframe'e
    geçiş yapmamız gerekir. Eğer geçiş yapmazsak nosuchelementexception alırız.
        Alert'ten farkı alert çıktığında hiçbir webelementi locate edemeyiz. Iframe olsada locate ederiz fakat
    handle edemeyiz.
     */

    @Test
    public void test1() {
    //https://testcenter.techproeducation.com/index.php?page=iframe
    driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

    //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
    String metin =driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);  // gecis yapmazsak nosuchelementexception hatasi aliriz
    String applicationsLists =driver.findElement(By.xpath("//h1")).getText();
        System.out.println(applicationsLists);
    Assert.assertEquals("Applications lists",applicationsLists);

        // ana sayfada basliginda ki 'iframe' yazisini varligini test edilip
        driver.switchTo().defaultContent(); // driver i ana sayfaya aldik , yukarida frame icine almistik
      //  driver.navigate().refresh();  bu sekilde de driveri ana sayfaya alabiliriz
      //  driver.get(driver.getCurrentUrl());  --> bu sekilde de ana sayfaya alabiliriz

        WebElement iframeYazisi =driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());

        /*
        Eger iki tane iframe olsaydi ve 2. iframe gecmek isteseydik indexi 1 olani alamamiz gerekecekti
        <body>
               <iframe id='outeriframe' src ='https://www.w3schools.com'>  driver.switchto().frame("outeriframe")
                   <iframe id ='inneriframe ' src ='https://www.google.com' ></iframe>
            </iframe>
        </body>
         İstersek WebElement frameWe = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.
         */

    }
}
