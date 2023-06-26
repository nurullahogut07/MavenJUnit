package Odevler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme10 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());

        System.out.println(driver.getTitle().contains("Amazon"));

        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getTitle().contains("amazon"));

        // sayfanin handel degerini yazdirin

        //html kodlari icinde  Gateway  kelimesi var mi test edin

        //sayfayi kapatin







    }
}
