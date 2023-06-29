package Tasklar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task05 extends TestBase {
    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();
        // İkinci emoji öğelerini yazdırınız
        List<WebElement> emojiler =driver.findElements(By.xpath("//*[@id='nature']//div"));
        for (WebElement w: emojiler) {
            System.out.println(w.getText());
        }

        // Parent iframe e geri donun
        driver.switchTo().defaultContent();

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String > veriler = new ArrayList<>(Arrays.asList(
                "Nuri" ,"Son","selenium","lambda","java","sql","github","fsd","asd","asfd","dfsd","dsfg","fghfgh"));
        for (int i = 0; i < list.size() ; i++) {
            list.get(i).sendKeys(veriler.get(i));
        }

        // Apply button a basiniz
        driver.findElement(By.xpath("//*[text()='Apply']")).click();




    }


}
