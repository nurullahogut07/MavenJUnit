package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here
         /*
        drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
         */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();

         /*
            Eger bir hareketli webelementi tutup baska bir webelementin uzerine birakmak istersek
             suruklemek istedigimiz webelementi locate'ini alip uzerine birakacagimiz webelementin locate'ini de alarak
             dragAndDrop(source(kaynak),target(hedef)) methodu ile islemi gerceklestirebiliriz
         */
    }

    @Test
    public void test02() {
        driver.get("https://jqueryui.com/droppable");

        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).  // bu method ile webelemente mouse ile basili tuttuk
                moveToElement(drop). // bu method ile basili olan webelementi hedefteki elementin uzerine goturduk
                release(). // basili tuttugumuz webeelmenti serbest biraktik
                perform(); // islemi sonlandirdik
    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(150, 28).//-->Belirtmiş olduğumuz kordinatlara we'ti taşır
                release().perform();
    }
}
