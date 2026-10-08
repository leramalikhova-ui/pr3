package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTests extends BaseTest {

    @Test(description = "Оформление заказа")
    public void testCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();
        CartPage cartPage = inventoryPage.goToCart();
        CheckoutPage checkoutPage = cartPage.clickCheckout();
        checkoutPage.fillCustomerInfo("John", "Doe", "12345");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
        Assert.assertEquals(checkoutPage.getCompleteHeader(), "Thank you for your order!",
                "Ожидалось подтверждение заказа");
    }

    @Test(description = "Валидация пустого поля при оформлении")
    public void testCheckoutEmptyField() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();
        CartPage cartPage = inventoryPage.goToCart();
        CheckoutPage checkoutPage = cartPage.clickCheckout();
        checkoutPage.clickContinue(); // не заполняем поля
        String error = checkoutPage.getErrorMessage();
        Assert.assertTrue(error.contains("Error: First Name is required"),
                "Ожидалась ошибка о необходимости First Name");
    }
}