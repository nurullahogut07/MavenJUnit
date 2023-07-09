package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.lang.invoke.StringConcatFactory;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        Thread.sleep(2000);

        // Web sayfasina gittikten sonra dowlands yerinde o dosyadan varsa silecek sonra yenisini indirecek
        File silinecekDosya = new File("C:\\Users\\nurim\\Downloads\\some-file.txt") ;
        silinecekDosya.delete() ;

        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("(//a)[12]")).click();
    Thread.sleep(2000);

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
     // "C:\Users\nurim\Downloads\some-file.txt"
        String farkliYol =System.getProperty("user.home");
        String ortakYol ="\\Downloads\\some-file.txt";

        String dosyaYolu= farkliYol + ortakYol ;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
