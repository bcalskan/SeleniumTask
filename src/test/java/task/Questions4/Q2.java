package task.Questions4;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Q2 {
    //input olarak verilen
    //satirno sütünno degerlerini parametre olarak alip
    //o celldeki datayi String olarak bana döndüren bir method olusturun
    //dönen Stringin Cezayir oldugunu test edin
    //ingilizce baskentler sütununu yazdir

    //Sayfa2 ye gidip satir sayisinin 29,
    // kullanilan satir sayisinin 13 oldugunu test edin


    @Test
    public void test01() throws IOException {
        int satirNo = 7;
        int sütunNo = 3;
        String actualData = dataGetirici(satirNo - 1, sütunNo - 1);
        String expectedData = "Antigua ve Barbuda";
        System.out.println("Expected : " + expectedData);
        System.out.println("Actual : " + actualData);
        Assert.assertEquals(expectedData, actualData);

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirNo = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatirNo);

        //ingilizce baskentler sütununu yazdir
        String satirdakiDatalar = "";
        for (int i = 0; i < sonSatirNo; i++) {
            satirdakiDatalar = dataGetirici(i, 1);
            System.out.println(satirdakiDatalar);
        }
    }

    private String dataGetirici(int satirIndex, int sütunIndex) throws IOException {
        String istenenData = "";
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData = workbook.getSheet("Sayfa1").getRow(satirIndex).getCell(sütunIndex).toString();

        return istenenData;
    }
}
