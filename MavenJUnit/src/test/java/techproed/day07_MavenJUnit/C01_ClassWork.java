package techproed.day07_MavenJUnit;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

    //2.Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        Thread.sleep(1000);

    //3.Login alanine "username" yazdirin
        //4.Password alanine "password" yazdirin
        //5.Sign in buttonuna tiklayin
     WebElement login =   driver.findElement(By.cssSelector("input#user_login"));
     login.sendKeys("username",Keys.TAB,"password", Keys.ENTER);   // keys.Tab ile password kisminida ekledik
        Thread.sleep(1000);
     driver.navigate().back(); ;
    //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*['Online Banking'])[58]")).click();
        Thread.sleep(1000);
       driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click();
    //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8.tarih kismina "2020-09-10" yazdirin
        Thread.sleep(1000);
       driver.findElement(By.cssSelector("#sp_amount")) .sendKeys("500",Keys.TAB ,"2020-09-10",Keys.ENTER);
        Thread.sleep(1000);
        /*     KEYS.TAB  bize kolaylik saglar ,eger tab ile o yerlere gidebiliyorsak ayri ayri locate almamiza gerek kalmaz
        driver.findElement(By.cssSelector("#sp_amount")) .sendKeys("500",Keys.TAB ,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER); --> 9. adimida burada yapmis olduk
        KEYS.SPACE ==== radio veya checkbox lari doldurmamizi saglar
         */

    //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        Thread.sleep(1000);

    //10."The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement sonuc = driver.findElement(By.xpath("(//span)[1]"));
        System.out.println(sonuc.getText().contains("The payment was successfully submitted"));

        if (sonuc.getText().equals("The payment was successfully submitted.")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
       Thread.sleep(1000);
        // sayfayi kapatalim
        driver.close();
    }
}
