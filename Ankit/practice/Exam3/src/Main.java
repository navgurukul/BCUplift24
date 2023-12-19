import ordermanagement.OrderManagement;
import ordermanagement.ShippingAddress;
import ordermanagement.exception.OutOfStockException;
import ordermanagement.order.Order;
import ordermanagement.product.Beverage;
import ordermanagement.product.Book;
import ordermanagement.product.Product;


public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        Beverage beverege1 = new Beverage(1,200,20,"nimbu",500,"paperBoat");

        ShippingAddress customer1 = new ShippingAddress("h.no 37","sarjapur","Bangluru",12L, ShippingAddress.SOUTH);
        ShippingAddress customer2 = new ShippingAddress("h.no 85","azadpur","Delhi",10L, ShippingAddress.NORTH);

        Order first = new Order(1L,customer1);
        Order second = new Order(1L,customer2);

        first.addProductToInventory(book1,10);
        second.addProductToInventory(beverege1,4);


        addProductToOrder(first,book1,18);
        addProductToOrder(second,beverege1,4);
        System.out.println(second.getPrice());


        OrderManagement orderManagement = new OrderManagement();

        orderManagement.placeOrder(first);
        orderManagement.placeOrder(second);


        System.out.println(orderManagement.getOrders());
        System.out.println(orderManagement.getUniqueShippedCities());


    }
    public static void addProductToOrder(Order order, Product product,int qty){
        try{
            order.addProduct(product,qty);
        }
        catch (OutOfStockException e){
            System.out.println(e.getMessage());
        }
    }
}