package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClassWork {

    /*
    verilen web sayfasina gdin
    https://the-internet.herokuapp.com.checkboxes
    checkbox1 ve checkbox2 elemenlerini locate edin
    chechbox1 secili degilse onay kutusunu tiklayin
    chechbox2 secili degilse onay kutusunu tiklayin

     */
    WebDriver driver ;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void test01() throws InterruptedException {
        // Checkbox1 ve checkbox2 elementlerini locate edin.
     WebElement checkbox1= driver.findElement(By.xpath("(//input)[1]"));
       WebElement checkbox2 = driver.findElement(By.xpath("(//input)[2]"));
        // Checkbox1 seçili değilse onay kutusunu tıklayın
       if (!checkbox1.isSelected()){  // seçili değilse
           checkbox1.click();
       }
       Thread.sleep(1500);
      if (!checkbox2.isSelected()){   // seçili değilse
          checkbox2.click();
      }

    }
}
