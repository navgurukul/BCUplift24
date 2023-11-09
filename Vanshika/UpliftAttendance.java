import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;

public class UpliftAttendance{
	public static Student[] createUpliftBatch(){
	Student[] upliftBatch = {
		(new Student("Nikita" , false)),
		(new Student("Vanshika" , false)),
		(new Student("Gayatri" , false)),
		(new Student("Deepti" , false)),
		(new Student("Ruksana" , false)),
		(new Student("Sreekanya" , false)),
		(new Student("rakhi" , false)),
		(new Student("Anshika" , true)),
		(new Student("Ashwini" , true)),
		(new Student("Kashvi" , true))
		};
	return upliftBatch;	
	}
	
	public static Session[] createSessions(Student[] upliftBatch) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Student[] lateStudents1 = {upliftBatch[0], upliftBatch[1]};
		Student[] lateStudents2 = {upliftBatch[2], upliftBatch[3]};
		Student[] lateStudents3 = {upliftBatch[5], upliftBatch[6]};
		Student[] lateStudents4 = {upliftBatch[6], upliftBatch[7]};
		Student[] lateStudents5 = {upliftBatch[1], upliftBatch[2]};
		Student[] lateStudents6 = {upliftBatch[0], upliftBatch[3]};
		Student[] lateStudents7 = {upliftBatch[1], upliftBatch[5]};
		Student[] lateStudents8 = {upliftBatch[0], upliftBatch[5]};
		Student[] lateStudents9 = {upliftBatch[1], upliftBatch[6]};
		Session session1 = new Session(sdf.parse("30-10-2023 09:00:00"), lateStudents1);
		Session session2 = new Session(sdf.parse("30-10-2023 14:30:00"), lateStudents2);
		Session session3 = new Session(sdf.parse("30-10-2023 18:30:00"), lateStudents3);
		Session session4 = new Session(sdf.parse("31-10-2023 09:00:00"), lateStudents4);
		Session session5 = new Session(sdf.parse("31-10-2023 14:30:00"), lateStudents5);
		Session session6 = new Session(sdf.parse("31-10-2023 18:30:00"), lateStudents6);
		Session session7 = new Session(sdf.parse("01-11-2023 09:00:00"), lateStudents7);
		Session session8 = new Session(sdf.parse("01-11-2023 14:30:00"), lateStudents8);
		Session session9 = new Session(sdf.parse("01-11-2023 18:30:00"), lateStudents9);
		Session[] sessions = {session1, session2, session3, session4, session5, session6,session7, session8, session9};
		return sessions;
	}
	public static void main(String[] args) throws ParseException{
		Student[] upliftBatch = createUpliftBatch();
		Session[] sessions = createSessions(upliftBatch);
		AttendanceManager manager = new AttendanceManager(sessions, upliftBatch);
		LateStudent[] lateOctStudents = manager.checkLateComers(10);
		LateStudent[] lateNovStudents = manager.checkLateComers(11);
		Student[] OnTimeOctStudents = manager.checkOnTimeStudents(10);
		Student[] OnTimeNovStudents = manager.checkOnTimeStudents(11);
	}	
	

}

class Student{
	private String name;
	private boolean sick;
	
	Student(String name, boolean sick){
		this.name = name;
		this.sick = sick;
	}
	
	String getName(){
		return name;
	}
	boolean isSick(){
		return sick;
	}

}

class Session{
	private Date startTime;
	private Student[] lateStudents;
	
	Session(Date startTime, Student[] lateStudents){
		this.startTime = startTime;
		this.lateStudents = lateStudents;
	}
	
	Date getStartTime(){
		return startTime;
	}

	Student[] getLateStudents(){
		return lateStudents;
	}

}

class AttendanceManager{
	private Session[] sessions;
	private Student[] upliftBatch;

	AttendanceManager(Session[] sessions, Student[] upliftBatch){
		this.sessions = sessions;
		this.upliftBatch = upliftBatch;
	}
	private Session getSessionsOfTheMonth(int month){
		ArrayList<Session> sessionsOfTheMonth = new ArrayList<Session>();
		for (Session s: sessions){
			Date d = s.getStartTime();
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			if (month == c.get(Calendar.MONTH) + 1){
				sessionsOfTheMonth.add(s);
			}
			
		}
		return sessionsOfTheMonth.toArray();
	}
	LateStudent[] checkLateComers(int month){
	
	}
	Student[] checkOnTimeStudents(int month){
		Session[] sessions = getSessionsOfTheMonth(month);
		ArrayList<Student> onTimeStudents = new ArrayList<Student>();
		ArrayList<Student> allLateStudents = new ArrayList<Student>();
		for(Session s : sessions){
			Student[] lateStudents = s.getLateStudents(); 
			allLateStudents.addAll(lateStudents);
		}
		for (Student s: upliftBatch){
			boolean studentLate = false;
			for(Student ls: allLateStudents){
				if (ls.getName() == ls.getName() && !ls.isSick()){
				studentLate = true;
				continue;
				}
			}
			if(!studentLate){
				onTimeStudents.add(s);
			} 
		}
		return onTimeStudents.toArray();
	}
}

class LateStudent {
	private Student[] student;
	private Session[] sessions;
	
	LateStudent(Student[] student ,Session[] sessions){
		this.student = student;
		this.sessions = sessions;
	}
	
	Student[] getStudent(){	
		return student;
	}
	Session[] getSessions(){
		return sessions;
	}


}

