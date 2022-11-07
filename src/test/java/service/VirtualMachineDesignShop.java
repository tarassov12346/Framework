package service;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.GoogleCloudPlatformPricingCalculatorPage;
import utils.CustomConditions;

import java.time.Duration;

public class VirtualMachineDesignShop {

    public GoogleCloudPlatformPricingCalculatorPage googleCloudPlatformPricingCalculatorPage =
            new GoogleCloudPlatformPricingCalculatorPage();

    public String getVmEstimatedMonthlyCostValueOnCalculator() {
        return googleCloudPlatformPricingCalculatorPage.
                getVmEstimatedMonthlyCostValueOnCalculator();
    }

    public VirtualMachineDesignShop getCalculator(String homePageUrl, String searchRequest) {
        googleCloudPlatformPricingCalculatorPage.openPage(homePageUrl).clickSearchButton().
                enterSearchRequest(searchRequest).loadCalculatorSite(searchRequest);
        return this;
    }

    public VirtualMachineDesignShop
    calculateTheVM(String formNumberOfInstance, String formOsType,
                   String formClassType,
                   String formInstanceSeries, String formInstanceType, String formGpuNumber,
                   String formGpuType, String formSsdCapacity, String formLocation, String formUsage) {

        googleCloudPlatformPricingCalculatorPage.
                waitUntilCalculatorSiteIsStable().
                fillInNumberOfInstance(formNumberOfInstance).
                fillInOperatingSystem(formOsType).
                fillInVmClass(formClassType).
                fillInSeries(formInstanceSeries).
                fillInMachineType(formInstanceType).
                fillInDataCenterLocation("Oregon (us-west1)", "to make available all GpuTypes").
                checkBoxAddGpu().
                fillInGpuType(formGpuType).
                fillInNumberOfGpu(formGpuNumber).
                fillInLocalSsd(formSsdCapacity).
                fillInDataCenterLocation(formLocation, "to input form location").
                fillInCommitedUsage(formUsage).
                addToEstimate();
        return this;
    }

    public EmailHandling sendCalculatedCostToEmail(String emailGeneratorUrl) {
        EmailHandling emailHandling = new EmailHandling();
        String generatedEmailName = emailHandling.getGeneratedEmailName(emailGeneratorUrl);
        googleCloudPlatformPricingCalculatorPage.clickEmailButton().
                inputGeneratedEmailName(generatedEmailName);
        return emailHandling;
    }

    public String getVMClassOnCalculator() {
        return googleCloudPlatformPricingCalculatorPage.getVMClass();
    }

    public String getInstanceTypeOnCalculator() {
        return googleCloudPlatformPricingCalculatorPage.getInstanceType();
    }

    public String getLocationOnCalculator() {
        return googleCloudPlatformPricingCalculatorPage.getLocation();
    }

    public String getSSDOnCalculator() {
        return googleCloudPlatformPricingCalculatorPage.getSSD();
    }

    public String getUsageOnCalculator() {
        return googleCloudPlatformPricingCalculatorPage.getUsage();
    }
}
