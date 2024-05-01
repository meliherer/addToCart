package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import excelauth.ReadExcel;
import commonFunctions.ReusableFunctions;
import org.openqa.selenium.*;
import pages.CartPage;
import pages.Homepage;
import pages.ProductDetailPage;
import pages.ProductsPage;

import java.io.IOException;

public class beymenAddToCart extends baseTest {


    Homepage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;



    @Test
    @Order(1)
   public void homePageCheck() throws  InterruptedException {
        homePage = new Homepage(driver);
        homePage.acceptAllNotifications();
        Assertions.assertTrue(homePage.isOnHomePage(),"HomePage Is Not Exist!");

}


    @Test
    @Order(2)
    public void searchProduct() throws IOException, InterruptedException {


        homePage = new Homepage(driver);
        productsPage = new ProductsPage(driver);
        String searchText = ReadExcel.getCellData(0, 0);
        homePage.searchBox().search(searchText);
        Thread.sleep(3000);
        driver.switchTo().activeElement().clear();
        Thread.sleep(2000);
        driver.navigate().refresh();
        String searchText2 = ReadExcel.getCellData(0,1);
        homePage.searchBox().search(searchText2 + Keys.ENTER);
        Thread.sleep(3000);

        Assertions.assertTrue(productsPage.isOnProductPage(),"Not On Products Page!");

    }

    @Test
    @Order(3)
    public void clickProduct() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProductRandomly(driver);
        String str1 = driver.findElement(By.className("o-productDetail__description")).getText();
        String str2 = driver.findElement(By.id("priceNew")).getText();
        ReusableFunctions.saveToTxt("src/main/resources/productInfo.txt",str1,str2);
        Thread.sleep(3000);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not On Product Detail Page!");

    }

    @Test
    @Order(4)
    public void addToCartProduct() throws InterruptedException {
        productDetailPage.addToCartProduct();
        ReusableFunctions.copyValueToClipboard(driver, "m-price__new");
        Assertions.assertTrue(homePage.isProductCountUp(), "Product Count Not Increase!");


    }

    @Test
    @Order(5)
    public void goToCart() throws InterruptedException {
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Thread.sleep(3000);
        //ReusableFunctions.getValueFromClipboard();
        String clipboardValue = ReusableFunctions.getValueFromClipboard();
        String actualValue = driver.findElement(By.className("m-orderSummary__value")).getText();
        String newActualValue = actualValue.replace(",00", "");
        ReusableFunctions.isCopiedValueSame(clipboardValue, newActualValue);
        cartPage.productCountSelect("2");
        Thread.sleep(1000);

    }

    @Test
    @Order(6)
    public void clearCart() throws InterruptedException {
        cartPage.clearProductOnCart();
        Assertions.assertTrue(cartPage.checkIfCartEmpty(), "Product Not Deleted!");


    }
}
