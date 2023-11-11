import java.util.ArrayList;
public class Exam2{
	public static void main(String[] args){
		
		System.out.println("Manager employee Details--------------------------------------------------------------");
		Manager m = new Manager(4,6,1234,"Sonam");
        	m.calculateGrossSalary();
       		m.calculateTax();
        	m.calculateNetSalary();
		System.out.println("Employee ID: " + m.Id);
		System.out.println("Employee name: " + m.name);
        	System.out.println("Gross Salary: " + m.getGrossSalary());
        	System.out.println("Tax: " + m.getTax());
        	System.out.println("Net Salary: " + m.getNetSalary());
		
		System.out.println("Supervisor employee Details-------------------------------------------------------------");
		Supervisor s = new Supervisor(4,5,5678,"Monika");
        	s.calculateGrossSalary();
       		s.calculateTax();
        	s.calculateNetSalary();
		System.out.println("Employee ID: " + s.Id);
		System.out.println("Employee name: " + s.name);
        	System.out.println("Gross Salary: " + s.getGrossSalary());
        	System.out.println("Tax: " + s.getTax());
        	System.out.println("Net Salary: " + s.getNetSalary());

		System.out.println("Worker employee Details------------------------------------------------------------------");
		Worker w = new Worker(7,9,5678,"Anshika");
        	w.calculateGrossSalary();
       		w.calculateTax();
        	w.calculateNetSalary();
		System.out.println("Employee ID"+w.Id);
		System.out.println("Employee name:"+w.name);
        	System.out.println("Gross Salary: " + w.getGrossSalary());
        	System.out.println("Tax: " + w.getTax());
        	System.out.println("Net Salary: " + w.getNetSalary());
		
	}
}
interface Employee{
	double calculateGrossSalary();
	double calculateNetSalary();
	double calculateTax();
}
class Manager implements Employee{
	public double Id;
	public String name;
	public static final double hoursRate=500;
	public static final double maxHours=40;
	public static final double taxRate=0.30;
	public double workingHours;
	public double overHours;
	
	private double grossSalary;
	private double texOutGo;
	private double netSalary;
	Manager(double workingHours,double overHours,double Id,String name){
		this.workingHours=workingHours;
		this.overHours=overHours;
		this.Id=Id;
		this.name=name;
	}
	
	public double calculateGrossSalary(){
		grossSalary=workingHours*500;
		return grossSalary;
	}
	
	public double calculateNetSalary(){
		texOutGo=grossSalary*taxRate;
		netSalary=grossSalary-texOutGo;
		return netSalary;
	}
	public double calculateTax(){
		return texOutGo;
	}
	
	public double getGrossSalary(){
		return grossSalary;
	}
	public double getTax(){
		return texOutGo;
	}	
	public double getNetSalary(){
		return netSalary;
	}
}

class Supervisor implements Employee{
	public static final double hoursRate=300;
	public static final double maxHours=60;
	public static final double taxRate=0.20;
	public static final double maxWeeklyHour=60;
	public static final double overtimeRate=1.5;
	
	public double Id;
	public String name;
	public double workingHours;
	public double overHours;
	
	private double grossSalary;
	private double texOutGo;
	private double netSalary;
	Supervisor(double workingHours,double overHours,double Id,String name){
		this.workingHours=workingHours;
		this.overHours=overHours;
		this.Id=Id;
		this.name=name;
	}
	
	public double calculateGrossSalary(){
		grossSalary=(workingHours*300)+(overHours*450);
		return grossSalary;
	}
	public double calculateNetSalary(){
		texOutGo=grossSalary*taxRate;
		return texOutGo;
	}
	public double calculateTax(){
		netSalary=grossSalary-texOutGo;
		return netSalary;
	}
	public double getGrossSalary(){
		return grossSalary;
	}
	public double getTax(){
		return texOutGo;
	}	
	public double getNetSalary(){
		return netSalary;
	}
	
}

class Worker implements Employee{
	public static final double hoursRate=200;
	public static final double maxHours=60;
	public static final double taxRate=0.10;
	public static final double maxWeeklyHour=60;
	public static final double overtimeRate=1.5;
	
	public double Id;
	public String name;
	public double workingHours;
	public double overHours;
	
	private double grossSalary;
	private double texOutGo;
	private double netSalary;
	Worker(double workingHours,double overHours,double Id,String name){
		this.workingHours=workingHours;
		this.overHours=overHours;
		this.Id=Id;
		this.name=name;
	}
	
	public double calculateGrossSalary(){
		grossSalary=(workingHours*200)+(overHours*300);
		return grossSalary;
	}
	public double calculateNetSalary(){
		texOutGo=grossSalary*taxRate;
		return texOutGo;
	}
	public double calculateTax(){
		netSalary=grossSalary-texOutGo;
		return netSalary;
	}
	public double getGrossSalary(){
		return grossSalary;
	}
	public double getTax(){
		return texOutGo;
	}	
	public double getNetSalary(){
		return netSalary;
	}
	
}

