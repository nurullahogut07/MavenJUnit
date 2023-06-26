package Odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme07 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver() ;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;

        driver.get("https://saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user", Keys.TAB,"secret_sauce",Keys.TAB,Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//*[@class='inventory_item_name'])[1]")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(1500);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("(//a)[5]")).click();

        WebElement varMi = driver.findElement(By.xpath("//*[@class='cart_item_label']"));
       if (varMi.getText().contains("Remove")){
           System.out.println("test passed");
       }else {
           System.out.println("test failed");
       }

        Thread.sleep(1000);
       driver.close();


    }
}
