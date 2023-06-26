package odevler02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class odev_1 {
    /*
    ●https://the-internet.herokuapp.com/dropdown adresine gidin.
1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
4.Tüm dropdown değerleri(value) yazdırın
5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
False yazdırın.
     */

  static   WebDriver driver ;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @Test
    public void test1() {
        WebElement option = driver.findElement(By.xpath("(//*[@id='dropdown'])"));
        Select select =new Select(option);
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(1);
        selectValue(option,"2");
        bekle(1);
        selectVisibleText(option,"Option 1");
        bekle(1);
        select.getOptions().forEach(t-> System.out.println(t.getText()));


    }
    public void selectIndex (WebElement ddm ,int index){
        Select select =new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue (WebElement ddm ,String value){
        Select select =new Select(ddm);
        select.selectByValue(value);
    }
    public void selectVisibleText (WebElement ddm ,String text){
        Select select =new Select(ddm);
        select.selectByVisibleText(text);
    }
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
