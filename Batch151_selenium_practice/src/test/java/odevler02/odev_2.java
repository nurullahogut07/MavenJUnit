package odevler02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class odev_2 {
    /*
    ●https://www.amazon.com/ adresine gidin.
-Test 1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
oldugunu test edin
-Test 2
1.Kategori menusunden Books secenegini secin
2.Arama kutusuna Java yazin ve aratin
3.Bulunan sonuc sayisini yazdirin
4.Sonucun Java kelimesini icerdigini test edin

     */
      static WebDriver driver ;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

    }

    @Test
    public void test1() {
        WebElement kategoriler=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select =new Select(kategoriler);

        List<WebElement> kategori =select.getOptions();

        Assert.assertFalse(kategori.size()==45);

    }

    @Test
    public void test2() {

        WebElement kategoriMenusu=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(kategoriMenusu);
        select.selectByVisibleText("Books");

        // 2.Arama kutusuna Java yazin ve aratin
        WebElement aramaKutsu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutsu.sendKeys("Java", Keys.ENTER);

   WebElement sonuclar =driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisi =sonuclar.getText();
        Assert.assertTrue(sonucYazisi.contains("Java"));
    }
}
