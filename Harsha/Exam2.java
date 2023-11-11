interface Employee{
	private String employeeId;
	private String name;
	ArrayList<String> labourDeptViolationReport;

	
	double calculeteGrossSalary();
	double calculateNetSalary();
	double calculateTax();
}


class Manager implements Employee{
	
	private String employeeId;
	private String name;
	private int workingHours;
	
	Manager (String employeeId,String name,int workingHours){
		this.employeeId=employeeId;
		this.name= name;
		int workingHours=workingHours;
	}
	public String getName(){
		return name;
	}
	public String employeeId(){
		return employeeId;
	}
	
	public int getWorkingHours(){
		return workinghours;
	}


	public double calculateGrossSalary(){
		if (workingHours <=60){
			if (workingHours <=40){
				double grossSalary= workingHour*500;
			}
			else{
				double grossSalary=40*500;
			}
			return  grossSalary;
		}
		double grossSalary= 40*500;
		return grossSalary;
		labourDeptViolationReport.add(getName());

		
	}
	public double calculateTax(){
		
			return calculateGrossSalary()*.30;
	}

	public double calculateNetSalary(){
		return calculateGrossSalary()-calculateTax();
		
	}
	
}

class Supervisor implements Employee{
	
	private String employeeId;
	private String name;
	int workingHours=workingHours;

	Supervisor (String employeeId,String name,int workingHours){
		this.employeeId=employeeId;
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public String employeeId(){
		return employeeId;
	}
	
	public int getWorkingHours(){
		return workinghours;
	}
	public double calculateGrossSalary(){
		if (workingHours <=60){

			if (workingHours <= 40)
				double grossSalary= workingHours*300;
			else{
				int overtimeHours=workingHours - 40;
				double grossSalary= 40*300 + overtimeHours*450;
			}
			return grossSalary;
		}
		else {
			grossSalary = 40*300+ 20*450;
			return grossSalary;
			labourDeptViolationReport.add(getName());
		
	}

	public double calculateNetSalary(){
		return calculateGrossSalary()-.20;

	}
	public double calculateTax(){
		return calculateGrossSalary()- calculateNetSalary();
	}
}

class Worker implements Employee{

	private String emploeeId;
	private String name;
	private int ratePerHour;
	private int workingHours;
	Supervisor( String employeeId,String name,int workingHours){
		this.employeeId=employeeId;
		this.name=name;
		this.workingHours= workingHours;
	}
	public String getName(){
		return name;
	}
	public String employeeId(){
		return employeeId;
	}
	
	
	pulbic int getWorkingHours(){
		return workinghours;
	}
	public double calculateGrossSalary(){

		if (workingHours <=60){

			if (workingHours <= 40)
				double grossSalary= workingHours*200;
			else{
				int overtimeHours=workingHours - 40;
				double grossSalary= workingHours*200 + overtimeHours*300;
			}
			return grossSalary;
		}
		else {
			double grossSalary= 40*200+20*300;
			retrun grossSalary;
			labourDeptViolationReport.add(getName());
	
	}

	public double calculateNetSalary(){
		return calculateGrossSalary()-.20;
	}
	public double calculateTax(){
		return calculateGrossSalary()- calculateNetSalary();
	}
}
	
public class Exam2{
	public static void main(String[] args){
		Employee e= new Maneger("1234", "Priya",35);
		//System.out.println(e.calculateGrossSalary());

		Employee s1 = new Supervisor("7583", "Riya", 43);
		Employee s1 = new Supervisor("9343", "Neha", 64);

		
		Employee w1= new Worker("7897", "Isha", 56);
		Employee w2= new Worker("7897", "Nisha ", 56);
		Employee w3= new Worker("7897", "Mansi", 56);
		Employee w4= new Worker("7897", "Ekta", 56);
		Employee w5= new Worker("7897", "Eira", 56);
		Employee w6= new Worker("7897", "prisha", 56);
		Employee w7= new Worker("7897", "grisha", 56);
		Employee w8= new Worker("7897", "shalini", 56);
		Employee w9= new Worker("7897", "sham", 56);
		Employee w10= new Worker("7897", "shriya", 56);
		
		
	}
}	





