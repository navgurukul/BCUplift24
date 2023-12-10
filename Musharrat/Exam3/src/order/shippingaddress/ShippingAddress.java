package order.shippingaddress;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postcode;
    private String zone;

    public ShippingAddress(String address, String area, String city, long postcode) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
        this.zone = setZone();
    }

    public String getAddress() {
        return address;
    }

    private String setZone(){
        return switch (city) {
            case "Chennai", "Bangalore" -> "South";
            case "Mumbai", "Goa" -> "West";
            case "Kolkata", "Bhuvneshwar" -> "East";
            case "Delhi", "Noida" -> "North";
            default -> "No Delivery Zone";
        };
    }

    public String getZone(){
        return zone;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public long getPostcode() {
        return postcode;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                ", zone='" + zone + '\'' +
                '}';
    }
}
