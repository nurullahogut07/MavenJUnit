package techproed.day01_ilkTest_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_ilkTest {
    public static void main(String[] args) {
        // java uygulamalrinda sistem ozelliklerini ayarlamak icin setProperty methodu ile kullaniriz .
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe") ;
        System.out.println(System.getProperty("webdriver.chrome.driver"));  // getProperty ile "key" degerini girerek "value" ya ulasabiliriz

        WebDriver driver =new ChromeDriver();  // chromedriver turunde yeni bir obje olusturduk
        driver.get("https://www.techproeducation.com"); //get() methodu ile string olarak griilen url ye gideriz



    }
}
