package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Homepage extends BasePage {

    Searchbox searchBox;
    By homePageHeaderLocator = By.xpath("//header[@class='o-header']");
    By acceptCookieLocator = By.id("onetrust-accept-btn-handler");
    By genderButtonLocator = By.id("genderManButton");
    By noThanksLocator = By.className("dn-slide-deny-btn");
    By sizeButtonLocator = By.xpath("//span[normalize-space()='S']");
    By addToCartButtonLocator = By.xpath("//button[@id='addBasket']");
    By cartIconLocator = By.xpath("//a[@title='Sepetim']//*[name()='svg']");


    public Homepage(WebDriver driver) {
        super(driver);
        searchBox = new Searchbox(driver);
    }


    public Searchbox searchBox() {

        return this.searchBox;

    }

    public void goToCart() throws InterruptedException {

        click(cartIconLocator);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    public boolean isProductCountUp() {

        return isDisplayed(homePageHeaderLocator);
    }

    public boolean isOnHomePage() {

        return isDisplayed(homePageHeaderLocator);
    }
    public void acceptAllNotifications() throws InterruptedException {
        if(isDisplayed(acceptCookieLocator)){
            click(acceptCookieLocator);
        } if (isDisplayed(genderButtonLocator)) {
            click(genderButtonLocator);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         if (isDisplayed(noThanksLocator)) {
            click(noThanksLocator);

        }
        System.out.println("Homepage available!");

    }
}
