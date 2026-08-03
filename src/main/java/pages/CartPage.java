package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    // -------- Product Page --------
    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    WebElement addToCartBtn;

    // -------- Cart Navigation --------
    @FindBy(xpath = "//*[@id=\"nav-cart-count\"]")
    WebElement cartIcon;

    // -------- Cart Page --------
    @FindBy(xpath = "//input[@value='Delete' or @aria-label='Delete']")
    WebElement deleteBtn;

    @FindBy(xpath = "//*[@id=\"sc-active-cart\"]/div/h3")
    WebElement emptyCartText;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // ================= ADD TO CART =================
    public void addToCart() {
        try {
            wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", addToCartBtn);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", addToCartBtn);

            System.out.println("Clicked Add to Cart button");

        } catch (Exception e) {
            System.out.println("Add to Cart not clickable due to Amazon restrictions");
        }
    }

    // ================= GO TO CART =================
    public void goToCart() {
        try {
        	driver.navigate().refresh();
            System.out.println("Page refreshed before checking Cart");

            // Wait for the button to be visible after refresh
            wait.until(ExpectedConditions.visibilityOf(cartIcon));

            wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
            cartIcon.click();
            System.out.println("Navigated to Cart page");
        } catch (Exception e) {
            System.out.println("Unable to navigate to Cart page");
        }
    }

    // ================= REMOVE FROM CART =================
    public void removeFromCart() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
            deleteBtn.click();
            System.out.println("Product removed from cart");
        } catch (Exception e) {
            System.out.println("No product available to remove");
        }
    }

    // ================= VALIDATION =================
    public boolean isCartEmpty() {
        try {
        	driver.navigate().refresh();
            wait.until(ExpectedConditions.visibilityOf(emptyCartText));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}