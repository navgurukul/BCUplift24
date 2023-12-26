package org.uplift.demo.Repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.uplift.demo.laptop.Laptop;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LaptopRepository {
    private ArrayList<Laptop> laptopList = new ArrayList<>();

    public boolean addLaptop(Laptop laptop){
        return laptopList.add(laptop);
    }

    public Laptop findBySerialNumber(String sn){
        return  laptopList.stream().filter(s->s.getSerialNumber().equals(sn)).findFirst().orElse(null);
    }



    public boolean removeLaptop(Laptop l){
        return laptopList.remove(l);
    }

}