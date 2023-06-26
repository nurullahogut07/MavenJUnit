package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {
        //Aşağıdaki bilgileri kullanarak authentication yapınız:
        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin

        //    Başarılı girişi doğrulayın.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);

        //Congratulations! yazısının çıktığını doğrulayın
        WebElement text = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text.getText().contains("Congratulations!"));

        //Elemental Selenium yazısına tıklayalım
        driver.findElement(By.xpath("(//a)[2]")).click();
        List<String> pencereler =new ArrayList<>(driver.getWindowHandles());

        //Başlığın Elemental Selenium olduğunu doğrulayın
        driver.switchTo().window(pencereler.get(1));
        String actualTitle= driver.getTitle();
       Assert.assertTrue(actualTitle.contains("Elemental Selenium"));

       // DDM den Javayi secelim
      WebElement ddm=  driver.findElement(By.xpath("//select"));
        Select select =new Select(ddm) ;
      select.selectByVisibleText("Java");

     // selectVisibleText(ddm,"Java");  --> bu methodla da yapilabilir

    }
}
