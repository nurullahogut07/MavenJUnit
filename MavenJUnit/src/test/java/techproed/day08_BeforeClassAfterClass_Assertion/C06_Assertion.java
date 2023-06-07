package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {
    /*
   Assertionlarda eşitlik için expected,actual olarak kullanılır (Assert.assertEquals(expectedName,actualName);)
    Test icinde hata aldiginda calismayi durdurur ancak diger testleri calistirmaya devam eder
    */
    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test02() {  // hata gordugu anda calismayi durdurur ve test basarili yazisini yazdirmaz
        Assert.assertEquals(3,2);
        System.out.println("Test basarili bir sekilde calisti");
    }


    @Test
    public void test3() {
        Assert.assertNotEquals(5,3);  // esit olmadigini belirttik ve kod calisti
        System.out.println("Test Basarili sekilde calisti");
    }

    @Test
    public void test04() {
        String actualName="erol" ;
        String expectedName ="Erol" ;
        Assert.assertEquals(expectedName,actualName);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }

    // Assagiadki sartlarda True diyorsak parantez icin de true olmali kod ona gore calisir
    // false dersek sartta false olmali
    @Test
    public void test05() {
        int yas =50 ;
        int emeklilikYas =65 ;
        Assert.assertTrue(emeklilikYas>yas);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test06() {
        int yas = 50;
        int emeklilikYas = 65;
        Assert.assertTrue(emeklilikYas < yas);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test07() {
        int yas = 50;
        int emeklilikYas = 65;
        Assert.assertFalse(emeklilikYas < yas);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
}
