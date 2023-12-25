package org.uplift.demo.web.laptop;

import java.util.Objects;

public class Laptop {
    private String laptopName;
    private String serialNo;
    private int number;

    public Laptop(String laptopName, String serialNo, int number) {
        this.laptopName = laptopName;
        this.serialNo = serialNo;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    public String getLaptopName() {
        return laptopName;
    }

    public String getSerialNo() {
        return serialNo;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop laptop)) return false;
        return getNumber() == laptop.getNumber()&& Objects.equals(getLaptopName(), laptop.getLaptopName()) && Objects.equals(getSerialNo(), laptop.getSerialNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLaptopName(), getSerialNo(), getNumber());
    }
}
