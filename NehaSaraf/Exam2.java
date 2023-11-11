
interface Employee{
	

	double calculateGrossSalary();
	double calculateTax();
	double calculateNetSalary();
}

abstract class EmployeeDtails implements Employee{
	private String employeeId;
	private String name;
	private String designation;

	EmployeeDtails(String employeeId,String name,String designation){
		this.employeeId=employeeId;
		this.name=name;
		this.designation=designation;
	}
	
	
}

class Manager implements Employee{
	private int workingHour;
	Manager(int workingHour){
		this.workingHour=workingHour;
	}
	
	public double calculateGrossSalary(){	
		double grossSalary;
		if(workingHour<=40){
			grossSalary=workingHour*500;
		}
		else{
			grossSalary=40*500;
		}
		return grossSalary;
	}
	public double calculateTax(){
		double 	taxOutgo;
		taxOutgo=calculateGrossSalary()*0.30;
		return taxOutgo;
	}
	public double calculateNetSalary(){
		double netSalary=calculateGrossSalary()-calculateTax();
		return netSalary;
	}	
		
}
class Supervisor implements Employee{
	private int workingHour;
	Supervisor(int workingHour){
		this.workingHour=workingHour;
	}
	
	public double calculateGrossSalary(){	
		double grossSalary=0;
		if(workingHour<=40){
			grossSalary=workingHour*300;
		}
		else if(workingHour>40 && workingHour<=60){
			grossSalary=workingHour*300+(workingHour-40)*450;
		}
		return  grossSalary;
	}

	public double calculateTax(){
		double 	taxOutgo;
		taxOutgo=calculateGrossSalary()*0.20;
		return taxOutgo;
	}

	public double calculateNetSalary(){
		double netSalary=calculateGrossSalary()-calculateTax();
		return netSalary;
	}
		
	
}

class Worker implements Employee{
	private int workingHour;
	Worker(int workingHour,int extraWorkHour){
		this.workingHour=workingHour;
	}
	
	public double calculateGrossSalary(){	
		double grossSalary=0;
		if(workingHour<=40){
			grossSalary=workingHour*200;
		}
		else if(workingHour>40 && workingHour<=60){
			grossSalary=workingHour*200+(workingHour-40)*300;
		}
		return  grossSalary;
	}

	public double calculateTax(){
		double 	taxOutgo;
		taxOutgo=calculateGrossSalary()*0.10;
		return taxOutgo;
	}

	public double calculateNetSalary(){
		double netSalary=calculateGrossSalary()-calculateTax();
		return netSalary;
	}
	
	
}


public class Exam2{
	public static void main(String[] args){
	}
		
}