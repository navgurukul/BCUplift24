package birthdayDocumantation.student;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Students implements Comparable <Students>{
    private String name;
    private Date dateOfBirth;
    Students(String name, Date dob){
        this.name = name;
        this.dateOfBirth = dob;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int compareTo(Students obj){
        Calendar thisCal = Calendar.getInstance();
        thisCal.setTime(dateOfBirth);
        int thisDay = thisCal.get(Calendar.DAY_OF_MONTH);
        int thisMonth = thisCal.get(Calendar.MONTH)+1;

        Calendar otherCal = Calendar.getInstance();
        otherCal.setTime(obj.getDateOfBirth());
        int objDay = otherCal.get(Calendar.DAY_OF_MONTH);
        int objMonth = otherCal.get(Calendar.MONTH)+1;

        int mon = Integer.compare(thisMonth, objMonth);
        if(mon==0){
            int d = Integer.compare(thisDay, objDay);
            if (d==0){
                return this.name.compareTo(obj.getName());
            }
            return d;
        }
        return mon;
    }

    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Name: "+name);
        sb.append(" DOB "+ dateFormat.format(dateOfBirth));

        return sb.toString();
    }
}
