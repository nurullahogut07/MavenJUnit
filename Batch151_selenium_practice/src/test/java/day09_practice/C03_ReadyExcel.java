package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadyExcel {
    @Test
    public void test01() throws IOException {
        //Ulkeler dosyasindaki tum datalari Map'e aliniz ve yazdiriniz
        Map <String,String> ulkelerMap =new TreeMap<>();  // hashmap te daha hizli getirir ama karisik getirir

        String dosyaYolu ="src/resources/ulkeler (1).xlsx";
        FileInputStream fis =new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis) ;

        int sonSatirIdx =workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatirIdx ; i++) {

          String key=  workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString() ; // key kismi (mapler konusuna don bak)

          String value =workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ","
         +  workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ","
          + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString() + "\n" ;

          ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);


    }
}
