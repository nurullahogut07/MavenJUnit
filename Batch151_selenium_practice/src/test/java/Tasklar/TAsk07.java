package Tasklar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TAsk07 extends TestBase {
    @Test
    public void name() {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement iframe = driver.findElement(By.xpath("//*[@class='content-right twelve columns']"));
        driver.switchTo().frame(iframe);

        WebElement kutu = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        Actions actions =new Actions(driver);
        WebElement drag = driver.findElement(By.xpath("//*[@style='width: 54.902%;']"));
        WebElement drop = driver.findElement(By.xpath("//*[@style='width: 2.35294%;']"));
        actions.dragAndDrop(drag, drop).perform();
        //-Sarı olduğunu test edelim


    }
}
