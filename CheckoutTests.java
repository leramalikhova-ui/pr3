package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.className("complete-header");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillCustomerInfo(String fName, String lName, String zip) {
        type(firstName, fName);
        type(lastName, lName);
        type(postalCode, zip);
    }

    public void clickContinue() {
        click(continueButton);
    }

    public void clickFinish() {
        click(finishButton);
    }

    public String getCompleteHeader() {
        return getText(completeHeader);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}