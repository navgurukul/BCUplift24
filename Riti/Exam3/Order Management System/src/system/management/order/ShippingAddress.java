package system.management.order;

public class ShippingAddress{
    private  String address;
    private String area;
    private String city;
    private  long postcode;
    CityZoneMap cityZoneMap;

    public ShippingAddress(String address, String area, String city, long postcode,CityZoneMap cityZoneMap) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
        this.cityZoneMap=cityZoneMap;
    }

    public String getAddress() {
        return address;
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

//    public static String getZone() {
//        return zone;
//    }
    public  String getZone(){
        return cityZoneMap.getCityZoneMap().get(city);

    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                '}';
    }
}
