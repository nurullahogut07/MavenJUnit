package day06_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsDragAndDrop extends TestBase {
    @Test
    public void name() throws InterruptedException {
        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable ");

        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
            WebElement drag =driver.findElement(By.id("draggable"));
            WebElement drop =driver.findElement(By.id("droppable"));

        Actions actions =new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        Thread.sleep(2000);


        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        WebElement yazi =driver.findElement(By.id("droppable"));
        Assert.assertEquals("Dropped!",yazi.getText());

    }
}
