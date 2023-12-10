import system.management.order.*;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Map<String,String> cityZoneMap =new HashMap<>();
        CityZoneMap c=new CityZoneMap(cityZoneMap);


        cityZoneMap.put("Chennai","south zone");
        cityZoneMap.put("Bangalore","south zone");
        cityZoneMap.put("Mumbai","west zone");
        cityZoneMap.put("goa","west zone");
        cityZoneMap.put("Kolkatta","east zone");
        cityZoneMap.put("Bhuvaneshwar","east zone");
        cityZoneMap.put("Delhi","North Zone");
        cityZoneMap.put("Noida"," North Zone");;




        Map<String ,Integer>mapOfZoneShippingCharges=new HashMap<>();
        ZoneShippingCharges zoneShippingCharges=new ZoneShippingCharges(mapOfZoneShippingCharges);

        mapOfZoneShippingCharges.put("south zone",10);
        mapOfZoneShippingCharges.put("west zone",20);
        mapOfZoneShippingCharges.put("east zone",15);
        mapOfZoneShippingCharges.put("North Zone",25);


        Book book1=new Book("Tech","Umang Doctor","Tech",100);
        Book book2=new Book("Banking","Aditya","Banking",200);
        Beverage beverage1=new Beverage("ABC",25,"frutes",1,200);
        Beverage beverage2=new Beverage("XYZ",30,"Chocolet",2,200);

        Book book3 = new Book("Fiction", "John Smith", "Fantastic Fiction", 150);
        Book book4 = new Book("Science", "Alice Johnson", "Science Publications", 120);
        Book book5 = new Book("History", "Michael Brown", "Historical Press", 90);
        Beverage beverage3 = new Beverage("PQR", 20, "juice", 3, 180);
        Beverage beverage4 = new Beverage("LMN", 35, "tea", 4, 100);
        Beverage beverage5 = new Beverage("DEF", 28, "coffee", 5, 120);
        Beverage beverage6 = new Beverage("GHI", 22, "energy drink", 6, 190);
        Beverage beverage7 = new Beverage("JKL", 18, "water", 7, 50);
        Beverage beverage8 = new Beverage("MNO", 27, "smoothie", 8, 210);
        Beverage beverage9 = new Beverage("RST", 32, "lemonade", 9, 175);


// 1st Order Items
        ShippingAddress shippingAddress1=new ShippingAddress("xxxxxxxx","yyy","Kolkatta",1005,c);
        OrderItems orderItems=new OrderItems(book1,4);
        OrderItems orderItems1=new OrderItems(book2,4);
        OrderItems orderItems2=new OrderItems(beverage1,5);
        OrderItems orderItems3=new OrderItems(beverage2,1);


        ArrayList<OrderItems>items1=new ArrayList<>();
        Order order1=new Order(12345,items1,shippingAddress1,zoneShippingCharges);
        order1.addProduct(orderItems);
        order1.addProduct(orderItems1);
        order1.addProduct(orderItems2);
        order1.addProduct(orderItems3);
        order1.getItems();
        System.out.println(order1.getPrice());

//
////
////2nd Order Items
//        ShippingAddress shippingAddress2=new ShippingAddress("xxxxxxxx","yyy","Goa",12345,c);
//        OrderItems orderItems4=new OrderItems(book1,4);
//        OrderItems orderItems5=new OrderItems(book3,8);
//        OrderItems orderItems6=new OrderItems(beverage3,6);
//        OrderItems orderItems7=new OrderItems(beverage4,1);
//
//        ArrayList<OrderItems>items2=new ArrayList<>();
//        Order order2=new Order(1001,items2,shippingAddress2,zoneShippingCharges);
//        order2.addProduct(orderItems4);
//        order2.addProduct(orderItems5);
//        order2.addProduct(orderItems6);
//        order2.addProduct(orderItems7);
//        order2.getItems();
//        System.out.println(order2.getPrice());
////3rd Order  Items
//
//        ShippingAddress shippingAddress3=new ShippingAddress("xxxxxxxx","yyy","Goa",12345,c);
//
//        OrderItems orderItems8=new OrderItems(book4,8);
//        OrderItems orderItems9=new OrderItems(book5,3);
//        OrderItems orderItems10=new OrderItems(beverage5,6);
//        OrderItems orderItems11=new OrderItems(beverage6,1);
//        OrderItems orderItems12=new OrderItems(beverage7,2);
//        OrderItems orderItems13=new OrderItems(beverage8,7);
//        OrderItems orderItems14=new OrderItems(beverage9,3);
//
//        ArrayList<OrderItems>items3=new ArrayList<>();
//        Order order3=new Order(1001,items3,shippingAddress3,zoneShippingCharges);
//        order3.addProduct(orderItems8);
//        order3.addProduct(orderItems9);
//        order3.addProduct(orderItems10);
//        order3.addProduct(orderItems11);
//        order3.addProduct(orderItems12);
//        order3.addProduct(orderItems13);
//        order3.addProduct(orderItems14);
//        order3.getItems();
//        System.out.println(order3.getPrice());
//
//    //List of Orders
//
////
    ArrayList<Order> orders=new ArrayList<>();
    orders.add(order1);
        System.out.println(orders);
    //Set of Cities
        Set<String> cities=new HashSet<>();
    OrderManagement orderManagement=new OrderManagement(orders,cities);
        orderManagement.getOrders();
        System.out.println(orderManagement.getUniqueShippedCities());
//

    }
}