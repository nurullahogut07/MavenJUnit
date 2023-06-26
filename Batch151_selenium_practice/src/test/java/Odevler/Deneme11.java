package Odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class Deneme11 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        ////https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");

        ////Bir mail adersi giriniz
        ////Login butonuna tiklayini
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("nurimu440@gmail.com", Keys.TAB,"123456",Keys.TAB, Keys.ENTER);

        //// "There was a problem with your login." texti gorunur ise
        ////"kayit yapilamadi" yazdiriniz
        ////eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        ////sayfayı kapatiniz
       WebElement problem = driver.findElement(By.xpath("//*[@class='alert alert-danger']"));

       if (problem.isEnabled()){
           System.out.println("Kayit yapilamadi");
       }else {
           System.out.println("kayit yapildi");
       }
       Thread.sleep(1500);
    driver.close();



    }
}
