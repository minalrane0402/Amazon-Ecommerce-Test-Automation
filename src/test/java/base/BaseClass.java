package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 🔴 ADD AMAZON URL HERE
        driver.get("https://www.amazon.in/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}