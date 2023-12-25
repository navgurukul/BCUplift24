package org.uplift.demo.web.Repositery;

import org.springframework.stereotype.Repository;
import org.uplift.demo.web.laptop.Laptop;

import java.util.ArrayList;

@Repository
public class LaptopRepository {

    public ArrayList<Laptop> laptops = new ArrayList<>();

    public boolean addLaptop(Laptop laptop){
        return laptops.add(laptop);
    }

    public Laptop findLaptop(String id){
        return laptops.stream().filter(laptop -> laptop.getSerialNo().equals(id))
                .findFirst().orElse(null);
    }

    public boolean removeLaptop(Laptop laptop){
        return laptops.remove(laptop);
    }

//    public boolean update(Laptop updateLaptop){
//        Laptop l = findLaptop(updateLaptop.getSerialNo());
//        if (l==null) return false;
//        removeLaptop(l);
//        addLaptop(updateLaptop);
//        return true;
//    }
}
