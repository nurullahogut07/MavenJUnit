package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClassAfterClass {
    /*
    Before class ve After class test methodlarimizdan once bir sefer calismasini istedigimiz kodlari bu methodlara koyariz.
    Mesela testlerimiz baslmadan once database baglantisi yapmak icin kullanilabilir yada hangi driver'i kullanacaksak yine
    bunu Beforeclasss a koyabiliriz. Ayni sekilde testlerimizden sonra databes'i sonlandirmak icin ya da raporlarimizi
    sonlandirmak icinde kullanabiliriz. 
     */
    WebDriver driver ;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
    }



    @Before
    public void setUp() throws Exception {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");

    }
    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='eicon-close']"));
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);
    }

    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='eicon-close']"));
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("developer", Keys.ENTER);
    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
