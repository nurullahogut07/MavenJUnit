package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_practice {
    WebDriver driver ;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com");

        // dropdown'dan "Books" secenegini secin
        // 1) Dropdown locate edilir
        WebElement dropdown = driver.findElement(By.xpath("(//*[@id='searchDropdownBox'])"));

        // 2) Select objesi olusturulur
        Select select =new Select(dropdown) ;

        // 3) Optionlardan bir tanesi secilir
      //  select.selectByVisibleText("Books");
       // select.selectByIndex(5);
        select.selectByValue("search-alias=stripbooks-intl-ship");
      //  dropdown.sendKeys("Books"); ==>> BU yontem bazi sitelerde calismaz

        // arama cubuguna "Java" aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
       WebElement varMi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
    String sonuclar =varMi.getText();

     Assert.assertTrue(sonuclar.contains("Java"));

   //  Assert.assertTrue(varMi.getText().contains("Java"));  ---> BU sekilde de kontrol edebiliriz
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
