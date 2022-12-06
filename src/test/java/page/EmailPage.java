package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CustomConditions;
import java.time.Duration;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='listeliens']//*[@class='txtlien']")
    private WebElement generateEmailButton;
    @FindBy(id = "egen")
    private WebElement generatedEmailNameField;
    @FindBy(xpath = "//h2[contains(text(),'Estimated Monthly Cost: USD')]")
    private WebElement costValueFromEmailField;
    @FindBy(xpath = "//span[text()='Проверить почту']")
    private WebElement checkEmailButton;
    @FindBy(id = "refresh")
    private WebElement refreshEmailWindowButton;
    @FindBy(id = "nbmail")
    private WebElement mail;

    ArrayList<String> windowsTabsList;
    private final Logger logger = LogManager.getRootLogger();

    @Override
    public EmailPage openPage(String urlNameOfEmailGenerator) {
        ((JavascriptExecutor) driver).executeScript("window.open();");
        windowsTabsList = new ArrayList<>(driver.getWindowHandles());
        switchTo("emailWindow");
        driver.get(urlNameOfEmailGenerator);
        return this;
    }

    public EmailPage clickGenerateEmailButton() {
        generateEmailButton.click();
        return this;
    }

    public String getEmailName() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(CustomConditions.pageLoadCompleted());
        String generatedEmailName = generatedEmailNameField.getText();
        logger.info("Generated email: " + generatedEmailName);
        switchTo("googleCalculatorWindow");
        return generatedEmailName;
    }

    public EmailPage clickCheckEmailButton() {
        switchTo("emailWindow");
        checkEmailButton.click();
        return this;
    }

    public EmailPage clickRefreshButton() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(refreshEmailWindowButton));
        while (mail.getText().equals("0 mail")) {
            refreshEmailWindowButton.click();
        }
        return this;
    }

    public String getCostInEmail() {
        refreshEmailWindowButton.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ifmail']")));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(costValueFromEmailField));
        String costInEmail = getCostFromText(costValueFromEmailField.getText());
        switchTo("googleCalculatorWindow");
        return costInEmail;
    }

    private String getCostFromText(String text) {
        String[] fulltext = text.split(" ");
        return fulltext[4];
    }

    private void switchTo(String window) {
        if ("googleCalculatorWindow".equals(window)) {
            driver.switchTo().window(windowsTabsList.get(0));
        } else
            driver.switchTo().window(windowsTabsList.get(1));
    }
}
