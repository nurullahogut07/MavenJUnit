package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel  {
    @Test
    public void test01() throws IOException {
        // Ulkeler dosyasındaki 3.satırdaki indexin, 3. sutunundaki indexinin
        // "Cezayir" oldugunu test eden method olusturunuz.
        int satirNoIdx =3 ;
        int sutunNoIdx =3;

      String actualData=  banaDataGetir(satirNoIdx,sutunNoIdx);  // method call
        String expectedData="Cezayir";
        Assert.assertEquals(expectedData,actualData);
    }

    public static String banaDataGetir(int satirNoIdx, int sutunNoIdx) throws IOException {
        String dosyaYolu ="src/resources/ulkeler (1).xlsx";
        FileInputStream fis =new FileInputStream(dosyaYolu); // ulkeler dosyasini bizim sisteme getirir
        Workbook workbook = WorkbookFactory.create(fis) ; //dosya yi workbook a atadik

      String istenenData=  workbook.getSheet("Sayfa1").getRow(satirNoIdx).getCell(sutunNoIdx).toString();

      return istenenData;

    }

    @Test
    public void test02() throws IOException {
        // Ulkeler dosyasındaki 3.satırdaki indexin, 3. sutunundaki indexinin
        // "Cezayir" oldugunu test eden method olusturunuz.
        int satirNoIdx2 =10 ;
        int sutunNoIdx2 =2;

        String actualData=  banaDataGetir(satirNoIdx2,sutunNoIdx2);  // method call
        String expectedData="Avusturyaa";
        Assert.assertEquals(expectedData,actualData);
    }

    public String banaDataGetir2(int satirNoIdx2, int sutunNoIdx2) throws IOException {
        String dosyaYolu ="src/resources/ulkeler (1).xlsx";
        FileInputStream fis =new FileInputStream(dosyaYolu); // ulkeler dosyasini bizim sisteme getirir
        Workbook workbook = WorkbookFactory.create(fis) ; //dosya yi workbook a atadik

        String istenenData=  workbook.getSheet("Sayfa1").getRow(satirNoIdx2).getCell(sutunNoIdx2).toString();

        return istenenData;

    }
}
