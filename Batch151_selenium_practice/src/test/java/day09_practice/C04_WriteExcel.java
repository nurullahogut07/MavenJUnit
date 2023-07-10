package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {
    @Test
    public void test01() throws IOException {
        // Ulkeler dosyasındaki 0. satır index'in, 4.hücre index'ine yeni bir cell olusturalım.
        // olusturdugumuz hücreye "Nufus" yazdıralım.

        String dosyaYolu ="src/resources/ulkeler (1).xlsx";
        FileInputStream fis =new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis) ;

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

       // 1. satir index'in 4. hucre index'ine yeni bir cell olusturun olusturdugunuz hucreye "15000" yazdirin
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(15000);

        //   2. satir index'inin 4. hucre index'ine yeni bir cell olusturun olusturdugunuz hucreye "25000" yazdirin
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue(25000);

        FileOutputStream fos =new FileOutputStream(dosyaYolu); // datalari ulkeler dosyasina yollamak icin yaptik
        workbook.write(fos); // dosyaya yazdirdik

    }
}
