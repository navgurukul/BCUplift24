import java.util.ArrayList;

public class Exam2{
	
	public static ArrayList<Employee> makeEmployeesList(){
		ArrayList<Employee> emps = new ArrayList<Employee>();

		Employee emp1 = new Manager(1, "mngr", 40);
		
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
		
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);
		emps.add(emp6);
		emps.add(emp7);
		emps.add(emp8);
		emps.add(emp9);
		emps.add(emp10);
		emps.add(emp11);
		emps.add(emp12);
		emps.add(emp13);
		
		return emps;
	}

	public static void main(String[] args){

		ArrayList<Employee> labourDeptViolationReport = new ArrayList<Employee>();

		ArrayList<Employee> employeesList = new ArrayList<Employee>();
		employeesList = makeEmployeesList();

		double totalCost = 0;

		
		for (int i = 0; i<employeesList.size(); i++){
			totalCost += ((employeesList.get(i)).calculateGrossSalary());
			if (((employeesList.get(i)).getWorkingHours()) > 60){
				labourDeptViolationReport.add(employeesList.get(i));
			}
		}
		
		System.out.println("Violation Report: ");
		for (int j = 0; j<labourDeptViolationReport.size(); j++){
			System.out.println(labourDeptViolationReport.get(j));
		}
		System.out.println("Total payments made by company : " + totalCost);

		

	}
}

interface Employee{
	
	public int getWorkingHours();
	public double calculateGrossSalary();
	public double calculateNetSalary();

	public double calculateTax();
}


class Manager implements Employee{

	private int id;
	private String name;

	private int workingHours;

	Manager(int id, String name, int workingHours){
		this.id = id;
		this.name = name;
		this.workingHours = workingHours;
	}

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public int getWorkingHours(){
		return workingHours;
	}

	public double calculateGrossSalary(){
		if (workingHours > 40){
			return 40*500;
		}
		return workingHours*500;
	}

	public double calculateNetSalary(){
		return calculateGrossSalary() - calculateTax();
	}

	public double calculateTax(){
		return calculateGrossSalary()*30/100;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder(" Id: "+ id);
		sb.append(" Name: "+name);
		String result = sb.toString();
		return result;
	}	
}	


class Supervisor implements Employee{
	private int id;
	private String name;
	
	private int workingHours;

	Supervisor(int id, String name, int workingHours){
		this.id = id;
		this.name = name;
		this.workingHours = workingHours;
	}

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public int getWorkingHours(){
		return workingHours;
	}

	public double calculateGrossSalary(){
		double salary = workingHours*300;
		if (workingHours > 40){
			if (workingHours > 60){
				double overtime = 60 * 450;
				salary += overtime;
			}
			else{
				double overtime = (workingHours - 40) * 450;
				salary += overtime;
			}
		}
		
		return salary;
	}

	public double calculateNetSalary(){
		return calculateGrossSalary() - calculateTax();
	}

	public double calculateTax(){
		return calculateGrossSalary()*20/100;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder(" Id: "+ id);
		sb.append(" Name: "+name);
		String result = sb.toString();
		return result;
	}
}	



class Worker implements Employee{
	private int id;
	private String name;

	private int workingHours;

	Worker(int id, String name, int workingHours){
		this.id = id;
		this.name = name;
		this.workingHours = workingHours;
	}

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public int getWorkingHours(){
		return workingHours;
	}

	public double calculateGrossSalary(){
		double salary = workingHours*200;
		if (workingHours > 40){
			if (workingHours > 60){
				double overtime = 60 * 300;
				salary += overtime;
			}
			else{
				double overtime = (workingHours - 40) * 300;
				salary += overtime;
			}
		}
		
		return salary;
	}

	public double calculateNetSalary(){
		return calculateGrossSalary() - calculateTax();
	}

	public double calculateTax(){
		return calculateGrossSalary()*10/100;
	}


	public String toString(){
		StringBuilder sb = new StringBuilder(" Id: "+ id);
		sb.append(" Name: "+name);
		String result = sb.toString();
		return result;
	}
}
