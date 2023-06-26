package Deneme;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver() ;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;

        // "https://teknosa.com/" adresine gidiniz
        driver.get("https://teknosa.com");

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String title =driver.getTitle() ;
        String url =driver.getCurrentUrl();
        System.out.println(url);
        System.out.println(title);

        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        String actualTitle =driver.getTitle();
        String expectedTitle ="Teknoloji" ;

        if (actualTitle.contains("Teknoloji")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
       if (url.contains("teknosa")){
           System.out.println("test passed");
       }else {
           System.out.println("test failed");
       }
       Thread.sleep(1000);
        // "https://medunna.com/" adresine gidiniz
        driver.get("https://medunna.com");

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
       String title2= driver.getTitle();
        String url2 =driver.getCurrentUrl();

        System.out.println(title2);
        System.out.println(url2);

        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        if (title2.contains("MEDUNNA")){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        if (url2.contains("medunna")){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
        // teknosa adresine geri donunuz
        driver.navigate().back();
        Thread.sleep(1000);
        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(1000);
        // medunna adresine ilerleyiniz
        driver.navigate().forward();
        Thread.sleep(1000);
        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(1000);
        // pencereyi kapat
        driver.close();
    }
}
