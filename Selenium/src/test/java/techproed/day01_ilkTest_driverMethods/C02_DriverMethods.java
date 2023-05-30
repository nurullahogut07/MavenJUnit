package techproed.day01_ilkTest_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver() ;

        driver.get("http://amazon.com");
        System.out.println("Amazon Actual Title  = " + driver.getTitle());
        System.out.println("Amazon Actual Url = " + driver.getCurrentUrl());
        System.out.println("Amazon Window Handle = " + driver.getWindowHandle());
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("Amazon Window Handle = " + amazonWindowHandle); // amazon handle i sik sik kullanacaksak boyle yapabiliriz

        driver.get("http://techproeducation.com");
        // getTitle()  sayfa basligini verir (Techpro Education | Online It Courses & Bootcamps)
        System.out.println("Techproed Actual Title = " + driver.getTitle());

        // getCurrentUrl() gidilen sayfanin url"sini verir
        System.out.println("Techproed Actual Url = " + driver.getCurrentUrl());

        //getPageSource() acilan sayfanin kaynak kodlarini verir , bir seyler iceriyor mu icermiyor mu diye bakabiliriz , az kullanilir
        // -->> System.out.println("driver.getPageSource() = " + driver.getPageSource());

        //.getWindowHandle() gidilen sayfanin handle degerini(hashkod) verir , bu degerle sayfalar arasi gecis icin kullaniriz
        System.out.println("Techpro Window Handle = " + driver.getWindowHandle());

    }

}
