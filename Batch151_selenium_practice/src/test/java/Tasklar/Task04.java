package Tasklar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task04 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Thread.sleep(1000);
        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        driver.switchTo().alert().getText() ;
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
    driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
    driver.findElement(By.id("CancelTab")).click();
        Thread.sleep(1000);
        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
    driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
    driver.findElement(By.id("Textbox")).click();
        Thread.sleep(1000);
        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Nuri");
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        //-Çıkan mesajı konsola yazdırınız
        WebElement mesaj =driver.findElement(By.id("demo1"));
        System.out.println(mesaj.getText());
        Thread.sleep(1000);
        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertTrue(mesaj.getText().contains("Hello Nuri How are you today"));

    }
}
