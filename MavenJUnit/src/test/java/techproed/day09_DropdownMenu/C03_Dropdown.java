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

public class C03_Dropdown {
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
    public void test1() throws InterruptedException {
        // programming languages ddm den istediginiz 4 secenegi seciniz
        WebElement languages = driver.findElement(By.xpath("(//select)[6]"));
        Select select =new Select(languages);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        //eger sadece secili olan secenekleri yazdirmak istersek ; getAllSelectedOptions()  kullaniriz
        select.getAllSelectedOptions().forEach(t-> System.out.println(t.getText()));

        System.out.println("***********************************************");
        // foreach le yazdirmak istersek
        for (WebElement e : select.getAllSelectedOptions()){
            System.out.println(e.getText());
        }
        //seceneklerden 4 tane sectigimizi dogrulayalim
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        //sectiginiz seceneklerden ilkini yazdirin , ilk secenegin java oldugunu dogrulayin
        System.out.println("*************************************");
        System.out.println("Seceneklerden Ilki = "+select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java" ,select.getFirstSelectedOption().getText());

       // Thread.sleep(2500);
        bekle(2);
        // sectigimiz seceneklerin hepsini kaldiralim
        select.deselectAll();

        //sendkeys() methodu ile istedigimizi secenegi gonderelim
       // languages.sendKeys("C#");

        //visibleText olarak secim yapacagimiz bir method olusturup programming languages ddm den bir secenek secelim
      selectVisibleText(languages,"Java");
      bekle(2);
    }
    // Assegida method olustuduk ve hemen yukarida bu methodu kullandik

    //Parametre olarak  webelement ve visibletext olarak girdik (ddm webelementimizin ismi neyse o )
    public void selectVisibleText(WebElement ddm ,String secenek){
        Select select=new Select(ddm);
        select.selectByVisibleText(secenek);

    }
    public void bekle (int saniye)  {  //exception atmadik her seferinde beklemesin diye try catch kullandik
        try {
            Thread.sleep(saniye*1000) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() throws Exception {
    driver.close();
    }
}






