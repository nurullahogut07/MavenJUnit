package techproed.tests.day23_Annotation;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BeforeGroupsAfterGroups {
        WebDriver driver ;
    @BeforeSuite()
    public void beforeSuite() {
        System.out.println("En basta BeforeSuite calisir");
    }
    @BeforeGroups("gp1")  // ({"gp1","gp2"}) bu sekilde iki isim kullanirsak testlerimize hangi ismi  verirsek calisir
    public void beforeGroups() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test(groups = "gp1")    // (groups = "gp1")  ile beforeGroups a bagladik ve testimiz calisti , aksi halde calismazdi (gp1 verdigimiz isim)
    public void test01() {
   String amazonUrl="https://amazon.com";
    driver.get(amazonUrl);

    }

    @Test(groups = "gp1")
    public void test02() {
        String youtubeUrl ="https://youtube.com";
        driver.get(youtubeUrl);
    }
 /*
 (groups = "gp1") test03 te kullanmadik ama yine sayfaya gitti cunku yukaridaki drive i kapatmadik , bu yuzden facebook a da gitti .
  ayni driver uzerinde group ile baglamasak da bir sonraki test methodu calisir.
  Sadece driver.close() yaparsak bir sonraki test methodu calismaz
  */
    @Test
    public void test03() {
        String facebookUrl="https://facebook.com";
        driver.get(facebookUrl);
    }
}
