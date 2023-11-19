package org.uplift.birthday;
import java.util.Date;


public class Students implements Comparable<Students> {
    private final String name;
    private final Date dateOfBirth;

    public Students(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public int compareTo(Students otherStudent) {
        int dateComparison = this.dateOfBirth.compareTo(otherStudent.dateOfBirth);

        if (dateComparison == 0) {
            return this.name.compareTo(otherStudent.name);
        }

        return dateComparison;
    }

    public String toString() {
        return "Happy Birthday " +
                name;
    }
}
