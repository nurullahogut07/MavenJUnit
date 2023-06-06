package techproed.day06Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        //Chrome driver projemize yuklendi
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver() ;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sayfasina gidin
        driver.get("https://amazon.com");

        //arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        //samsung headphones ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones ", Keys.ENTER);
        //bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String [] sonucSayisi=sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = " +sonucSayisi[2]);
        //ilk urune tiklayalim
        WebElement ilkUrun= driver.findElement(By.xpath("(//h2//a)[1]"));
        ilkUrun.click();
        //sayfadaki tum basliklari yazdiralim   (//h1 |//h2) hem h1 hem h2 leri ayni anda yazdirdik
       List <WebElement> basliklar =driver.findElements(By.xpath("//h1 |//h2"));
       basliklar.forEach(t-> System.out.println(t.getText()));



    }
}
