import java.util.ArrayList;

public class Exam2{
	
	public static ArrayList<Employee> makeEmployeesList(){
		ArrayList<Employee> employees = new ArrayList<Employee>();

		Employee emp1 = new Manager(1, "mngr", 50);
		
		System.out.println("Gross Salary: "+ emp1.calculateGrossSalary());
		System.out.println("Net Salary: "+ emp1.calculateNetSalary());
		System.out.println("Tax Outgo: "+ emp1.calculateTax());

		Employee emp2 = new Supervisor(2, "spvsr1", 65);
		
		System.out.println("Gross Salary: "+ emp2.calculateGrossSalary());
		System.out.println("Net Salary: "+ emp2.calculateNetSalary());
		System.out.println("Tax Outgo: "+ emp2.calculateTax());

		Employee emp3 = new Supervisor(3, "spvsr2", 45);

		Employee emp4 = new Worker(4, "wrk1", 40);

		System.out.println("Gross Salary: "+ emp4.calculateGrossSalary());
		System.out.println("Net Salary: "+ emp4.calculateNetSalary());
		System.out.println("Tax Outgo: "+ emp4.calculateTax());

		Employee emp5 = new Worker(5, "wrk2", 60);
		Employee emp6 = new Worker(6, "wrk3", 45);
		Employee emp7 = new Worker(7, "wrk4", 30);
		Employee emp8 = new Worker(8, "wrk5", 21);
		Employee emp9 = new Worker(9, "wrk6", 34);
		Employee emp10 = new Worker(10, "wrk7", 61);
		Employee emp11 = new Worker(11, "wrk8", 39);
		Employee emp12 = new Worker(12, "wrk9", 71);
		Employee emp13 = new Worker(13, "wrk10", 23);
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		employees.add(emp6);
		employees.add(emp7);
		employees.add(emp8);
		employees.add(emp9);
		employees.add(emp10);
		employees.add(emp11);
		employees.add(emp12);
		employees.add(emp13);
		
		return employees;
	}

	public static void main(String[] args){

		ArrayList<Employee> labourDeptViolationReport = new ArrayList<Employee>();

		ArrayList<Employee> employeesList = new ArrayList<Employee>();
		employeesList = makeEmployeesList();

		double totalCost = 0;

		
		for(int i = 0; i<employeesList.size(); i++){
			totalCost += ((employeesList.get(i)).calculateGrossSalary());
			if (((employeesList.get(i)).getWorkingHours()) > 60){
				labourDeptViolationReport.add(employeesList.get(i));
			}
		}
		
		System.out.println("Total employees in violation Report: " + labourDeptViolationReport.size());
		for(int j = 0; j<labourDeptViolationReport.size(); j++){
			System.out.println(labourDeptViolationReport.get(j));

		}
		System.out.println("Total payments made by company : " + totalCost);

		

	}
}
interface Employee{
	double getWorkingHours() ;
	double calculateGrossSalary();
	double calculateNetSalary();
	double calculateTax();
}

class Manager implements Employee{
	private int id;
	private String name;
	private double workhours;

	Manager(int id , String name , double workhours){
		this.id = id;
		this.name = name;
		this.workhours = workhours ;
	}
	
	public double getWorkingHours(){
		return workhours;
	}
	
	public double calculateGrossSalary(){
		double grossSalary = 40*500;
		return grossSalary ;	
	}
	public double calculateNetSalary(){
		return calculateGrossSalary() - calculateTax() ; 
	}
	public double calculateTax(){
		return calculateGrossSalary()*.30 ;
	}
	@Override
	public String toString(){
		return "ID: " + id +" " + "Name: "+ name + " " + "Workhours: " + workhours ;
	}
	
}

class Supervisor implements Employee{
	private int id;
	private String name;
	private double workhours ;
	
	Supervisor(int id , String name , double workhours){
		this.id = id;
		this.name = name;
		this.workhours = workhours;
	}
	
	public double getWorkingHours(){
		return workhours;
	}
	
	public double calculateGrossSalary(){
		double grossSalary;
		if (workhours>60){
			grossSalary = 40* 300 + (20)*450 ;
			
		}
		else if (workhours>=40 && workhours<=60){
			grossSalary = 40* 300 + (60-40)*450 ;
			
		}
		else{
			grossSalary = workhours* 300 ;
		}
		return grossSalary ;
	}
	public double calculateNetSalary(){
		return calculateGrossSalary() - calculateTax() ; 
	}
	public double calculateTax(){
		return calculateGrossSalary()*.20 ;

	}
	@Override
	public String toString(){
		return "ID: " + id +" " + "Name: "+ name + " " + "Workhours: " + workhours ;
	}
	
}

class Worker implements Employee{
	private int id;
	private String name;
	private double workhours ;
	
	Worker(int id , String name , double workhours){
		this.id = id;
		this.name = name;
		this.workhours = workhours ;
	}

	public double getWorkingHours(){
		return workhours;
	}
	public double calculateGrossSalary(){
		double grossSalary;
		if (workhours>60){
			 grossSalary= 40* 200 + (20)*300 ;
			
		}
		else if (workhours>=40 && workhours<=60){
			grossSalary = 40* 200 + (workhours-40)*300 ;
			
		}
		else{
			grossSalary=workhours*200;
		}
		return grossSalary ;
	}
	public double calculateNetSalary(){
		return calculateGrossSalary() - calculateTax() ;
	}
	public double calculateTax(){
		return calculateGrossSalary()*.10 ;
	}
	@Override 
	public String toString(){
		return "ID: " + id +" " + "Name: "+ name + " " + "Workhours: " + workhours ;
	}
	
}
