package Deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Deneme04 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver() ;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
        /*
        odev : 8
http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
Add Element butonuna 100 defa basınız
100 defa basıldığını test ediniz
90 defa delete butonuna basınız
90 defa basıldığını doğrulayınız
Sayfayı kapatınız

         */
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement buton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        buton.click();

        WebElement add=driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        int i=0 ;

        for (int j = 0; j <101 ; j++) {
            if(i<101)  {
                add.click();
            }else {
                System.out.println("Test failed");
            }

        }
        System.out.println("ADD 100 kez tiklanti ve test passed");

        Thread.sleep(200);


        List<WebElement> delete=driver.findElements(By.xpath("//*[@id='elements']"));

        for (int a = 0; a <90 ; a++) {
            delete = driver.findElements(By.xpath("//*[@id='elements']"));
            delete.get(0).click();
        }
        System.out.println("(ADD 90 kez tiklandi ");


        }
    }

