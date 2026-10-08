package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By checkoutButton = By.id("checkout");
    private final By itemName = By.className("inventory_item_name");
    private final By itemPrice = By.className("inventory_item_price");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return getText(itemName);
    }

    public String getItemPrice() {
        return getText(itemPrice);
    }

    public CheckoutPage clickCheckout() {
        click(checkoutButton);
        return new CheckoutPage(driver);
    }
}