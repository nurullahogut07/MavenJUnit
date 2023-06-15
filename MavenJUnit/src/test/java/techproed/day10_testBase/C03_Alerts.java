package techproed.day10_testBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_Alerts extends TestBase {
    @Test
    public void test1() {
        //https://demoqa.com/alerts adresine gidelim
    driver.get("https://demoqa.com/alerts ");

        //Click Button to see alert karşısındaki butona tıklayalım
    driver.findElement(By.id("alertButton")).click();
    bekle(2);

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        driver.switchTo().alert().getText().contains("You clicked a button");
        bekle(2);

        //Ve alert'ü kapatalım
       acceptAlert(); // testbase de olusturduk
    }

    @Test
    public void test2() {
        driver.get("https://demoqa.com/alerts ");

        //on button click,confirm box will appear karsisindaki butona basin
        driver.findElement(By.id("confirmButton")).click();
        bekle(2);

        //cikan alerti iptal edin
    dismissAlert();

        //sonuc yazisinin you selected cancel yazdigini dogrulayin
    String sonucYazisi=driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);

    }

    @Test
    public void test3() {
        driver.get("https://demoqa.com/alerts ");

        // On button click, prompt box will appear karsisinda ki butona tiklayalim
    driver.findElement(By.xpath("(//button)[5]")).click();

        // cikan alert ismini girelim
      sendKeysAlert("Nuri");
      bekle(2);
       acceptAlert();
        // ismi girdiginizi dogrulayin
      String sonucYazisi= driver.findElement(By.id("promptResult")).getText();
      Assert.assertTrue(sonucYazisi.contains("Nuri"));

    }
}


