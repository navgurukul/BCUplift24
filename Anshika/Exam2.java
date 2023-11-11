import java.util.ArrayList;

interface Employee{
	int id;
	String name;
	String designation;

	public void setName(){
		this.name=name;
	}
	public String getName(String name){
		return name;
	}
	public void setId(){
		this.Id=Id;
	}
	public String getId(int Id){
		return id;
	}
	public void setDesignation(String Designation){
		this.Designation=designation;
	}
	public String getDesignation(String Designation){
		return Designation ;
	}

	double calculateGrossSalary(int hoursWorked){
		return hoursWorked*500;

	}
	double calculateTax(int hoursWorked){
		return hoursWorked*500*(.10);

	}
	double calculateNetSalary(int hoursWorked){
		return hoursWorked*500*(.10)-tax;
	}





}
class Manager implements Employee{
	private int hoursWorked;
	private int hoursOfOvertime;

	int taxRate=30;

	Manager(int hoursWorked,int hoursOfOvertime){
		this.hoursWorked=hoursWorked;
		this.hoursOfOvertime=hoursOfOvertime;
	}
	public int getHoursWorked(){
		return hoursWorked;
	}
	public void setHoursWorked(int hour){
		hoursWorked=hour;
	}
	public int getHoursOfOvertime(){
		return hoursOfOvertime;
	}
	public void setHoursOfOvertime(int overHour){
		hoursOfOvertime=overHour;
	}


	double calculateGrossSalary(int hoursWorked){
		return hoursWorked*500;

	}
	double calculateTax(int hoursWorked){
		return hoursWorked*500*(.10);

	}
	double calculateNetSalary(int hoursWorked){
		return hoursWorked*500*(.10)-tax;
		
	}
	public void managerInfo(){
		System.out.println("gross salary: "+calculateGrossSalary()+" tax paid: "+calculateTax()+" net salary: "+calculateNetSalary());
	}



	


}
class Supervisor implements Employee{
	private int hoursWorked;
	private int hoursOfOvertime;
			
	int taxRate=20;

	Supervisor(int hoursWorked,int hoursOfOvertime){
		this.hoursWorked=hoursWorked;
		this.hoursOfOvertime=hoursOfOvertime;
	}
	
	public int getHoursWorked(){
		return hoursWorked;
	}
	public void setHoursWorked(int hour){
		hoursWorked=hour;
	}
	/*public int getHoursOfOvertime(){
		return hoursOfOvertime;
	}
	public void setHoursOfOvertime(int overHour){
		hoursOfOvertime=overHour;
	}*/

	public void calOvertime(){
		if(hoursWorked>40){
			hoursOfOvertime=hoursWorked-40;
		}
	}
	

	double calculateGrossSalary(int hoursWorked,int hoursOfOvertime){
		return hoursWorked*300+hoursOfOvertime*450;

	}
	double calculateTax(){
		return (hoursWorked*300+hoursOfOvertime*450)*(.10);

	}
	double calculateNetSalary(){
		return ((hoursWorked*300+hoursOfOvertime*450)*(.10)-tax);
	}
	public void supervisorInfo(){
		System.out.println("gross salary: "+calculateGrossSalary()+" tax paid: "+calculateTax()+" net salary: "+calculateNetSalary());
	}





}
class Worker implements Employee{
	private int hoursWorked;
	private int hoursOfOvertime=0;


	Worker(int hoursWorked,int hoursOfOvertime){
		this.hoursWorked=hoursWorked;
		this.hoursOfOvertime=hoursOfOvertime;
	}
	
	public int getHoursWorked(){
		return hoursWorked;
	}
	public void setHoursWorked(int hour){
		hoursWorked=hour;
	}

	public void calOvertime(){
		if(hoursWorked>40){
			hoursOfOvertime=hoursWorked-40;
		}
	}
	
	/*public int getHoursOfOvertime(){
		if(hourOfOvertime>40){
			isOvertime=true;
			return 60;
		}else{
			return hoursOfOvertime;
		}
	}
	public void setHoursOfOvertime(int overHour){
		if(overHour>60){
			hoursOfOver=60;
		}else{
			hoursOfOvertime=overHour;
		}
	}*/

	double calculateGrossSalary(int hoursWorked,int hoursOfOvertime){
		return hoursWorked*200+hoursOfOvertime*300;

	}
	double calculateTax(){
		return hoursWorked*200+hoursOfOvertime*300*(.10);

	}
	double calculateNetSalary(){
		return (hoursWorked*200+hoursOfOvertime*300)*(.10)-tax;
	}

	public void workerInfo(){
		System.out.println("gross salary: "+calculateGrossSalary()+" tax paid: "+calculateTax()+" net salary: "+calculateNetSalary());
	}






}

public class Exam2{
	public static void main(String[] args){
		
		ArrayList<Employee> labourDeptViolationReportList=new ArrayList<Employee>();
		Worker w1=new Worker();
	
	}

}