package org.example.laptop;

import org.springframework.stereotype.Component;

@Component
public class Lenovo implements Laptop {
//    int laptopId;
//
//    public Lenovo(int laptopId) {
//        this.laptopId = laptopId;
//    }

  public void config(){
      System.out.println("8gb ram for anshika");
  }
}
