package odevler02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev_4 {
    static WebDriver driver ;
    /*

// https://www.youtube.com adresine gidin
//3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
// Sayfa başlığının “YouTube” oldugunu test edin
// YouTube resminin görüntülendiğini (isDisplayed()) test edin
// Search Box 'in erisilebilir oldugunu test edin (isEnabled())
// ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    WebDriver driver;
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");

    }

    @Test
    public void test1() {
       driver.findElement(By.xpath("(//*[@class='yt-spec-touch-feedback-shape__fill'])[10]")).click();
    // Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertTrue(driver.getTitle().contains("YouTube"));
    }

    @Test
    public void test2() {
        // YouTube resminin görüntülendiğini (isDisplayed()) test edin
     WebElement resim= driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
     Assert.assertTrue(resim.isDisplayed());
    }

    @Test
    public void test3() {
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     WebElement box = driver.findElement(By.xpath("(//*[@id='search'])[3]"));
     Assert.assertTrue(box.isEnabled());
     String sayfaBasligi =driver.getTitle();
     Assert.assertFalse(sayfaBasligi.contains("youtube"));
    }
}
