package birthdayDocumantation.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentList {
    public Students[] addStudents() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return new Students[]{
                new Students("Mahi", sdf.parse("29-05-2002")),
                new Students("Ziya", sdf.parse("16-11-2000")),
                new Students("Kaya", sdf.parse("15-05-2001")),
                new Students("Eram", sdf.parse("26-05-2004")),
                new Students("Sana", sdf.parse("29-05-2002")),
                new Students("Sana", sdf.parse("18-05-2000")),
                new Students("Divya", sdf.parse("10-11-2004")),
                new Students("Monika", sdf.parse("10-11-2003")),
                new Students("Shalini", sdf.parse("12-05-2002")),
                new Students("Khushi", sdf.parse("29-05-2022"))
        };
    }
}
