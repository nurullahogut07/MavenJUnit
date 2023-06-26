package Odevler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme09 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://facebook.com");
        Thread.sleep(1500);
        System.out.println( driver.getTitle().contains("Facebook")) ;
        System.out.println( driver.getCurrentUrl().contains("facebook"));
        Thread.sleep(1500);
        driver.get("https://walmart.com");
        System.out.println(driver.getTitle().contains("Walmart.com"));
        Thread.sleep(1500);
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(1500);
        driver.close();

    }
}