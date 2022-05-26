package task.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBaseClass;

import java.time.Duration;

public class Q01_WebElementGetText extends TestBaseClass {
    /*
    ...Exercise1...
    BeforeClass ile driver ı olusturun ve class icinde static yapin
    Maximize edin, 15 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatın
     */

    @Test
    public void test01() {

        //    http://www.google.com adresine gidin
        driver.get("http://www.google.com");

        //    arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
        //    arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
        //    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
        //    AfterClass ile kapatın

    }
}
