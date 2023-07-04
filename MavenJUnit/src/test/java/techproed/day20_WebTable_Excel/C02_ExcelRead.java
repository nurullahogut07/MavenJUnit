package techproed.day20_WebTable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead  {
/*
            EXCEL dosyasından veri okuyabilmemiz için öncelikle pom.xml dosyamıza poi ve poi.ooxml dependency'lerini
        yüklememiz gerekir.
            Sonra üzerinde çalışacağımız excel dosyasını projemizde src>test>java>techpoed>resources package'i içine
          koyarız.
 */

    @Test
    public void test01() throws IOException {
        //1 - Dosya yolunu aliriz
        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";

        //2 - Dosyayi okuyabilmemiz icin javada akisa almamiz gerekir.
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3 - Java ortaminda bir excel dosyasi olusturabilmek icin;
        Workbook workbook = WorkbookFactory.create(fis);  // fis akisa aldigimiz dosyayi okuyoruz

        //4 - Olusturdugumuz excel'den sayfa(sheet) secmemiz gerekir
        Sheet sheet =workbook.getSheet("Sheet1"); // sayfa ismi bakacagimiz excell den aliriz

        //5 - Belirttigimiz sayfadaki satir(row) bilgisini secmemiz gerekir
        Row row =sheet.getRow(0);// satirda index sifirdan basladigi icin 1. satiri getirir

        //6 - Belirttigimiz satirdaki hucre(cell) bilgisini secmemiz gerekir
        Cell cell =row.getCell(0);

        //Son olarak cell bilgisini sout ile yazdirip excel'deki 1. satir 1. hucredeki veriyi gorebiliriz
        System.out.println(cell);


    }

    @Test
    public void test02() throws IOException {
        //  PRATIK COZUM
        // 1. satir ve 1. sutunda ki bilgileri yazdiralim
        FileInputStream fis =new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");

        Workbook workbook =WorkbookFactory.create(fis) ;
        String satir1Sutun1 =workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println("satir1Sutun1 = " + satir1Sutun1);

    }

    @Test
    public void test03() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis =new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook =WorkbookFactory.create(fis);
        String satir1sutun2=workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
        System.out.println("satir1sutun2 = " + satir1sutun2);

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3sutun1 =workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("satir3sutun1 = " + satir3sutun1);
        Assert.assertEquals("France",satir3sutun1);

        //Kullanılan satır sayısın bulun
        System.out.println("Kullanılan Satir Sayisi : "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //NOT:getPhysicalNumberOfRows() methodu kullanılan yani içi dolu olan satırların sayısını verir.Index 1 den başlar

        //Sayfadaki satır sayısını yazdırınız
        System.out.println("Sayfadaki Satir Sayisi : "+workbook.getSheet("Sheet1").getLastRowNum());
        //NOT:getLastRowNum() methodu sayfadaki son satırın sıra numarasını verir ve index 0(sıfır) dan başlar


        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }
    }
}
