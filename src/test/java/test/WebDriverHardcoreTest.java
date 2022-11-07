package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverHardcoreTest extends CommonConditions {

    @Test(description = "compares VM Total Estimated Monthly Cost values on Calculator and in Email")
    public void areTotalEstimatedMonthlyCostValuesOnCalculatorAndInEmailEqual() {

        String vmTotalEstimatedMonthlyCostValueInEmail = vmDesigner.sendCalculatedCostToEmail(EMAIL_GENERATOR_URL).
                checkEmail().getVmEstimatedMonthlyCostValueInEmail();
        String vmTotalEstimatedMonthlyCostValueOnCalculator = vmDesigner.getVmEstimatedMonthlyCostValueOnCalculator();
        Assert.assertEquals(vmTotalEstimatedMonthlyCostValueOnCalculator, vmTotalEstimatedMonthlyCostValueInEmail,
                ": FAIL: the estimated cost on calculator " +
                        vmTotalEstimatedMonthlyCostValueOnCalculator + " differs from that in Email " +
                        vmTotalEstimatedMonthlyCostValueInEmail);
    }
}
