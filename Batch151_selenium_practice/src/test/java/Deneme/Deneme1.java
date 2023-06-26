package Deneme;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver() ;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;

        // "https://www.amazon.com/" adresine gidiniz.
        driver.get("https://www.amazon.com");
        Thread.sleep(1500);

        // "https://www.n11.com/" adresine gidiniz.
        driver.get("https://www.walmart.com/");
        Thread.sleep(1500);
        // amazon adresine geri donunuz
        driver.navigate().back();
        Thread.sleep(1500);
        // n11 adresine ilerleyiniz
        driver.navigate().forward();
        Thread.sleep(1500);
        // sayfayi yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(1500);
        // pencereyi kapat
        driver.close();
        // Konsola "HER ŞEY YOLUNDA" yazdir
        System.out.println("Her sey Yolunda");
    }
}
