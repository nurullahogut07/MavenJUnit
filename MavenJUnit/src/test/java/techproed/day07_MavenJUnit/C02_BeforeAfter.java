package techproed.day07_MavenJUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {  //mvnrepository den JUNIT indirdik , pom.xml e kaydettik

        /*
            Notasyonlara sahip methodlar oluşturabilmek için mause+sağtik+generate(kısayol alt+insert) yaparak
        after methodu için teardown'u seçeriz.
        before methodu için setup'ı seçeriz.
        test methodu için de test'i seçeriz.
        Junit frameworkun de testlerinmizi siralama yapabilmek icin extre bir notasyon yoktur , eger belli siralamada calistirmak istersek ;
        method isimlerini alfabetik veya sayisal olarak belirtmemiz gerekir
         */
    @After
    public void tearDown()  {
        System.out.println("Her test methodundan sonra bir kez calisir");
    }

    @Before
    public void setUp() {
        System.out.println("Her test methodundan once bir kez calisir");
    }

    @Test
    public void test1() {
        System.out.println("Test1 methodu calisti");
    }

    @Test
    public void test2() {
        System.out.println("Test2 methodu calisti");
    }

    @Test
    public void test3() {
        System.out.println("Test3 methodu calisti");
    }
}
