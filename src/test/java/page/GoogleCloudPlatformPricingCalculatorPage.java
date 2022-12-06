package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage {


    private static final String OS_BOX_NAME = "Operating System / Software";
    private static final String VM_BOX_NAME = "Provisioning model";
    private static final String SERIES_BOX_NAME = "Series";
    private static final String MACHINE_TYPE_BOX_NAME = "Machine type";
    private static final String GPU_TYPE_BOX_NAME = "GPU type";
    private static final String NUMBER_OF_GPUS_BOX_NAME = "Number of GPUs";
    private static final String LOCAL_SSD_BOX_NAME = "Local SSD";
    private static final String DATA_CENTER_LOCATION_BOX_NAME = "Datacenter location";
    private static final String COMMITED_USAGE_BOX_NAME = "Committed usage";
    private final String OPTION_BOX_NAME_SELECT = "*//label[text()='%s']/../md-select";
    private final String EMAIL_OPTION_BOX_NAME_SELECT = "//input[@ng-model='%s']";
    private final long TIME_OUT = 40;


    private final String MENU_CONTAINER_SELECT = "*//*[@class='md-select-menu-container md-active md-clickable']//.//*[contains(text(),'%s')]";
    private final String MENU_CONTAINER_REGION_SELECT = "*//*[@class='md-select-menu-container cpc-region-select md-active md-clickable']//.//*[contains(text(),'%s')]";


    @FindBy(xpath = "//*[@class='devsite-search-field devsite-search-query']")
    private WebElement searchButton;
    @FindBy(xpath = "//*[@class='gsc-results gsc-webResult']")
    private WebElement searchResultField;
    @FindBy(xpath = "//md-input-container//label[contains(text(),'Number of instances')]/../input")
    //@FindBy(xpath = "//*[@id='input_90']")
    private WebElement inputFieldNumberOfInstances;
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']//*[@class='md-container md-ink-ripple']")
    private WebElement checkBoxAddGPUs;
    @FindBy(xpath = "//*[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement buttonAddToEstimate;
    @FindBy(xpath = "//b[@class='ng-binding']")
    private WebElement costTextOnCalculator;
    //@FindBy(id = "email_quote")
    @FindBy(id = "Email Estimate")
    private WebElement buttonEmailEstimate;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputFieldEmail;
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;
    @FindBy(xpath = "//div[contains(text(),'Provisioning model:')]")
    private WebElement vMClass;
    @FindBy(xpath = "//div[contains(text(),'Instance type:')]")
    private WebElement instanceType;
    @FindBy(xpath = "//div[contains(text(),'Region:')]")
    private WebElement location;
    @FindBy(xpath = "//div[contains(text(),'Local SSD:')]")
    private WebElement ssd;
    @FindBy(xpath = "//div[contains(text(),'Commitment term:')]")
    private WebElement usage;

    @Override
    public GoogleCloudPlatformPricingCalculatorPage openPage(String homePageUrl) {
        driver.manage().window().maximize();
        driver.get(homePageUrl);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickSearchButton() {
        waitForElementVisibility(searchButton, TIME_OUT);
        searchButton.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage enterSearchRequest(String searchRequest) {
        searchButton.sendKeys(searchRequest);
        searchButton.sendKeys(Keys.RETURN);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage loadCalculatorSite(String searchRequest) {
        waitForElementVisibility(searchResultField, TIME_OUT);
        searchResultField.findElement(By.linkText(searchRequest)).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage waitUntilCalculatorSiteIsStable() {
        long waitTime = System.currentTimeMillis() + 10000;
        long nowTime = System.currentTimeMillis();
        while (nowTime < waitTime) {
            nowTime = System.currentTimeMillis();
        }
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillInNumberOfInstance(String formNumberOfInstance) {
        switchToFrames();
        inputFieldHandling(inputFieldNumberOfInstances, formNumberOfInstance);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillInOperatingSystem(String formOsType) {
        spanOptionHandling(OS_BOX_NAME, formOsType);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillInVmClass(String formClassType) {
        spanOptionHandling(VM_BOX_NAME, formClassType);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillInSeries(String formInstanceSeries) {
        scrollUpTheBox(OPTION_BOX_NAME_SELECT, "Operating System / Software");
        spanOptionHandling(SERIES_BOX_NAME, formInstanceSeries);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillInMachineType(String formInstanceType) {
        spanOptionHandling(MACHINE_TYPE_BOX_NAME, formInstanceType);
        scrollUpTheBox(OPTION_BOX_NAME_SELECT, "Machine type");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage checkBoxAddGpu() {
        checkBoxHandling(checkBoxAddGPUs);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillInGpuType(String formGpuType) {
        spanOptionHandling(GPU_TYPE_BOX_NAME, formGpuType);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillInNumberOfGpu(String formGpuNumber) {
        spanOptionHandling(NUMBER_OF_GPUS_BOX_NAME, formGpuNumber);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillInLocalSsd(String formSsdCapacity) {
        spanOptionHandling(LOCAL_SSD_BOX_NAME, formSsdCapacity);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillInDataCenterLocation(String formLocation, String purpose) {
        datacenterLocationSpanOptionHandling(DATA_CENTER_LOCATION_BOX_NAME, formLocation);
        if (purpose.equals("to input form location")) {
            scrollUpTheBox(OPTION_BOX_NAME_SELECT, "Local SSD");
        }
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage fillInCommitedUsage(String formUsage) {
        spanOptionHandling(COMMITED_USAGE_BOX_NAME, formUsage);
        return this;
    }

    private void inputFieldHandling(WebElement inputField, String value) {
        waitForElementVisibility(inputField, TIME_OUT);
        inputField.sendKeys(value);
    }

    private void waitForElementVisibility(WebElement element, long secondsToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(secondsToWait)).
                until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForPresenceOfElement(String elementPath, long secondsToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(secondsToWait)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementPath)));
    }

    private void spanOptionHandling(String optionBoxName, String optionName) {
        waitForPresenceOfElement(String.format(OPTION_BOX_NAME_SELECT, optionBoxName), TIME_OUT);
        elementClick(String.format(OPTION_BOX_NAME_SELECT, optionBoxName));
        waitForPresenceOfElement(String.format(MENU_CONTAINER_SELECT, optionName), TIME_OUT);
        elementClick(String.format(MENU_CONTAINER_SELECT, optionName));
    }

    private void scrollUpTheBox(String selectBoxPath, String boxName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.xpath(String.format(selectBoxPath, boxName))));
    }

    private void checkBoxHandling(WebElement checkBoxField) {
        waitForElementVisibility(checkBoxField, TIME_OUT);
        checkBoxField.click();
    }

    private void datacenterLocationSpanOptionHandling(String optionBoxName, String optionName) {
        waitForPresenceOfElement(String.format(OPTION_BOX_NAME_SELECT, optionBoxName), TIME_OUT);
        elementClick(String.format(OPTION_BOX_NAME_SELECT, optionBoxName));
        waitForPresenceOfElement(String.format(MENU_CONTAINER_REGION_SELECT, optionName), TIME_OUT);
        elementClick(String.format(MENU_CONTAINER_REGION_SELECT, optionName));
    }

    private void elementClick(String elementLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(By.xpath(elementLocator)));
    }

    private void elementClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public GoogleCloudPlatformPricingCalculatorPage addToEstimate() {
        buttonAddToEstimate.click();
        return this;
    }

    public String getVmEstimatedMonthlyCostValueOnCalculator() {
        switchToFrames();
        return getCostFromText(costTextOnCalculator.getText());
    }

    public GoogleCloudPlatformPricingCalculatorPage clickEmailButton() {
        switchToFrames();
        waitForElementVisibility(buttonEmailEstimate, TIME_OUT);
        //      buttonEmailEstimate.click();
        elementClick(buttonEmailEstimate);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage inputGeneratedEmailName(String generatedEmailName) {
        scrollUpTheBox(EMAIL_OPTION_BOX_NAME_SELECT, "emailQuote.user.firstname");
        waitForElementVisibility(inputFieldEmail, TIME_OUT);
        inputFieldEmail.sendKeys(generatedEmailName);
       // buttonSendEmail.click();
        elementClick(buttonSendEmail);
        return this;
    }

    private String getCostFromText(String text) {
        String[] fulltext = text.split(" ");
        return fulltext[4];
    }

    private void switchToFrames() {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='myFrame']")));
    }

    public String getVMClass() {
        return getVMClassSSDFromText(vMClass.getText());
    }

    public String getSSD() {
        return getVMClassSSDFromText(ssd.getText());
    }

    private String getVMClassSSDFromText(String text) {
        String[] fulltext = text.split(" ");
        return fulltext[2];
    }

    public String getInstanceType() {
        return getInstanceFromText(instanceType.getText());
    }

    private String getInstanceFromText(String text) {
        String[] fulltext = text.split(" ");
        String[] semitext = fulltext[2].split("\n");
        return semitext[0];
    }

    public String getLocation() {
        return getLocationFromText(location.getText());
    }

    private String getLocationFromText(String text) {
        String[] fulltext = text.split(" ");
        return fulltext[1];
    }

    public String getUsage() {
        return getVMClassSSDFromText(usage.getText());
    }
}
