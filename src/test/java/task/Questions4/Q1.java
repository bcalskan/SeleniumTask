package task.Questions4;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Q1 {
    //1. apache poi dependency’i pom file’a ekleyelim
    //2. Java klasoru altinda resources klasoru olusturalim
    //3. Excel dosyamizi resources klasorune ekleyelim
    //4. excelAutomation isminde bir package olusturalim
    //5. ReadExcel isminde bir class olusturalim
    //6. readExcel() method olusturalim
    //7. Dosya yolunu bir String degiskene atayalim
    //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //10. WorkbookFactory.create(fileInputStream)
    //11. Worksheet objesi olusturun workbook.getSheetAt(index)
    //12. Row objesi olusturun sheet.getRow(index)
    //13. Cell objesi olusturun row.getCell(index)


    @Test
    public void readExcel() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));


    }
}
