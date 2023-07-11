package techproed.tests.day24_Priority_DependsOnMethods_Asserts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Ignore {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
        /*
        Birden fazla test methodu calistirmak istedigimizde o anlik gereksiz gordugumuz test methodunu
        atlamak (ignore) isteyebiliriz.Bunun icin @Test notasyonu ustune ya da yanina @Ignore notasyonu
        eklememiz yeterlidir..
        @Ignore notasyonu ile atladığımız method konsolda gözükmez raporlamalarda gözükür
        Eger bir method tamamen iptal etmek isterseniz @Test notasyonundan sonra parametre olarak (enable=false)
        kullanabiliriz
         */
    @Ignore
    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");
    }
    /*
    (enabled = false) yaptigimiz da run isaretide gider tamamen methodu iptal eder
    */
    @Test(enabled = false)
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }
    @Test
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
