package day08_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {

        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com");

        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        }
        catch (Exception e){
            System.out.println("cookies cikmadi");
        }

        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Oppo" + Keys.ENTER);

        // sonuc yazısını yazdiriniz
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='plp-panel-block1']"));
        System.out.println(sonucYazisi.getText());

        // ilk urunun fotografını cekin
        WebElement ilkUrun =driver.findElement(By.xpath("( //*[@class=' prd-link '])[1]"));

        //cektigimiz dosyayi nereye kaydedecegini belirtiyoruz
        File kayit =new File("target/ekrangoruntusu/urun.Jpeg") ;

        File geciciDosya =ilkUrun.getScreenshotAs(OutputType.FILE);

        //dosyayi istedigimiz yere kopyaliyoruz
        FileUtils.copyFile(geciciDosya,kayit);

    }
}
