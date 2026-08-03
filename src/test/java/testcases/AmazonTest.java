package testcases;

import base.BaseClass;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ProductPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseClass {

    @Test
    public void amazonEndToEndTest()  {

        LoginPage login = new LoginPage(driver);
        login.openLoginPage();
        login.waitForLoginSuccess(); // Selenium auto-detects success


        HomePage home = new HomePage(driver);
        home.searchProduct("Laptop");

        ProductPage product = new ProductPage(driver);
        product.selectFirstProduct();
        // Next: Add to cart
    
 
        CartPage cart = new CartPage(driver);
        cart.addToCart();
        cart.goToCart();
        cart.removeFromCart();

        Assert.assertTrue(cart.isCartEmpty());
   

        LogoutPage logout = new LogoutPage(driver);
        logout.logout();
        logout.validateLogout();
        
    }
}