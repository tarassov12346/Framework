package test;

import driver.DriverSingleton;
import model.VirtualMachine;
import org.testng.annotations.*;
import service.VirtualMachineCreator;
import service.VirtualMachineDesignShop;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected static final String HOMEPAGE_URL = "https://cloud.google.com/";
    protected static final String SEARCH_REQUEST = "Google Cloud Pricing Calculator";
    protected static final String EMAIL_GENERATOR_URL = "https://yopmail.com/";
    VirtualMachine virtualMachine = VirtualMachineCreator.getVMFromProperty();
    VirtualMachineDesignShop vmDesigner = calculateVmEstimatedCostValues();

    private VirtualMachineDesignShop calculateVmEstimatedCostValues() {
        return new VirtualMachineDesignShop().getCalculator(HOMEPAGE_URL, SEARCH_REQUEST).
                calculateTheVM(virtualMachine.getForm_number_of_instance(),
                        virtualMachine.getForm_os_type(), virtualMachine.getForm_class_type(),
                        virtualMachine.getForm_instance_series(), virtualMachine.getForm_instance_type(),
                        virtualMachine.getForm_gpu_number(), virtualMachine.getForm_gpu_type(),
                        virtualMachine.getForm_ssd_capacity(), virtualMachine.getForm_location(),
                        virtualMachine.getForm_usage());
    }

    @AfterTest(description = "closes the browser")
    public void afterTestCompleted() {
        DriverSingleton.closeDriver();
    }
}
