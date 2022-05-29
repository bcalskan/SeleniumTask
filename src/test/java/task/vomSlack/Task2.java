package task.vomSlack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.Arrays;
import java.util.List;

public class Task2 extends TestBaseClass {
    WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
    WebElement ddm = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
    Select select = new Select(ddm);

    @Test
    public void test01() {
        //Test01 :
        //1- amazon gidin

        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(ddm);
        List<WebElement> selectOptions = select.getOptions();
        for (WebElement each : selectOptions) {
            System.out.println(each.getText());
        }
        //System.out.println(selectOptions.size());

        //3- dropdown menude 28 eleman olduğunu doğrulayın
        int expectedSelectOptionNumber = 28;
        Assert.assertTrue(selectOptions.size() == expectedSelectOptionNumber);
    }

    @Test
    public void Test02() throws InterruptedException {
        //Test02
        //1- dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        aramaKutusu.sendKeys("iphone" + Keys.ENTER);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucSayisiText = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String arananKelime = "iphone";
        Assert.assertTrue(sonucSayisiText.getText().contains(arananKelime));

        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciÜrün = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        WebElement ikinciÜrün = driver.findElement(RelativeLocator.with(By.tagName("img")).below(birinciÜrün));
        ikinciÜrün.click();

        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        WebElement ikinciÜrünTitle = driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']"));
        WebElement ikinciÜrünFiyat = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']"));
        System.out.println("Ikinci ürün title : " + ikinciÜrünTitle.getText());
        System.out.println("Ikinci ürün fiyat : " + ikinciÜrünFiyat.getText());
        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addToCart.click();

        //Test03
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //2-dropdown’dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");

        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Kinderwagen" + Keys.ENTER);


        //4-sonuç yazsının puset içerdiğini test edin
        WebElement bebekSonucElement = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String arananKelime2 = "Kinderwagen";
        Assert.assertTrue(bebekSonucElement.getText().contains(arananKelime2));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ddmBebek = driver.findElement(By.xpath("//select[@name='s']"));
        Select select2 = new Select(ddmBebek);
        select2.selectByVisibleText("Price: High to Low");

        WebElement ikinciÜrünBebek = driver.findElement(By.xpath("(//img[@class='s-image'])[2]"));
        WebElement ücüncüÜrünBebek = driver.findElement(RelativeLocator.with(By.tagName("img")).below(ikinciÜrünBebek));
        ücüncüÜrünBebek.click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        WebElement bebekTitle = driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']"));
        WebElement bebekFiyat = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']"));
        String bebekTitleText = bebekTitle.getText();
        String bebekFiyatText = bebekFiyat.getText();

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        WebElement goToCart = driver.findElement(By.xpath("//span[@class='nav-cart-count nav-cart-1 nav-progressive-attribute nav-progressive-content']"));
        goToCart.click();

        WebElement sepetBebekTitle = driver.findElement(By.xpath("//div[@data-item-index='1']"));
        String sepetTitleText = sepetBebekTitle.getText();
        System.out.print(sepetTitleText);

        System.out.println("\n--------------------\n");




        String arr[] = sepetTitleText.split("\n");
        System.out.println(Arrays.toString(arr));

        String sepetBebekFiyat = "";
        for (int i = 0; i < arr.length - 1; i++) {
            if (!arr[i].contains("$")) {
                continue;
            } else {
                sepetBebekFiyat = arr[i] + "." + arr[i + 1];
            }
        }
        System.out.println(sepetBebekFiyat);

        Thread.sleep(2000);




    }


}
