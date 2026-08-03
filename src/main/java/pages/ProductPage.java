package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    By searchResultContainer =
            By.xpath("//div[@data-component-type='s-search-result']");

    By productLinks =
            By.xpath("//div[@data-component-type='s-search-result']//a[@class='a-link-normal s-no-outline']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void selectFirstProduct() {

        // 1. Wait until search results exist
        wait.until(ExpectedConditions.presenceOfElementLocated(searchResultContainer));
        System.out.println("✅ Search results container present");

        // 2. Fetch product links
        List<WebElement> products = driver.findElements(productLinks);

        if (products.isEmpty()) {
            throw new RuntimeException("❌ No clickable product links found");
        }

        // 3. Scroll to product
        WebElement firstProduct = products.get(0);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", firstProduct
        );

        // 4. Click
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
        System.out.println("✅ First product opened");
    }

}