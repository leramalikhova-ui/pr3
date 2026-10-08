package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test(description = "Позитивная авторизация standard_user")
    public void testPositiveLogin() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getTitle(), "Products",
                "Ожидался заголовок 'Products' на странице инвентаря");
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),
                "URL должен содержать /inventory.html");
    }

    @Test(description = "Негативная авторизация locked_out_user")
    public void testNegativeLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Epic sadface"),
                "Ожидалось сообщение об ошибке, содержащее 'Epic sadface', но получено: " + error);
    }
}