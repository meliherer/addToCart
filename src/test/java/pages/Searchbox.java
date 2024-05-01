package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Searchbox extends BasePage {

    By searchBoxLocator = new By.ByCssSelector("input[placeholder='Ürün, Marka Arayın']");

    public Searchbox(WebDriver driver) {super(driver);}

    public void search(String text) {

        type(searchBoxLocator,text);


    }
}
