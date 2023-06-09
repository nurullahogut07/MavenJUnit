package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    /*
    Dropdown == Alt basliklarin oldugu acilir menu listesidir .
    Dropdown u handle etmek icin  ;
    1)Dropdown menuyu ilk olarak locate ederiz
    2)Select objesi olustururuz
    3)Select objesinin ddm webelemetinin icerigine ve seceneklerine erisim saglamasi icin
    Select sinifina arguman olarak locate ettigimiz webelementi koyariz
    SYNTAX ;;
             Select select =new Select(ddm webelemeti)
     4)Select class'i sadece <select> tag i ile olusturulmus dropdown menulerine uygulanabilir
     5--> select objesi ddm'yü handle edebilmek icin 3 method kullanir.
         ->selectByVisibleText() --> Ddm'deki elemente görünür metin ile ulaşmak icin kullanilir.
         ->selectByIndex() --> Index ile ulasmak icin kullanilir(Index 0(sıfır)'dan baslar)
         ->selectByValue() --> Elementin degeri ile ulasmak icin kullanilir(option tag'larindaki deger(value) ile)
    6--> getOptions() --> Locate ettigimiz ddm'deki tüm secenekleri bize verir.List'e atip loop ile yazdırabiliriz.
    7--> getFirstSelectedOption() --> Ddm'deki secili kalan secenegi bize verir.Birden fazla secenek secildiyse
         bu secilenlerin ilkini bize verir.
     8) Ddm'ye sendKeys() methodu ile de ddm menudeki seceneklerden birini kullanarak gonderebiliriz.
     */



    /*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */
    WebDriver driver ;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver() ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test1() {
      //  1.Method:
        // a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement ay = driver.findElement(By.xpath("//*[@id='month']"));
        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));

     //    b. Select objesi olustur
        Select select =new Select(yil);

        //   c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        select.selectByIndex(5);  // index degerini kacinci index yani burada yil'i istiyorsak onu verir(2018)
        Select select1 =new Select(ay);
        select1.selectByValue("6"); //value degeri 6 olani alacak --> HAziran
        Select select2 =new Select(day);
        select2.selectByVisibleText("15"); // gorunen neyse onu sececek
    }

    @Test
    public void test2() {
        // a. Tüm eyalet isimlerini select ile yazdıralım
        WebElement eyaletler =driver.findElement(By.xpath("(//select)[5]"));
        Select select =new Select(eyaletler);
        select.getOptions().forEach(t-> System.out.println(t.getText())); // getOptions tum hepsini getirir
                                                                       // list yapmamiza gerek kalmaz

        /*      Diger yazdirma secenegi

        List<WebElement> eyaletlerr = driver.findElements(By.xpath("(//select)[5]"));
        eyaletlerr.forEach(w-> System.out.println(w.getText()));
         */

        System.out.println("*********************************");
           // 2.YOL
        List<WebElement> eyaletler2 =driver.findElements(By.xpath("(//select)[5]"));
        eyaletler2.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void test3() {
        // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement state =driver.findElement(By.xpath("(//select)[5]"));
        Select select =new Select(state);
        String seciliSecenek =select.getFirstSelectedOption().getText();
        System.out.println(seciliSecenek);
        Assert.assertEquals("Select a State",seciliSecenek);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
