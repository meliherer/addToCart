package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class CartPage extends BasePage{
    By productLocator = By.xpath("//div[@class='m-basket__content']");
    By productClearLocator = By.id("removeCartItemBtn0-key-0");
    By emptyCartInfoLocator = By.className("m-empty__messageTitle");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void clearProductOnCart() throws InterruptedException {
        click(productClearLocator);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Product has been deleted!");

    }
    public void productCountSelect(String value) throws InterruptedException {
try {
    WebElement dropdown = driver.findElement(By.id("quantitySelect0-key-0"));
    Select select = new Select(dropdown);
    select.selectByValue(value);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    System.out.println("Piece count increased");
}catch (NullPointerException e){
    System.out.println("Error"+ e);

}


    }

    public boolean checkIfPriceSame() {

        return isDisplayed(productLocator);
    }

    public boolean checkIfCartEmpty() {

        return isDisplayed(emptyCartInfoLocator);

    }
}
