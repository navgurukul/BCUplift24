import java.util.ArrayList;
import java.util.Random;

class Exam2{
	public static void main(String args[]){
		Manager m1= new Manager("SRK",40);
		System.out.println(m1.calculateGrossSalary());
		Supervisor s1= new Supervisor("SRK",40);
		System.out.println(s1.calculateGrossSalary());
		System.out.println(s1.getArrayListOfViolation());
		Worker w1= new Worker("Rahul",60);
		System.out.println(w1.calculateGrossSalary());
		System.out.println(w1.getArrayListOfViolation());
		System.out.println(m1);
		System.out.println(s1);
		System.out.println(w1);
		


		double m= m1.calculateGrossSalary();
		double s=2*s1.calculateGrossSalary();
		double w=10*(w1.calculateGrossSalary());
		System.out.println("Total Expenses is: "+Double.valueOf(m)+Double.valueOf(s)+Double.valueOf(w));
	} 
	

}

interface Employee {
	//int employeeId=Null;
	//String name="Something";
	
	double calculateGrossSalary();
	double calculateTax();
	double calculateNetSalary();
}


class Manager implements Employee{
	private int workingHour;
	private int employeeId;
	private String name;
	
	
	public ArrayList<Manager> labourDeptViolationReportList = new ArrayList<>();

	public Manager(String name,int workingHour){
		this.workingHour = workingHour;
		Random random = new Random();
		this.employeeId=random.nextInt();
		this.name =name;
	}
	
	

	protected int getWorkingHour(){
		return workingHour;
	}

	
	protected int getEmployeeId(){
		return employeeId;
	
	}

	protected String getName(){
		return name;
	}
	
	
	public double calculateGrossSalary(){
		double grossSalary = getWorkingHour()*500;
		return grossSalary;
		}


	public double calculateTax(){
		double taxOutgo= calculateGrossSalary()*.30;
		return taxOutgo;
	}

	public double calculateNetSalary(){
		double netSalary = calculateGrossSalary()-calculateTax();
		return netSalary;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder("EmployeeId: "+employeeId);
		sb.append("\n Name : "+name);
		sb.append("\n Gross salary : "+calculateGrossSalary());
		sb.append("\n Tax outgo : "+calculateTax());
		sb.append("\n  Net Salary : "+calculateNetSalary());
		return sb.toString();
	}
	
}

class Supervisor implements Employee{
	private int workingHour;
	private int employeeId;
	private String name;
	public ArrayList<String> labourDeptViolationReportList = new ArrayList<>();
	

	public Supervisor (String name,int workingHour){
		this.workingHour = workingHour;
		Random random = new Random();
		this.employeeId=random.nextInt();
		this.name =name;
	}
	
	protected int getWorkingHour(){
		return workingHour;
	}

	
	protected int getEmployeeId(){
		return employeeId;
	}

	protected String getName(){
		return name;
	}
	
	public double calculateGrossSalary(){
	
		if (getWorkingHour()<60){
			double grossSalary = getWorkingHour()*300 +(getWorkingHour()-40)* 450;
			return grossSalary;
		}else{
			labourDeptViolationReportList.add(getName());
			labourDeptViolationReportList.add(String.valueOf(60*300));
			return  60*300;
			}
	}
		
	protected ArrayList<String> getArrayListOfViolation(){
		return labourDeptViolationReportList;
		}

	 public double calculateTax(){
		double taxOutGo=calculateGrossSalary()*.20;
		return taxOutGo;
	}

	 public double calculateNetSalary(){
		double netSalary= calculateGrossSalary()- calculateTax();
		return netSalary;
	}


	public String toString(){
		StringBuilder sb=new StringBuilder("EmployeeId: "+employeeId);
		sb.append("Name : "+name);
		sb.append(" Gross salary : "+calculateGrossSalary());
		sb.append(" Tax outgo : "+calculateTax());
		sb.append(" Net Salary : "+calculateNetSalary());
		return sb.toString();
	}
}

class Worker implements Employee{
	private int workingHour;
	private int employeeId;
	private String name;
	
	private ArrayList<String> labourDeptViolationReportList = new ArrayList<>();
	

	public Worker(String name,int workingHour){
		this.workingHour = workingHour;
		Random random = new Random();
		this.employeeId=random.nextInt();
		this.name =name;
	}

	protected int getWorkingHour(){
		return workingHour;
	}

	
	protected int getEmployeeId(){
		return employeeId;
	
	}

	protected String getName(){
		return name;
	}

	protected ArrayList<String> getArrayListOfViolation(){
		return labourDeptViolationReportList;
		}
	
	 public double calculateGrossSalary(){
		if (getWorkingHour()<60){
			double grossSalary = getWorkingHour()*200 +(getWorkingHour()-40)* 300;
			return grossSalary;
		}else{
			labourDeptViolationReportList.add(getName());
			labourDeptViolationReportList.add(String.valueOf(String.valueOf(60*300)));
			return  60*300;
			}

	}
	 public double calculateTax(){
		double taxOutGo=calculateGrossSalary()*.10;
		return taxOutGo;
	}

	public double calculateNetSalary(){
		double netSalary= calculateGrossSalary()- calculateTax();
		return netSalary;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder("EmployeeId: "+employeeId);
		sb.append("Name : "+name);
		sb.append(" Gross salary : "+calculateGrossSalary());
		sb.append(" Tax outgo : "+calculateTax());
		sb.append(" Net Salary : "+calculateNetSalary());
		return sb.toString();
	}
}


//class LabourDeptViolationReportList{
	//ArrayList<Employee> labourDeptViolationReportList = new ArrayList<Employee>();
//}




