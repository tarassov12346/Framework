package service;

import java.util.ResourceBundle;

public class VirtualMachineReader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getVMData(String key) {
        return resourceBundle.getString(key);
    }
}
