package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By accountList = By.xpath("//*[@id=\"nav-link-accountList\"]");
    By signOutBtn = By.xpath("//*[@id=\"nav-item-signout\"]");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void logout() {
        Actions actions = new Actions(driver);

        // Hover on Account & Lists
        actions.moveToElement(driver.findElement(accountList)).perform();

        // Click Sign Out
        wait.until(ExpectedConditions.elementToBeClickable(signOutBtn)).click();

        System.out.println("✅ Logged out successfully");
    }

    // VALIDATE LOGOUT 
    public boolean validateLogout() {
        try {
            // Wait for the URL to change to indicate logout (e.g., sign-in page)
            wait.until(ExpectedConditions.urlContains("signin"));
            // check for absence of account list or presence of sign-in elements
            // Example: return !driver.findElements(accountList).isEmpty(); // If accountList is absent, logout succeeded
            System.out.println("✅ Logout validation passed");
            return true;
        } catch (Exception e) {
            System.out.println("❌ Logout validation failed");
            return false;
        }
    }
}