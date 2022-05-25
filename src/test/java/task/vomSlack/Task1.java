package task.vomSlack;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;
import utilities.TestBaseImplicitly;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task1 extends TestBaseImplicitly {

    @Test
    public void test01() throws IOException {
        //1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör”
        //seçilir.
        driver.get("https://www.n11.com/");
        driver.findElement(By.xpath("//*[text()='Tamam']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement dahaSonra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Daha Sonra'])[1]")));
        dahaSonra.click();

        WebElement magazalar = driver.findElement(By.xpath("(//*[text()='Mağazalar'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(magazalar).perform();
        WebElement magazalariGör = driver.findElement(By.xpath("//*[text()='Mağazaları Gör']"));
        actions.click(magazalariGör).perform();

        //2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya
        //txt dosyasına yazdırılır.
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        List<WebElement> aHarfiIleBaslayanMagazalar = driver.findElements(By.xpath("(//div[@class='sellerListHolder'])[4]//li"));
        List<String> magazalarList = new ArrayList<String>();
        for (WebElement each : aHarfiIleBaslayanMagazalar
        ) {
            magazalarList.add(each.getText());
        }
        //System.out.println(magazalarList);

    }
}
