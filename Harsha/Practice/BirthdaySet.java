import java.util.*;
import java.time.LocalDate;

class Students implements Comparable<Students>{
	private String name;
	private LocalDate birthDate;

	Students(String name,LocalDate birthDate){

		this.name =name;
		this.birthDate = birthDate;
	}
	public String getName(){
		return name;
	}
	public LocalDate getBirthDate(){
		return birthDate;
	}

	public int compareTo(Students obj){
		
		LocalDate H = this.birthDate;
		LocalDate P = obj.getBirthDate();
		
		int diff = H.compareTo(P);
		if (diff ==0)
			return name.compareTo(obj.getName());
		return diff;

	}
	public String toString(){
		return "Happy Birhtday "+getName();
	}
}

class Registry{

	SortedSet<Students> ss = new TreeSet<>();

	SortedSet<Students> checkMonth(ArrayList<Students> studentList,int month){
		
		for (Students i: studentList ){
			if (i.getBirthDate().getMonthValue() == month)
				//addStudent(i);
				ss.add(i);
		}
		return ss;
	}
	/*void addStudent(Students student){
		ss.add(student);
	}*/
}


public class BirthdaySet{

	public static void main(String[] args){
		
		ArrayList<Students> studentList = new ArrayList<>();

		studentList.add(new Students("Harsha", LocalDate.of(2000,7,25)));
		studentList.add(new Students("Sakshi", LocalDate.of(2003,4,5)));
		studentList.add(new Students("Pratiksha", LocalDate.of(2001,2,22)));
		studentList.add(new Students("Pragati", LocalDate.of(2002,4,16)));
		studentList.add(new Students("Harshada", LocalDate.of(2001,4,5)));
		studentList.add(new Students("Rohini", LocalDate.of(2004,9,20)));

		Registry r = new Registry();
		//r.checkMonth(studentList,4);

		SortedSet<Students> set = r.checkMonth(studentList, 4);

        	for (Students i :set) {
            		System.out.println(i);
        	}
	}
}



