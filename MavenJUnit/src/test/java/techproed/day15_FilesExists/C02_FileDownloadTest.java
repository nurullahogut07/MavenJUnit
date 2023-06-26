package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=file-
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-");

        //file download adresine gidelim.
        driver.findElement(By.xpath("//a[@href='index.php?page=file-download']")).click();

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//a[@href='../download/b10 all test cases, code.docx']")).click();

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu ="C:\\Users\\nurim\\Downloads\\b10 all test cases, code.docx";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        File file = new File(dosyaYolu);
        Assert.assertTrue(file.exists());
        file.delete();
    }
}
