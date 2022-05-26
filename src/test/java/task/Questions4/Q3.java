package task.Questions4;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Q3 {
    //excel dosyasindaki tüm verileri classimiza alip
    // bir java objesine store edelim
    //böylece her seferinde excele ulasip satir sütun vs.. ugrasmayalim

    //database yapisinda olan exceli
    //koyabilecegimiz en uygun Java objesi maptir

    //Listede Ghana oldugunu test et


    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String, String> ülkelerMapList = new HashMap<String, String>();
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <= sonSatirIndex; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    + ", " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    + ", " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ülkelerMapList.put(key, value);

        }
        ülkelerMapList.containsKey("Ghana");


    }
}
