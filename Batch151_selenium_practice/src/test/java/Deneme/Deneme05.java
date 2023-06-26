package Deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Deneme05 {
    public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
            WebDriver driver =new ChromeDriver() ;

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;

        //http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com");

//Add Element butonuna 100 defa basınız
        WebElement bas = driver.findElement(By.xpath("//*[@href='/add_remove_elements/']"));
        bas.click();

//100 defa basıldığını test ediniz
        WebElement aadd=driver.findElement(By.xpath("(//*[@onclick='addElement()'])[1]"));

        int i=0 ;
        for (i = 0; i <101 ; i++) {
            if (i<101)
                aadd.click();
            else System.out.println("TEST FAILED");
        } System.out.println("ADD/ELEMENT 100 KEZ TIKLANDI VE TEST PASSED");

//90 defa delete butonuna basınız
// 90 defa basıldığını doğrulayınız

        List<WebElement> sil = driver.findElements(By.xpath("(//*[@class='added-manually'])[position()>=1 and position()<=90]"));
        for (int sl = 0; sl <=90 ; sl++) {
            sil =driver.findElements(By.xpath("(//*[@class='added-manually'])[position()>=1 and position()<=90]"));
            sil.get(0).click();
        }System.out.println("Add/remove 90 KEZ TIKLANDI VE TEST PASSED");

        Thread.sleep(2000);

//Sayfayı kapatınız
        driver.close();

    }
}



