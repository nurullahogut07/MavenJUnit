package odevler02;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class deneme1 {
    static WebDriver driver;
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //Before methodunda http://www.google.com adresine gidin
    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");
        Thread.sleep(1000);
    }
    //Üç farklı test methodu ile;
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//div//textarea")).sendKeys("Kill Bill", Keys.ENTER);

        String result[] = driver.findElement(By.cssSelector("div#result-stats")).getText().split(" ");
        System.out.println("Kill Bill sonuc sayisi = "+result[1]);
    }
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("//div//textarea")).sendKeys("The God Father", Keys.ENTER);
       driver.navigate().refresh();
        String result[] = driver.findElement(By.cssSelector("div#result-stats")).getText().split(" ");
        System.out.println("The God Father sonuc sayisi = " + result[1]);
    }
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.xpath("//div//textarea")).sendKeys("Lord of the Rings", Keys.ENTER);
        driver.navigate().refresh();
        String result[] = driver.findElement(By.cssSelector("div#result-stats")).getText().split(" ");
        System.out.println("Lord of the Rings sonuc sayisi = "+result[1]);
    }
    //After method'u ile başlıkları yazdırınız
    @After
    public void tearDown() throws Exception {
        System.out.println(driver.getTitle());
        driver.navigate().back();
    }
    //AfterClass ile browser'ı kapatınız
    @AfterClass
    public static void afterClass() throws Exception {
    driver.close();
    }
}