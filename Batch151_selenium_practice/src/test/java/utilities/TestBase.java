package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public abstract class TestBase {
    // bu class'a extends ettigimiz test classlarından ulasabiliriz
    //burasi bizim depomuz. istedigimiz methodu depolayabiliriz. cünkü bu methodu classlarimiza extends edecegiz
    //abbstract yaptigimizda bu testbase classinda obje olusturulmasinin önüne gecmis olduk.
    //abstract yapmak sorunda degiliz anak biz inisiyatifle yaptik.

   protected WebDriver driver;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }








}
