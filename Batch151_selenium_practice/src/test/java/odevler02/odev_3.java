package odevler02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class odev_3 {
/*
    1.http://zero.webappsecurity.com/ Adresine gidin
2.Sign in butonuna basin
3.Login kutusuna “username” yazin
4.Password kutusuna “password.” yazin
5.Sign in tusuna basin(not: navigate.Back yapınız)
6.Pay Bills sayfasina gidin
7.“Purchase Foreign Currency” tusuna basin
8.“Currency” drop down menusunden Eurozone’u secin
9.“amount” kutusuna bir sayi girin
10.“US Dollars” in secilmedigini test edin
11.“Selected currency” butonunu secin
12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

 */

    static WebDriver driver ;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com");

    }

    @Test
    public void test1() {
        driver.findElement(By.id("signin_button")).click();
        bekle(1);
        driver.findElement(By.id("user_login")).sendKeys("username", Keys.TAB,"password");
        bekle(1);
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();
        bekle(1);
        driver.findElement(By.id("onlineBankingMenu")).click();
        bekle(1);

        driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click();
        bekle(1);
        driver.findElement(By.xpath("(//*[@class='ui-state-default ui-corner-top'])[2]")).click();
        bekle(1);

        WebElement ddm =driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select= new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");

        driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("100");
        bekle(1);

        WebElement dolar=driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
      Assert.assertFalse(dolar.isSelected());

        WebElement other = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        other.click();
        bekle(1);

        driver.findElement(By.id("pc_calculate_costs")).click();
        bekle(1);
        driver.findElement(By.xpath("(//*[@class='pull-right'])[2]")).click();

        bekle(1);
     WebElement yazi =driver.findElement(By.xpath("//div[@id='alert_container']"));
     String yaziOKuma=yazi.getText();
     Assert.assertTrue(yaziOKuma.contains("Foreign currency cash was successfully purchased"));



    }
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
