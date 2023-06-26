package techproed.day11_ifrane_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    /*
           Eğer sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle başka sayfaya gittikten sonra
           tekrar ilk açtığınız sayfaya dönmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
           String bir değişkene handle değerini assingn ederseniz tekrar ilk açılan sayfaya dönmek istediğinizde
           driver.switchTo().window(ilksayfaHandleDeğeri) ile geçiş yapabilirsiniz.
            */
    @Test
    public void WindowHandle() {
    //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get(" https://www.techproeducation.com");
    String techproWindowHandle = driver.getWindowHandle();

    //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle= driver.getTitle();
        String expectedTitle="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actualTitle,expectedTitle);

    //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW) ; // --. yeni bir pencereye drive tasir
                                                        // WindowType.Tab -- > yeni bir sekme acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

    //Window 3'te(yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW) ;
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

    //techproeducation sayfasına geçiniz:  (techpro sayfasinin handle degeriniz alarak gecis yapacagiz )
    driver.switchTo().window(techproWindowHandle);
    bekle(2);
    //youtube sayfasına geçiniz:
    driver.switchTo().window(youtubeWindowHandle);
        bekle(2);
    //linkedIn sayfasına geçiniz:
    driver.switchTo().window(linkedinWindowHandle);
        bekle(2);

    }

}
