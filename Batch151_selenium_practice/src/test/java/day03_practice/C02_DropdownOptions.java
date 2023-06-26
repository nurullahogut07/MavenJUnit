package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropdownOptions {
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

        // dropdown'dan "Baby" secenegini secin
        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select =new Select(dropdownMenu) ;
        select.selectByIndex(3);

        // sectiginiz option'i yazdirin
        System.out.println("Sectigim Option = " + select.getFirstSelectedOption().getText());

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
       List<WebElement> opsiyonlarList = select.getOptions();
        Assert.assertEquals(28,opsiyonlarList.size());

        // dropdown'daki optionların tamamını yazdırın
        int sayac =1 ;
        for (WebElement each :opsiyonlarList ) {
            System.out.println(sayac +".option " + each.getText());
            sayac++;
        }

      //  opsiyonlarList.forEach(t-> System.out.println(t.getText())); ==>>>  Boylede yazdirabiliriz lambda ile
    }
}
