package day08_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {
    @Test
    public void test01() {
        // masaustunde bir text dosyası olusturunuz
        // masaustunde text dosyasının olup olmadıgını test ediniz

      //  Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\nurim\\OneDrive\\Masaüstü\\batch151.txt")));

        // Dinamik hale getirelim (yukarida ki ilk kisim herkesin pc sinde farkli )
       // C:\\Users\\nurim                  \\OneDrive\\Masaüstü\\batch151.txt"
       String farkliKisim= System.getProperty("user.home");   // C:\\Users\\nurim
       String ortakKisim="\\OneDrive\\Masaüstü\\batch151.txt";

       String dosyaYolu =farkliKisim + ortakKisim ;

       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
