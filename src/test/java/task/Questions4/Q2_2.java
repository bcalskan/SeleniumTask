package task.Questions4;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Q2_2 {

    //Sayfa2 ye gidip satir sayisinin 29,
    // kullanilan satir sayisinin 13 oldugunu test edin

    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int lastRowNumber = workbook.getSheet("Sayfa2").getLastRowNum();
        int usedRowNumber = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        int expectedSatirSayisi = 29;
        int expectedKullanilanSatirSayisi = 13;

        Assert.assertTrue(lastRowNumber+1 == expectedSatirSayisi);
        Assert.assertTrue(usedRowNumber == expectedKullanilanSatirSayisi);
    }
}
