package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CorrectInputTests extends CommonConditions {

    @Test(description = "compares VM Class on calculator form and the input one")
    public void isVmClassInputCorrect() {
        String vMClassInput = virtualMachine.getForm_class_type();
        String vmClassOnCalculator = vmDesigner.getVMClassOnCalculator();
        System.out.println(vMClassInput + "=========? " + vmClassOnCalculator);
        Assert.assertEquals(vMClassInput, vmClassOnCalculator,
                ": FAIL: the vm class on calculator " +
                        vmClassOnCalculator + " differs from the input one " +
                        vMClassInput);
    }

    @Test(description = "compares Instance type on calculator form and the input one")
    public void isInstanceTypeInputCorrect() {
        String instanceTypeInput = virtualMachine.getForm_instance_type();
        String instanceTypeOnCalculator = vmDesigner.getInstanceTypeOnCalculator();
        System.out.println(instanceTypeInput + "=========? " + instanceTypeOnCalculator);
        Assert.assertEquals(instanceTypeInput, instanceTypeOnCalculator, ": FAIL: the instance type on calculator " +
                instanceTypeOnCalculator + " differs from the input one " +
                instanceTypeInput);
    }

    @Test(description = "compares Location on calculator form and the input one")
    public void isLocationInputCorrect() {
        String locationInput = virtualMachine.getForm_location();
        String locationOnCalculator = vmDesigner.getLocationOnCalculator();
        System.out.println(locationInput + "=========? " + locationOnCalculator);
        Assert.assertEquals(locationInput, locationOnCalculator, ": FAIL: the location on calculator " +
                locationOnCalculator + " differs from the input one " +
                locationInput);
    }

    @Test(description = "compares SSD on calculator form and the input one")
    public void isSSDInputCorrect() {
        String ssdInput = virtualMachine.getForm_ssd_capacity();
        String ssdOnCalculator = vmDesigner.getSSDOnCalculator();
        System.out.println(ssdInput + "=========? " + ssdOnCalculator);
        Assert.assertEquals(ssdInput, ssdOnCalculator, ": FAIL: the ssd on calculator " +
                ssdOnCalculator + " differs from the input one " +
                ssdInput);
    }

    @Test(description = "compares usage on calculator form and the input one")
    public void isUsageInputCorrect() {
        String usageInput = virtualMachine.getForm_usage();
        String usageOnCalculator = vmDesigner.getUsageOnCalculator();
        System.out.println(usageInput + "=========? " + usageOnCalculator);
        Assert.assertEquals(usageInput, usageOnCalculator,
                ": FAIL: the usage on calculator " +
                        usageOnCalculator + " differs from the input one " +
                        usageInput);
    }
}
