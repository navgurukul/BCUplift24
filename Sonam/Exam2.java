
import java.util.ArrayList;
interface  Employee{
	double calculateGrossSalary(int hours);
	double calculateTax(double grassSalary);
	double calculateNetSalary(double grassSalary,double tax);
	public String getEmployeeName();
	public int getEmployeeId();
	public String getDesignation();

	
}

class Manager implements Employee{
	private int employeeId;
	private String employeeName;
	private String designation;
	public Manager(int employeeId,String employeeName,String designation){
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.designation=designation;
	}
	public int getEmployeeId(){
		return employeeId;
	}
	public String getEmployeeName(){
		return employeeName;
	}
	public String getDesignation(){
		return designation;
	}
	public double calculateGrossSalary(int hours){
		return hours*500;
	}
	public double calculateTax(double grassSalary){
		return grassSalary-(grassSalary*30/100);
	}
	public double calculateNetSalary(double grassSalary,double tax){
		return grassSalary-tax;
	}
	
	
}

class Supervisor implements Employee{
	private int employeeId;
	private String employeeName;
	private String designation;
	public Supervisor (int employeeId,String employeeName,String designation){
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.designation=designation;
	}
	public int getEmployeeId(){
		return employeeId;
	}
	public String getEmployeeName(){
		return employeeName;
	}
	public String getDesignation(){
		return designation;
	}
	public double calculateGrossSalary(int hours){
		if(hours>40){
			return ((40*300)+(hours-40)*450);
		}
		return hours*300;
	}
	public double calculateTax(double grassSalary){
		return grassSalary*0.2;
	}
	public double calculateNetSalary(double grassSalary,double tax){
		return  grassSalary-tax;
	}
	
	
}
class Worker implements Employee{
	private int employeeId;
	private String employeeName;
	private String designation;
	Worker(int employeeId,String employeeName,String designation){
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.designation=designation;
	}
	public int getEmployeeId(){
		return employeeId;
	}
	public String getEmployeeName(){
		return employeeName;
	}
	public String getDesignation(){
		return designation;
	}
	public double calculateGrossSalary(int hours){
		if(hours>40){
			return ((40*200)+(hours-40)*450);
		}
		return hours*200;
	}
	public double calculateTax(double grassSalary){
		return grassSalary*0.1;
	}
	public double calculateNetSalary(double grassSalary,double tax){
		return  grassSalary-tax;
	}
	
	
}

class Exam2{
	public static void main(String[] args){
		ArrayList<Employee> employee=new ArrayList<>();
		Employee manager1=new Manager(1,"Anurag","manager");
		int workingHours=40;
		double grassSalary=(manager1.calculateGrossSalary(workingHours));
		System.out.println(grassSalary);
		double tax=(manager1.calculateTax(manager1.calculateGrossSalary(workingHours)));
		System.out.println(tax);
		double netSalary=(manager1.calculateNetSalary((manager1.calculateGrossSalary(workingHours)),(manager1.calculateGrossSalary(workingHours))));
		System.out.println(netSalary);
		Employee supervisor1=new Supervisor(1,"Sandeep","Supervisor");
		Employee supervisor2=new Supervisor(2,"Vignesh","Supervisor");
		System.out.println( supervisor1.getEmployeeName());
	
		for(int i=0;i<=10;i++){
			employee.add(new Worker(i,"Worker:"+i,"worker"));
		}
		for(int i=0;i<=10;i++){
			System.out.println(employee.get());

		}
		
		
	}
}




















