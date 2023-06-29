package Tasklar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task06 extends TestBase {
    @Test
    public void name() throws InterruptedException {
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions =new Actions(driver).clickAndHold(yaziTahtasi);


        //- Çizimden sonra clear butonuna basınız
        //- Sayfayi kapatiniz
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-15,8);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(10,10);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-6,-7);
        }

        actions.release().build().perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();



    }
}
