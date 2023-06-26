package day02_seleniumPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class C02 {
    WebDriver driver ;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

// https://www.techproeducation.com/ sayfasina gidin
        driver.get("https://www.techproeducation.com/");

    // Title ve Url'ini alın ve yazdırın
    String techproeducationTitle = driver.getTitle();
        System.out.println("TECHPROEDUCATİON TİTLE: " + techproeducationTitle);

    String techproeducationUrl = driver.getCurrentUrl();
        System.out.println("TECHPROEDUCATİON URL: " + techproeducationUrl);

    // Title'in "Techpro" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproeducationTitle.contains("Techpro"));

    // Url'in "techproeducation" kelimesini içerip içermedigini test edin
      Assert.assertTrue(techproeducationUrl.contains("techproeducation"));

      Thread.sleep(1000);
    // https://www.amazon.com/ sayfasına gidin
        driver.get("https://amazon.com");

    // Title'ini alın ve yazdırın
        String amazonunTitle =driver.getTitle();
        System.out.println("Amazonun Title'i = " +amazonunTitle);

        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(amazonunTitle.contains("more"));

    // techproeducation.com'a geri dönün
        driver.get("https://www.techproeducation.com");
        Thread.sleep(1000);

    // sayfayı yenileyin
        driver.navigate().refresh();
        Thread.sleep(1000);

    // amazon.com'a tekrar gelin
      driver.get("https://amazon.com");



}




}
