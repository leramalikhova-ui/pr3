package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTests extends BaseTest {

    @Test(description = "Добавление товара в корзину")
    public void testAddToCart() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1",
                "Счётчик корзины должен быть равен 1");
        CartPage cartPage = inventoryPage.goToCart();
        Assert.assertEquals(cartPage.getItemName(), "Sauce Labs Backpack",
                "Наименование товара в корзине не совпадает");
        Assert.assertEquals(cartPage.getItemPrice(), "$29.99",
                "Цена товара в корзине не совпадает");
    }
}