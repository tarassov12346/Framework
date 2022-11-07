package model;

import java.util.Objects;

public class VirtualMachine {

    private final String form_number_of_instance;
    private final String form_os_type;
    private final String form_class_type;
    private final String form_instance_series;
    private final String form_instance_type;
    private final String form_gpu_number;
    private final String form_gpu_type;
    private final String form_ssd_capacity;
    private final String form_location;
    private final String form_usage;

    public VirtualMachine(String form_number_of_instance,
                          String form_os_type,
                          String form_class_type,
                          String form_instance_series,
                          String form_instance_type,
                          String form_gpu_number,
                          String form_gpu_type,
                          String form_ssd_capacity,
                          String form_location,
                          String form_usage) {
        this.form_number_of_instance = form_number_of_instance;
        this.form_os_type = form_os_type;
        this.form_class_type = form_class_type;
        this.form_instance_series = form_instance_series;
        this.form_instance_type = form_instance_type;
        this.form_gpu_number = form_gpu_number;
        this.form_gpu_type = form_gpu_type;
        this.form_ssd_capacity = form_ssd_capacity;
        this.form_location = form_location;
        this.form_usage = form_usage;
    }

    public String getForm_number_of_instance() {
        return form_number_of_instance;
    }

    public String getForm_os_type() {
        return form_os_type;
    }

    public String getForm_class_type() {
        return form_class_type;
    }

    public String getForm_instance_series() {
        return form_instance_series;
    }

    public String getForm_instance_type() {
        return getDataFromText(form_instance_type);
    }

    public String getForm_gpu_number() {
        return form_gpu_number;
    }

    public String getForm_gpu_type() {
        return form_gpu_type;
    }

    public String getForm_ssd_capacity() {
        return getDataFromText(form_ssd_capacity);
    }

    public String getForm_location() {
        return getDataFromText(form_location);
    }

    public String getForm_usage() {
        return getDataFromText(form_usage);
    }

    private String getDataFromText(String text) {
        String[] fulltext = text.split(" ");
        return fulltext[0];
    }

    @Override
    public String toString() {
        return "VM{" +
                "form_number_of_instance='" + form_number_of_instance + '\'' +
                ", form_os_type='" + form_os_type + '\'' +
                ", form_class_type='" + form_class_type + '\'' +
                ", form_instance_series='" + form_instance_series + '\'' +
                ", form_instance_type='" + form_instance_type + '\'' +
                ", form_gpu_number='" + form_gpu_number + '\'' +
                ", form_gpu_type='" + form_gpu_type + '\'' +
                ", form_ssd_capacity='" + form_ssd_capacity + '\'' +
                ", form_location='" + form_location + '\'' +
                ", form_usage='" + form_usage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualMachine vm = (VirtualMachine) o;
        return Objects.equals(form_number_of_instance, vm.form_number_of_instance) &&
                Objects.equals(form_os_type, vm.form_os_type) &&
                Objects.equals(form_class_type, vm.form_class_type) &&
                Objects.equals(form_instance_series, vm.form_instance_series) &&
                Objects.equals(form_instance_type, vm.form_instance_type) &&
                Objects.equals(form_gpu_number, vm.form_gpu_number) &&
                Objects.equals(form_gpu_type, vm.form_gpu_type) &&
                Objects.equals(form_ssd_capacity, vm.form_ssd_capacity) &&
                Objects.equals(form_location, vm.form_location) &&
                Objects.equals(form_usage, vm.form_usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(form_number_of_instance,
                form_os_type,
                form_class_type,
                form_instance_series,
                form_instance_type,
                form_gpu_number,
                form_gpu_type,
                form_ssd_capacity,
                form_location,
                form_usage);
    }
}
