import java.util.ArrayList;

public class Test2{
	
	public static void main(String[] args){
		Employee manager = new Manager("123456754","Manager1",40);
		System.out.println("Gross Salary : "+manager.calculateGrossSalary());
		System.out.println("Tax : "+manager.calculateTax());
		System.out.println("Net Salary : "+manager.calculateNetSalary());

		Employee supervsior1 = new Supervsior("234523467","Supervsior1",30);
		System.out.println("Gross Salary : "+supervsior1.calculateGrossSalary());
		System.out.println("Tax : "+supervsior1.calculateTax());
		System.out.println("Net Salary : "+supervsior1.calculateNetSalary());

		Employee supervsior2 = new Supervsior("453216754","Supervsior2",60);
		System.out.println("Gross Salary : "+supervsior2.calculateGrossSalary());
		System.out.println("Tax : "+supervsior2.calculateTax());
		System.out.println("Net Salary : "+supervsior2.calculateNetSalary());
		
		Employee worker1 = new Worker("234523467","Supervsior1",30);
		System.out.println("Gross Salary : "+worker1.calculateGrossSalary());
		System.out.println("Tax : "+worker1.calculateTax());
		System.out.println("Net Salary : "+worker1.calculateNetSalary());

		Employee worker2 = new Worker("453216754","Supervsior2",50);
		System.out.println("Gross Salary : "+worker2.calculateGrossSalary());
		System.out.println("Tax : "+worker2.calculateTax());
		System.out.println("Net Salary : "+worker2.calculateNetSalary());
		
		Employee worker3 = new Worker("453216754","Supervsior2",60);
		System.out.println("Gross Salary : "+worker3.calculateGrossSalary());
		System.out.println("Tax : "+worker3.calculateTax());
		System.out.println("Net Salary : "+worker3.calculateNetSalary());

		Employee worker4 = new Worker("453216754","Supervsior2",75);
		System.out.println("Gross Salary : "+worker4.calculateGrossSalary());
		System.out.println("Tax : "+worker4.calculateTax());
		System.out.println("Net Salary : "+worker4.calculateNetSalary());

		Employee worker5 = new Worker("453216754","Supervsior2",50);
		System.out.println("Gross Salary : "+worker5.calculateGrossSalary());
		System.out.println("Tax : "+worker5.calculateTax());
		System.out.println("Net Salary : "+worker5.calculateNetSalary());

		Employee worker6 = new Worker("453216754","Supervsior2",30);
		System.out.println("Gross Salary : "+worker6.calculateGrossSalary());
		System.out.println("Tax : "+worker6.calculateTax());
		System.out.println("Net Salary : "+worker6.calculateNetSalary());

		Employee worker7 = new Worker("453216754","Supervsior2",40);
		System.out.println("Gross Salary : "+worker7.calculateGrossSalary());
		System.out.println("Tax : "+worker7.calculateTax());
		System.out.println("Net Salary : "+worker7.calculateNetSalary());		
		Employee worker8 = new Worker("453216754","Supervsior2",75);
		System.out.println("Gross Salary : "+worker8.calculateGrossSalary());
		System.out.println("Tax : "+worker8.calculateTax());
		System.out.println("Net Salary : "+worker8.calculateNetSalary());

		Employee worker9 = new Worker("453216754","Supervsior2",55);
		System.out.println("Gross Salary : "+worker9.calculateGrossSalary());
		System.out.println("Tax : "+worker9.calculateTax());
		System.out.println("Net Salary : "+worker9.calculateNetSalary());

		Employee worker10 = new Worker("453216754","Supervsior2",70);
		System.out.println("Gross Salary : "+worker10.calculateGrossSalary());
		System.out.println("Tax : "+worker10.calculateTax());
		System.out.println("Net Salary : "+worker10.calculateNetSalary());
	
		Employee[] employee = {worker1, worker2, worker3, worker4, worker5, worker6, worker7, worker8, worker9, worker10, supervsior1, supervsior2};
		addReport(employee);

	}

	public static void addReport(Employee[] array){
		ArrayList<Employee> LabourDeptViolationReportList = new ArrayList<Employee>();

		for (int i=0; i<array.length;i++){
			if (array[i].getWorkingHours()>60){
				LabourDeptViolationReportList.add(array[i]);
			}
		}
		showLabourDeptViolationReportList(LabourDeptViolationReportList);
	}
	public static void showLabourDeptViolationReportList(ArrayList<Employee> array){
		ArrayList<Employee> employeeList = array;
		if (employeeList.size()==0){
			System.out.println( "Report: All the Employees have worked less than 60 hous");
		}else{
			StringBuilder str = new StringBuilder();
			str.append("Report: \n");
			for (int i=0; i<employeeList.size();i++){
				str.append("Name : "+employeeList.get(i).getName());
				str.append(" Employee Id : "+employeeList.get(i).getEmployeeId());
				str.append("\n");
			}
			System.out.println(str.toString());
		}
	}
}

interface Employee{
	public int getWorkingHours();
	public String getName();
	public String getEmployeeId();
	public double calculateTax();
	public double calculateNetSalary();
	public double calculateGrossSalary();
}

class Manager implements Employee{
	private String employeeId;
	private String name;
	private int workingHours;

	Manager(String employeeId, String name, int workingHours){
		this.employeeId = employeeId;
		this.name = name;
		this.workingHours = workingHours;
	}
	public int getWorkingHours(){
		return workingHours;
	}
	public String getName(){
		return name;
	}
	public String getEmployeeId(){
		return employeeId;
	}
	public double calculateTax(){
		return calculateGrossSalary()*0.30;
	}

	public double calculateNetSalary(){
		return calculateGrossSalary()-calculateTax();
	}

	public double calculateGrossSalary(){
		if (workingHours>40){
			return 40*500;
		}
		return workingHours*500;
	}
}

class Supervsior implements Employee{
	private String employeeId;
	private String name;
	private int workingHours;
	private ArrayList<String> labourDeptViolationReportList=new ArrayList<String>();


	Supervsior(String employeeId, String name, int workingHours){
		this.employeeId = employeeId;
		this.name = name;
		this.workingHours = workingHours;
	}
	
	public int getWorkingHours(){
		return workingHours;
	}
	public String getName(){
		return name;
	}
	public String getEmployeeId(){
		return employeeId;
	}
	public double calculateTax(){
		return calculateGrossSalary()*0.20;
	}

	public double calculateNetSalary(){
		return calculateGrossSalary()-calculateTax();
	}

	public double calculateGrossSalary(){
		if (workingHours<40){
			return workingHours*300;
		}
		else{
			if (workingHours>60){
				return (20*450)+(40*300);
			}
			return ((workingHours-40)*450)+(40*300);
		}
	}
}

class Worker implements Employee{
	private String employeeId;
	private String name;
	private int workingHours;

	Worker(String employeeId, String name, int workingHours){
		this.employeeId = employeeId;
		this.name = name;
		this.workingHours = workingHours;
	}

	public int getWorkingHours(){
		return workingHours;
	}
	public String getName(){
		return name;
	}
	public String getEmployeeId(){
		return employeeId;
	}

	public double calculateTax(){
		return calculateGrossSalary()*0.10;
	}

	public double calculateNetSalary(){
		return calculateGrossSalary()-calculateTax();
	}

	public double calculateGrossSalary(){
		if (workingHours<=40){
			return workingHours*200;
		}
		else{
			if (workingHours>60){
				return (20*300)+(40*200);
			}
			return ((workingHours-40)*300)+(40*200);
		}
	}

	
}
