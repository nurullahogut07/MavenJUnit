package Odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Deneme06 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver() ;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;

        driver.get("https://google.com");

        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

       if (driver.getTitle().contains("Google")){
           System.out.println("test passed");
       }else {
           System.out.println("test failed");
       }

       WebElement add =driver.findElement(By.id("APjFqb"));
       add.sendKeys("Nutella");

       driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();

      WebElement sonuc=driver.findElement(By.xpath("//*[@id='result-stats']"));
      String [] sayi =sonuc.getText().split(" ") ;
        System.out.println("Bulunan sonuc sayis =" + sayi[1]);


        Thread.sleep(1500);
        driver.close();
    }
}
