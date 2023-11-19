package org.birthday;

import java.util.Calendar;
import java.util.Date;

public class Student implements Comparable<Student>{
    private String name;
    private Date date;

    public Student(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public int getBirthMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    public int getBirthDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }


    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
