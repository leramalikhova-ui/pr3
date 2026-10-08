package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {
    private final By title = By.className("title");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartLink = By.className("shopping_cart_link");
    private final By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By sortDropdown = By.className("product_sort_container");
    private final By itemNames = By.className("inventory_item_name");
    private final By itemPrices = By.className("inventory_item_price");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getText(title);
    }

    public void addBackpackToCart() {
        click(addToCartBackpack);
    }

    public String getCartBadgeCount() {
        return getText(cartBadge);
    }

    public CartPage goToCart() {
        click(cartLink);
        return new CartPage(driver);
    }

    public void selectSortOption(String option) {
        WebElement dropdown = waitForVisibility(sortDropdown);
        dropdown.click();
        driver.findElement(By.xpath("//option[text()='" + option + "']")).click();
    }

    public List<String> getItemNames() {
        return driver.findElements(itemNames).stream().map(WebElement::getText).toList();
    }

    public List<Double> getItemPrices() {
        return driver.findElements(itemPrices).stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .toList();
    }
}