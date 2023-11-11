import java.util.ArrayList;
public class Exam2{
	public static void main(String[] args){
	SuperVisors s1 = new SuperVisors("1","John","Supervisor");
	s1.calculateGrossSalary(40,5);
	s1.calculateTaxOutgo(14250);
	s1.calculateNetSalary(14250,2850);
	System.out.println(s1.toString());
	Workers w1 = new Workers("3","Ram","Worker");
	w1.calculateGrossSalary(20,4);
	w1.calculateTaxOutgo(5200);
	w1.calculateNetSalary(5200,520);
	System.out.println(w1.toString());
	Manager m1 = new Manager("4","Sia","Manager");
	m1.calculateGrossSalary(45,8);
	m1.calculateTaxOutgo(22500);
	m1.calculateNetSalary(22500,6750);
	System.out.println(m1.toString());
	
	}
}
interface Employee{
	public double calculateGrossSalary(int workingHour,int overTime);
	public double calculateTaxOutgo(double grossSalary);
	public double calculateNetSalary(double grossSalary,double taxOutgo);
	
}
/*class EmployeeDataChecker{
	private String employeeId;
	private String name;
	private int workingHour;
	private ArrayList <EmployeeDataChecker>  labourDeptViolationReportList = new ArrayList<>();
	EmployeeDataChecker(String employeeId,String name,int workingHour){
		this.employeeId = employeeId;
		this.name = name;
		this.workingHour = workingHour;
	}

}*/
class Manager implements Employee{
	private String employeeId;
	private String name;
	private String designation;
	Manager(String employeeId,String name,String designation){
		this.employeeId = employeeId;
		this.name=name;
		this.designation=designation;
		
	}
	double grossSalarym;
	public double calculateGrossSalary(int workingHour,int overTime){
		grossSalarym = workingHour*500 + 0;
		return grossSalarym;
		
	}
	double taxm;
	public double calculateTaxOutgo(double grossSalarym){
		taxm = grossSalarym *0.30;
		return taxm;
		
	}
	double netSalarym;
	public double calculateNetSalary(double grossSalarym,double taxm){
		netSalarym = grossSalarym - taxm;
		return netSalarym;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("Employee id : " + employeeId);
		sb.append(" Employee name : " + name);
		sb.append(" Employee's grossSalary : " + grossSalarym);
		sb.append(" Employee's taxOutgo : " + taxm);
		sb.append(" Employee's NetSalary : " + netSalarym);
		return sb.toString();
	} 
	
}
class SuperVisors implements Employee{
	private String employeeId;
	private String name;
	private String designation;
	
	SuperVisors(String employeeId,String name,String designation){
		this.employeeId = employeeId;
		this.name=name;
		this.designation= designation;
	}
	double grossSalary;
	public double calculateGrossSalary(int workingHour,int overTime){
		/*if (workingHour > 60){
			labourDeptViolationReportList.add(s);	
		}*/
		grossSalary= workingHour*300+overTime*450;
		return grossSalary;
		
	}
	double taxOutgo;
	public double calculateTaxOutgo(double grossSalary){
		taxOutgo = grossSalary*0.20;
		return taxOutgo;
		
	}
	double netSalary;
	public double calculateNetSalary(double grossSalary,double taxOutgo){
		netSalary = grossSalary-taxOutgo;
		return netSalary;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("Employee id : " + employeeId);
		sb.append(" Employee name : " + name);
		sb.append(" Employee's grossSalary : " + grossSalary);
		sb.append(" Employee's taxOutgo : " + taxOutgo);
		sb.append(" Employee's NetSalary : " + netSalary);
		return sb.toString();
	} 
}
class Workers implements Employee{
	private String employeeId;
	private String name;
	private String designation;
	Workers(String employeeId,String name,String designation){
		this.employeeId = employeeId;
		this.name=name;
		this.designation = designation;
		
	}
	double grossSalaryw; 
	public double calculateGrossSalary(int workingHour,int overTime){
		grossSalaryw = workingHour*200+overTime*300;
		return grossSalaryw;
	}
	double taxw;
	public double calculateTaxOutgo(double grossSalaryw){
		taxw = grossSalaryw*0.10;
		return taxw;
	}
	double netw;
	public double calculateNetSalary(double grossSalaryw,double taxw){
		netw = grossSalaryw - taxw;
		return netw;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("Employee id : " + employeeId);
		sb.append(" Employee name : " + name);
		sb.append(" Employee's grossSalary : " + grossSalaryw);
		sb.append(" Employee's taxOutgo : " + taxw);
		sb.append(" Employee's NetSalary : " + netw);
		return sb.toString();
	} 
		

		
}
	
