package org.exam3;
//package org.exam3;
import java.util.HashSet;
import java.util.Set;

//public class Order {
//}

//-id:long
//-items:List<Orderitems

//+addProduct(product):void
//+getSHippingAddress
//+getitems():List<OrderItems>
//getPrice():duble

class Order {
    Product product;
    int quantity;
    String shippingAddress;

    public Order(Product product, int quantity, String shippingAddress) {
        this.product = product;
        this.quantity = quantity;
        this.shippingAddress = shippingAddress;
    }

    public double calculateFinalCost() {
        double discount = product.discount;
        double productPrice = product.price;
        double shippingCost = calculateShippingCost();
        return (productPrice - discount) * quantity + shippingCost;
    }

    public double calculateShippingCost() {
        String[] southZoneCities = {"Chennai", "Bangalore"};
        String[] westZoneCities = {"Mumbai", "Goa"};
        String[] eastZoneCities = {"Kolkata", "Bhubaneshwar"};
        String[] northZoneCities = {"Delhi", "Noida"};

        double shippingCost = 5.0;

        if (contains(southZoneCities, shippingAddress)) {
            shippingCost = 5.0;
        } else if (contains(westZoneCities, shippingAddress)) {
            shippingCost = 7.0;
        } else if (contains(eastZoneCities, shippingAddress)) {
            shippingCost = 8.0;
        } else if (contains(northZoneCities, shippingAddress)) {
            shippingCost = 10.0;
        }

        return shippingCost;
    }

    private boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
