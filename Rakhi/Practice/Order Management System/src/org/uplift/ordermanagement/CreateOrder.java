package org.uplift.ordermanagement;

import java.util.ArrayList;

public class CreateOrder {
    public Order createBookOrder() {
        ArrayList<OrderItems> orderItemsList=new ArrayList<>();
        Product b1 = new Book("Harry", "JK Rowling", "Fiction", 500);
        OrderItems ordItem1=new OrderItems(b1,1);
        orderItemsList.add(ordItem1);
        Product b2 = new Book("Harry2", "JK Rowling", "Fiction", 600);
        OrderItems ordItem2=new OrderItems(b2,3);
        orderItemsList.add(ordItem1);
        Product b3 = new Book("Goodan", "Munshi Premchand", "Non-Fiction", 500);
        OrderItems ordItem3=new OrderItems(b3,1);
        orderItemsList.add(ordItem1);
        Product b4 = new Book("Shrimadh Bhagvath Geeta", "Ved Vyas", "Spritiual", 500);
        OrderItems ordItem4=new OrderItems(b4,3);
        orderItemsList.add(ordItem1);

        ShippingAddress sa2=new ShippingAddress("Street 8,house 3677","Gandhi Nagar","Bengaluru",10009,"S");
        Order order1=new Order("ord1",orderItemsList,sa2);

        return order1;
    }
    public Order createBeverageOrder(){
        ArrayList<OrderItems> orderItemList=new ArrayList<>();
        Product d1 = new Beverage("LimeJuice", 1000, "Lemon", 200);
        OrderItems ordItem5=new OrderItems(d1,1);
        orderItemList.add(ordItem5);
        Product d2 = new Beverage("IceTea", 1000, "Sweet", 200);
        OrderItems ordItem6=new OrderItems(d2,2);
        orderItemList.add(ordItem6);
        Product d3 = new Beverage("IceCream", 1000, "Chocolate", 300);
        OrderItems ordItem7=new OrderItems(d3,3);
        orderItemList.add(ordItem7);
        Product d4 = new Beverage("Soda", 1000, "Lemon", 150);
        OrderItems ordItem8=new OrderItems(d4,4);
        orderItemList.add(ordItem8);

        ShippingAddress sa1=new ShippingAddress("Street 3,house 377","Shanti Nagar","Delhi",11009,"N");
        Order order2=new Order("ord2",orderItemList,sa1);

        return order2;
    }





}
