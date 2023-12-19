package ordermanagement;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postcode ;
    private String zone ;

    public static final String EAST = "East";
    public static final String WEST = "West";
    public static final String NORTH = "North";
    public static final String SOUTH = "South";
    public ShippingAddress(String address, String area, String city, long postcode, String zone) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
        this.zone = zone;
    }

    public String getZone(){
        return zone;
    }
    public String getCity(){
        return city;
    }
}
