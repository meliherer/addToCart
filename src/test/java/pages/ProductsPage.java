package pages;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {


    By productNameLocator = By.className("o-productList__item");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
    return isDisplayed(productNameLocator);
    }

    public static void selectProductRandomly(WebDriver driver) {

        Random random = new Random();


        int randomIndex = random.nextInt(getAllProducts(driver).size());


        WebElement product = getAllProducts(driver).get(randomIndex);
        product.click();
    }

    public static List<WebElement> getAllProducts(WebDriver driver) {

        return driver.findElements(By.className("o-productList__item"));
    }

    }

