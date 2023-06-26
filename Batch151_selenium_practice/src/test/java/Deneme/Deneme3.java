package Deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Deneme3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver() ;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
   /*
        ödev : 7
        Amazon sayfasına gidiniz
        iphone aratınız
        çıkan sonuç yazısını konsola yazdırınız
        çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
        */
        driver.get("https://amazon.com");
        WebElement aramaKutusu =driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        List<WebElement> sonuclar =driver.findElements(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")) ;
        WebElement sonucYazisi =sonuclar.get(0) ;
        System.out.println(sonucYazisi.getText());

        String sonucsayisi [] =sonucYazisi.getText().split(" ") ;
        System.out.println(Arrays.toString(sonucsayisi));
        System.out.println(sonucsayisi[2]);

        List<WebElement> urunler= driver.findElements(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[position()>=1 and position()<=5]"));

        urunler.forEach(t-> System.out.println(t.getText()));

        System.out.println("******************************");

        for (int i = 0; i < urunler.size(); i++) {
            urunler= driver.findElements(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[position()>=1 and position()<=5]"));
            System.out.println(urunler.get(i).getText());
            urunler.get(i).click();
            Thread.sleep(1500);
            driver.navigate().back();
            Thread.sleep(1000);
        }

    }
}
