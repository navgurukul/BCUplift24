package org.management;
public class Order {
    public Product product;
    private String shippingAddress;
    public Order(Product product, String shippingAddress) {
        this.product = product;
        this.shippingAddress = shippingAddress;
    }
    public double calculateOrderCost() {
        double discount = (product instanceof Book) ? 0.1 : 0.2;
        double shippingCost = calculateShippingCost();
        return product.calculateCost(discount, shippingCost);
    }
    private double calculateShippingCost() {
        String[] southZones = {"Chennai", "Bangalore"};
        String[] westZones = {"Mumbai", "Goa"};
        String[] eastZones = {"Kolkata", "Bhubaneshwar"};
        String[] northZones = {"Delhi", "Noida"};

        if (containsIgnoreCase(southZones, shippingAddress)) {
            return 10.0;
        } else if (containsIgnoreCase(westZones, shippingAddress)) {
            return 15.0;
        } else if (containsIgnoreCase(eastZones, shippingAddress)) {
            return 12.0;
        } else if (containsIgnoreCase(northZones, shippingAddress)) {
            return 18.0;
        }

        return 20.0;
    }
    private boolean containsIgnoreCase(String[] array, String value) {
        for (String str : array) {
            if (str.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
    public String getShippingCity() {
        return shippingAddress;
    }
}