package Odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme08 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver() ;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;

        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        WebElement signin =driver.findElement(By.xpath("//*[@type='text']"));
        signin.sendKeys("username", Keys.TAB,"password",Keys.TAB,Keys.TAB,Keys.ENTER);
        Thread.sleep(1500);
        driver.navigate().back();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//h4//span)[4]")).click();
        Thread.sleep(1500);

        driver.findElement(By.id("sp_amount")).sendKeys("4000",Keys.TAB ,"1996-01-12",Keys.TAB,Keys.TAB,Keys.ENTER);
        Thread.sleep(1500);

        driver.close();


    }
}
