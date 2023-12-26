package org.uplift.demo.laptop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Laptop {
    private String laptopId;
    private String serialNumber;
    private String model;

    public Laptop(String laptopId, String serialNumber, String model) {
        this.laptopId = laptopId;
        this.serialNumber = serialNumber;
        this.model = model;
        this.laptopId = laptopId;
    }

    public String getLaptopId() {
        return laptopId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(laptopId, laptop.laptopId) && Objects.equals(serialNumber, laptop.serialNumber) && Objects.equals(model, laptop.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laptopId, serialNumber, model);
    }
}