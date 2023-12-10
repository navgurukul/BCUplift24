import OnlineShopping.*;

public class Main {
    public static void main(String[] args) {
        // dont forget to do test

        OrderManagement om= new OrderManagement();

        Order o1= new Order(1);
        Order o2= new Order(2);

        Book b1= new Book("11",50.0,5,"Wings of fire","APJ abdul kalam","autobiography");
        Book b2= new Book("12",100.0,10,"HArry potter","HArry potter","biography");
        Book b3= new Book("13",150.0,10,"Ramayan"," narayan murti","epic");
        Book b4= new Book("14",200.0,15,"Mahabharat","prashant naik","fiction");

        Beverage br1= new Beverage("21",100.0,5,"cool",1000,"nimbu");
        Beverage br2= new Beverage("21",100.0,10,"hot",2000,"orange");
        Beverage br3= new Beverage("21",100.0,5,"softdrink",3000,"mango");
        Beverage br4= new Beverage("21",100.0,5,"soda",4000,"banana");


        System.out.println("product descroption of books is :");
        System.out.println(b1.getProductDescription());
        System.out.println(b2.getProductDescription());
        System.out.println(b3.getProductDescription());
        System.out.println(b4.getProductDescription());

        System.out.println("discoutnt on books are: ");
        System.out.println(b1.getDiscountApplied());
        System.out.println(b2.getDiscountApplied());
        System.out.println(b3.getDiscountApplied());
        System.out.println(b4.getDiscountApplied());

        System.out.println("net price of books are :");
        System.out.println(b1.getNetPrice());
        System.out.println(b2.getNetPrice());
        System.out.println(b3.getNetPrice());
        System.out.println(b4.getNetPrice());

        System.out.println("beverages are :");
        System.out.println(br1.getProductDescription());
        System.out.println(br2.getProductDescription());
        System.out.println(br3.getProductDescription());
        System.out.println(br4.getProductDescription());

        System.out.println("discoutnt on beverages  are: ");
        System.out.println(br1.getDiscountApplied());
        System.out.println(br2.getDiscountApplied());
        System.out.println(br3.getDiscountApplied());
        System.out.println(br4.getDiscountApplied());

        System.out.println("net price of beverages  are :");
        System.out.println(br1.getNetPrice());
        System.out.println(br2.getNetPrice());
        System.out.println(br3.getNetPrice());
        System.out.println(br4.getNetPrice());


        ShippingAddress sp1= new ShippingAddress("new Delhi","near temple","delhi",444890,"East");
        ShippingAddress sp2= new ShippingAddress("new Daryapur","near scholl","dp",4567890,"west");
        ShippingAddress sp3= new ShippingAddress("new amravati","near hospital","amt",456644890,"north");
        ShippingAddress sp4= new ShippingAddress("new mumbai","near  hotel","bombay",4443330,"south");


//        System.out.println(om.addToCityZoneMap(sp1));
//        System.out.println(om.addToCityZoneMap(sp2));
//        System.out.println(om.addToCityZoneMap(sp3));


        System.out.println("unique cities are : ");
        System.out.println(om.addTouniqueShippedCitites(sp1));
        System.out.println(om.addTouniqueShippedCitites(sp2));
        System.out.println(om.addTouniqueShippedCitites(sp3));
        System.out.println(om.addTouniqueShippedCitites(sp4));



        OrderItems i1= new OrderItems(b1,5);
        OrderItems i2= new OrderItems(b2,5);
        OrderItems i3= new OrderItems(b3,5);
        OrderItems i4= new OrderItems(b4,5);
        OrderItems i5= new OrderItems(br1,5);




//        System.out.println(om.getShippingAddress(sp1





//        System.out.println(om.addTouniqueShippedCitites(sp2.getCity()));
//        System.out.println(om.addTouniqueShippedCitites(););














    }
}