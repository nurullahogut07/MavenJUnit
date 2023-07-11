package techproed.tests.day24_Priority_DependsOnMethods_Asserts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C06_SoftAssert {
     /*
        SoftAssert kullaniminda Junitte daha once kullandigimiz methodlarin aynisini kullaniriz.
    Daha onceden kullandigimiz assertion nerde hata alirsa orda testlerin calismasini durdurur.
    SoftAssert'te ne kadar assertion kullansak da nerde assertAll() methodu kullanirsak testlerimiz de
    kullandigimiz assertionlar orda sonlanir ve hata varsa bunu bize konsolda belirtir
     */
  WebDriver driver ;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert =new SoftAssert() ; //-->SoftAssert kullanabilmek için SoftAssert class'ından obje oluşturmalıyız
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr");

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi =driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));
        softAssert.assertAll();  // buradan sonra islem yaparsak calismaz gerisi

        System.out.println("BURASI CALISMAZ");

        /*                    BU HATALARI ALIRIZ
        java.lang.AssertionError: The following asserts failed:
            expected [https://www.amazon.com.tr] but found [https://www.amazon.com/],
            expected [true] but found [false],
            expected [true] but found [false]
         */
    }

    @Test
    public void test02() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert =new SoftAssert() ; //-->SoftAssert kullanabilmek için SoftAssert class'ından obje oluşturmalıyız
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr");

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi =driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));
        System.out.println("BURASI CALISTI");
        softAssert.assertAll();  // buradan sonra islem yaparsak calismaz gerisi
        System.out.println("BURASI CALISMAZ");
    }

    @Test
    public void test03() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert =new SoftAssert() ; //-->SoftAssert kullanabilmek için SoftAssert class'ından obje oluşturmalıyız
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr");

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));
        softAssert.assertAll();  // buradan sonra islem yaparsak calismaz gerisi

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi =driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));
        System.out.println("BURASI CALISTI");
        softAssert.assertAll();  // buradan sonra islem yaparsak calismaz gerisi
        System.out.println("BURASI CALISMAZ");

    }

    @Test
    public void test04() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert =new SoftAssert() ; //-->SoftAssert kullanabilmek için SoftAssert class'ından obje oluşturmalıyız
        softAssert.assertNotEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr");

        //Başlığın best içerdiğini test edelim
        softAssert.assertFalse(driver.getTitle().contains("best"));

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi =driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertFalse(sonucYazisi.getText().contains("samsung"));

        softAssert.assertAll();  // testimiz passed oldugu icin assagisida calisir
        System.out.println("BURASI CALISTI");

    }
}
