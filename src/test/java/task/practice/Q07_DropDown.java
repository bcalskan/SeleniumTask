package task.practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Q07_DropDown extends TestBase {
    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    //-->Task1 Find Dropdown on Multi Selection
    //-->Task2 Find  all Dropdown Elements on page
    //-->Task3 printout DropDown Elements' number
    //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6


    @Test
    public void test01() {

        // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        //-->Task1 Find Dropdown on Multi Selection
        WebElement ddmMultiSelection = driver.findElement(By.xpath("//input[@id='justAnInputBox']"));

        //-->Task2 Find  all Dropdown Elements on page
        //List<WebElement> ddMenüs = driver.findElements(By.xpath("//input[@class='comboTreeInputBox']"));
        List<WebElement> ddMenüs = driver.findElements(By.xpath("//h3"));
        ddMenüs.stream().forEach(t -> System.out.println(t.getText() + " "));

        //-->Task3 printout DropDown Elements' number
        System.out.println("DDM SIZE : " + ddMenüs.size());

        //-->Task4 choose dropdown elements and printout dropdown elements' name  until choice 6
        //div[@id='comboTree400167DropDownContainer']//ul//li
        Actions actions = new Actions(driver);
        List<WebElement> ddmSelect = driver.findElements(By.xpath("//button[@class='comboTreeArrowBtn']"));
        List<WebElement> ddmSection = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

        for (int i = 0; i < ddmSelect.size(); i++) {
            ddmSelect.get(i).click();
            for (int j = 0; j < ddmSection.size(); j++) {
                do {
                    System.out.println(ddmSection.get(j).getText());
                    j++;
                } while (!ddmSection.get(j).getText().equals("choice 6"));
                break;
            }


        }

    }
}
//for (int i = 0; i < ddmSelect.size(); i++) {
//            ddmSelect.get(i).click();
//
//            for (int j = 0; j < ddmSection.size(); j++) {
//
//                do {
//                    System.out.println(ddmSection.get(j).getText());
//                    j++;
//                } while (!ddmSection.get(j).getText().equals("choice 6"));
//                break;
//            }
