package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {
        // Ulkeler dosyasındaki "Başkent (İngilizce)" sutununu yazdırınız.
        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        FileInputStream fis =new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

      int sonSatirIdx=  workbook.getSheet("Sayfa1").getLastRowNum(); // son stair numarasini bulduk , index olarak verir
        System.out.println(sonSatirIdx);
    /*
            //NOT: static bir methodu farkli bir class'da kullanabilmek icin class ismiyle ulasabiliriz
               //NOT2: instance bir methoda farkli bir class'dan ulasabilmek icin obje olusturulur.


                for (int i = 0; i <=sonSatirIdx ; i++) {
            String satirdakiData =C01_ReadExcel.banaDataGetir(i,1); // bir onceki classtan banaDataGetir methodunu kullandik
            System.out.println(satirdakiData);
        }

        */
        for (int i = 0; i <=sonSatirIdx ; i++) {

            String satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            System.out.println(satirdakiData);


        }
    }
}
