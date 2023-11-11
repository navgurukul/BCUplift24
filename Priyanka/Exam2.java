import java.util.List;
import java.util.ArrayList;

interface Employee {
    
    double calculateGrossSalary();
    double calculateTax();
    double calculateNetSaraly();
}


class Manager implements Employee{
    private double workingHour;
    
    Manager(double workingHour) {
        this.workingHour = workingHour;
    }
    
    public double calculateGrossSalary(){ 
        return(workingHour*500);
    }
    
    public double calculateTax() {
        return(calculateGrossSalary()*.30);
    }
    public double calculateNetSaraly() {
        return((calculateGrossSalary() - calculateTax()));
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gross Salary Of Manager : " + calculateGrossSalary() + " ");
        sb.append("Tax Outgo : " + calculateTax() + " ");
        sb.append("Net Salary : " + calculateNetSaraly());
        return sb.toString();
    }
}



class Supervisor implements Employee{
    private double workHour;
    private double extraWorkHour;
    //List<String>supervisorList = new ArrayList<>();
    
    Supervisor(double workHour, double extraWorkHour) {
        this.workHour = workHour;
        this.extraWorkHour = extraWorkHour;
    }
    
    public double calculateGrossSalary() {
        return ((workHour * 300) + (extraWorkHour * 450));
    }
    public double calculateTax() {
        return(calculateGrossSalary() * .20);
    }
    public double calculateNetSaraly() {
        return((calculateGrossSalary() - calculateTax()));
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gross Salary Of Manager : " + calculateGrossSalary() + " ");
        sb.append("Tax Outgo : " + calculateTax() + " ");
        sb.append("Net Salary : " + calculateNetSaraly());
        return sb.toString();
    }
}



class Worker implements Employee {
    private double workHour;
    private double extraWorkHour;
    List<String> labourDeptViolationReport = new ArrayList<>();
    
    Worker(double workHour, double extraWorkHour) {
        this.workHour = workHour;
        this.extraWorkHour = extraWorkHour;
    }
    public double calculateGrossSalary() {
        if (extraWorkHour<=60) {
            return(workHour*200 + extraWorkHour*300);
        }
        else {
            labourDeptViolationReport.add("ad");
            return (workHour * 200 + 60*300);
        }
    }
    
    public double calculateTax() {
        return (calculateGrossSalary() * .10);
    }
    
    public double calculateNetSaraly() {
        return ((calculateGrossSalary() - calculateTax()));
    }
    public List<String> getList1() {
        return labourDeptViolationReport;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gross Salary Of Manager : " + calculateGrossSalary() + " ");
        sb.append("Tax Outgo : " + calculateTax() + " ");
        sb.append("Net Salary : " + calculateNetSaraly());
        return sb.toString();
    }
}



public class Exam2
{
	public static void main(String[] args) {
	    
		Manager m1 = new Manager(30);
		System.out.println(m1.toString());
		Supervisor s1 = new Supervisor(30,5);
		System.out.println(s1.toString());
		Worker w1 = new Worker(25,5);
		System.out.println(w1.toString());
		System.out.println("Total salary of 1 Manager , 2 Supervisor, 10 worker : ");
		System.out.println(m1.calculateNetSaraly()*1 + s1.calculateNetSaraly()*2 + w1.calculateNetSaraly()*10);
	}
}
