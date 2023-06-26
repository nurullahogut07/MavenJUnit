package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_practice {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver() ;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;

        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 20 giriniz
        WebElement ilkKutu = driver.findElement(By.xpath("//input[@id='number1'] "));
        ilkKutu.sendKeys("20");
        Thread.sleep(1000);

        // ikinci kutucuga 30 giriniz
        WebElement ikinciKutu = driver.findElement(By.xpath("//input[@id='number2'] "));
        ikinciKutu.sendKeys("30");
        Thread.sleep(1000);

        // calculate'e tıklayınız
        driver.findElement(By.xpath("//input[@id='calculate'] ")).click();

        // sonucu yazdırınız
        WebElement sonucYazisi= driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println("Toplama Sonucu =" + sonucYazisi.getText());

        // sayfayi kapatiniz
        driver.close();
    }

}
