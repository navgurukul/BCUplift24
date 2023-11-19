import birthdayDocumantation.BirthdayManager;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        BirthdayManager bm = new BirthdayManager(5);
        bm.showsStudentList();
    }
}