package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProductDetailPage extends BasePage{

    By addToCartButtonLocator = By.id("addBasket");
    By productSizeLocator = By.className("m-variation__item");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {

        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCartProduct() throws InterruptedException {
        click(productSizeLocator);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        click(addToCartButtonLocator);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}
