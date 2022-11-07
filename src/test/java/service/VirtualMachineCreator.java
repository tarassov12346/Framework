package service;

import model.VirtualMachine;

public class VirtualMachineCreator {

    private static final String FORM_NUMBER_OF_INSTANCE = "form.number.of.instance";
    private static final String FORM_OS_TYPE = "form.os.type";
    private static final String FORM_CLASS_TYPE = "form.class.type";
    private static final String FORM_INSTANCE_SERIES = "form.instance.series";
    private static final String FORM_INSTANCE_TYPE = "form.instance.type";
    private static final String FORM_GPU_NUMBER = "form.gpu.number";
    private static final String FORM_GPU_TYPE = "form.gpu.type";
    private static final String FORM_SSD_CAPACITY = "form.ssd.capacity";
    private static final String FORM_LOCATION = "form.location";
    private static final String FORM_USAGE = "form.usage";

    public static VirtualMachine getVMFromProperty() {
        return new VirtualMachine(VirtualMachineReader.getVMData(FORM_NUMBER_OF_INSTANCE),
                VirtualMachineReader.getVMData(FORM_OS_TYPE),
                VirtualMachineReader.getVMData(FORM_CLASS_TYPE),
                VirtualMachineReader.getVMData(FORM_INSTANCE_SERIES),
                VirtualMachineReader.getVMData(FORM_INSTANCE_TYPE),
                VirtualMachineReader.getVMData(FORM_GPU_NUMBER),
                VirtualMachineReader.getVMData(FORM_GPU_TYPE),
                VirtualMachineReader.getVMData(FORM_SSD_CAPACITY),
                VirtualMachineReader.getVMData(FORM_LOCATION),
                VirtualMachineReader.getVMData(FORM_USAGE));
    }
}
