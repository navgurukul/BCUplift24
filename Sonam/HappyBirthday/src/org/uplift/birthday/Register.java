package org.uplift.birthday;
import java.util.*;

public class Register {
    private final ArrayList<Students> totalStudents = new ArrayList<>();
    private final SortedSet<Students> birthdayStudents = new TreeSet<>();

    public void addStudents(Students s) {
        totalStudents.add(s);
    }

    public void check(int targetMonth) {
        for (Students student : totalStudents) {
            Calendar cal = Calendar.getInstance();

            cal.setTime(student.getDateOfBirth());

            int birthMonth = cal.get(Calendar.MONTH) + 1;
            if (birthMonth == targetMonth) {
                birthdayStudents.add(student);
            }
        }
    }

    public void printBirthdayWishes() {
        for (Students student : birthdayStudents) {
            System.out.println(student);
        }
    }
}
