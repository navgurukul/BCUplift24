import java.util.ArrayList;

public class Exam2{
	public static void main(String[] args){

		Manager emp1 = new Manager(1,"Ruksana" , 65.0);
		System.out.println("Gross salary of manager: " + emp1.calculateGrossSalary());
		System.out.println("Net salary of manager: " + emp1.calculateNetSalary());
		System.out.println("Tax outgo of manager: " + emp1.calculateTax());
		ArrayList<LabourDeptViolationReport> var1 = emp1.getLabourDeptViolationReportList();
		System.out.println(var1) ;

		Supervsior emp2 = new Supervsior(1,"Ankit",50.0);
		System.out.println("Gross salary of supervsior: " + emp2.calculateGrossSalary());
		System.out.println("Net salary of supervsior: " + emp2.calculateNetSalary());
		System.out.println("Tax outgo of supervsior: " + emp2.calculateTax());

		Worker emp3 = new Worker(3,"Sunny" , 45.0);
		System.out.println("Gross salary of worker: " + emp3.calculateGrossSalary());
		System.out.println("Net salary of worker: " + emp3.calculateNetSalary());
		System.out.println("Tax outgo of worker: " + emp3.calculateTax());
		
	}
	public void totalCost(){
		
	}
}

interface Employee{
	int id = 0;
	String name = "";
	ArrayList<LabourDeptViolationReport> labourDeptViolationReportList = new ArrayList<LabourDeptViolationReport>() ;

	double calculateGrossSalary();
	double calculateNetSalary();
	double calculateTax();
	ArrayList<LabourDeptViolationReport> getLabourDeptViolationReportList();
}

class Manager implements Employee{
	int id;
	String name;
	double workhours;
	ArrayList<LabourDeptViolationReport> labourDeptViolationReportList = new ArrayList<LabourDeptViolationReport>() ;

	Manager(int id , String name , double workhours){
		this.id = id;
		this.name = name;
		this.workhours = workhours ;
	}
	
	public double calculateGrossSalary(){
		if (workhours>60){
			LabourDeptViolationReport obj = new LabourDeptViolationReport(id , name);
			labourDeptViolationReportList.add(obj);
			double grossSalary = 60*500 ;
			return grossSalary ;
		}
		else{
			double grossSalary = workhours* 500;
			return grossSalary ;
		}
	}
	public double calculateNetSalary(){
		return calculateGrossSalary() - calculateTax() ; 
	}
	public double calculateTax(){
		return calculateGrossSalary()*.30 ;
	}
	public ArrayList<LabourDeptViolationReport> getLabourDeptViolationReportList(){
		return labourDeptViolationReportList ;
	}
}

class Supervsior implements Employee{
	int id;
	String name;
	double workhours ;
	ArrayList<LabourDeptViolationReport> labourDeptViolationReportList = new ArrayList<LabourDeptViolationReport>() ;
	
	Supervsior(int id , String name , double workhours){
		this.id = id;
		this.name = name;
		this.workhours = workhours;
	}
	
	public double calculateGrossSalary(){
		if (workhours>60){
			LabourDeptViolationReport obj1 = new LabourDeptViolationReport(id , name);
			labourDeptViolationReportList.add(obj1);
			double grossSalary = 60* 300 + (60-40)*450 ;
			return grossSalary ;
		}
		else{
			double grossSalary = workhours* 300 + (workhours-40)*450 ;
			return grossSalary ;
		}
	}
	public double calculateNetSalary(){
		return calculateGrossSalary() - calculateTax() ; 
	}
	public double calculateTax(){
		return calculateGrossSalary()*.20 ;

	}
	public ArrayList<LabourDeptViolationReport> getLabourDeptViolationReportList(){
		return labourDeptViolationReportList ;
	}
}

class Worker implements Employee{
	int id;
	String name;
	double workhours ;
	ArrayList<LabourDeptViolationReport> labourDeptViolationReportList = new ArrayList<LabourDeptViolationReport>() ;
	
	Worker(int id , String name , double workhours){
		this.id = id;
		this.name = name;
		this.workhours = workhours ;
	}
	
	public double calculateGrossSalary(){
		if (workhours>60){
			LabourDeptViolationReport obj2 = new LabourDeptViolationReport(id , name);
			labourDeptViolationReportList.add(obj2);
			double grossSalary = 60* 200 + (60-40)*300 ;
			return grossSalary ;
		}
		else{
			double grossSalary = workhours* 200 + (workhours-40)*300 ;
			return grossSalary ;
		}
	}
	public double calculateNetSalary(){
		return calculateGrossSalary() - calculateTax() ;
	}
	public double calculateTax(){
		return calculateGrossSalary()*.10 ;
	}
	public ArrayList<LabourDeptViolationReport> getLabourDeptViolationReportList(){
		return labourDeptViolationReportList ;
	}
}

class LabourDeptViolationReport{
	int empId ;
	String name;
	
	LabourDeptViolationReport(int empId , String name){
		this.empId = empId ;
		this.name = name ;
	}
	
	@Override
	public String toString(){
		return "empId: "+ empId + "" + "empName: " + name ;
	}
	
}