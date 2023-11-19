import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Customer {
    private String name;
    private Date date;
    int aadharNumber;
    int PANNumber;
    private Map<String, Integer> arrayOfAssets;
    private Map<String, Integer> arrayOfLiability;
    Identity identity;

    Customer(String name, Date date, Map<String, Integer> arrayOfAssets, Map<String, Integer> arrayOfLiability,int PANNumber,int aadharNumber) {
        this.name = name;
        this.date = date;
        this.arrayOfAssets = arrayOfAssets;
        this.arrayOfLiability = arrayOfLiability;
        this.aadharNumber = aadharNumber;
        this.PANNumber = PANNumber;
        this.identity = new Identity(aadharNumber, PANNumber);
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Map<String, Integer> getArrayOfAssets() {
        return arrayOfAssets;
    }

    public Map<String, Integer> getArrayOfLiability() {
        return arrayOfLiability;
    }

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append(", ");
        sb.append("Date of joining: ").append(formattedDate).append(", ");
        sb.append("Identity: ").append(identity).append(", ");
        sb.append("Assets: ").append(arrayOfAssets).append(", ");
        sb.append("Liabilities: ").append(arrayOfLiability);
        return sb.toString();
    }
}