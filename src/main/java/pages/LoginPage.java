package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By signInLink = By.xpath("//*[@id=\"nav-link-accountList\"]");
    By searchBox = By.xpath("//*[@id=\"twotabsearchtextbox\"]"); // post-login indicator, (login assertion)

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void openLoginPage() {
        driver.findElement(signInLink).click();
        System.out.println("➡ Please login manually in the browser...");
    }

    public void waitForLoginSuccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        System.out.println("✅ Login successful. Automation continues...");
    }
}