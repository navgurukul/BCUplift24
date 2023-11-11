interface Employee{
	 double calculateGrossSalary(double workinghours);
	 double calculateTax(double grosssalary);
	 double calcualteNetSalary(double grosssalary,double tax);
}

class Manager implements Employee{
	private String id;
	private String name;
	public  double hourlyrate= 500;
	public double taxrate=0.30;

 Manager(String id, String name){
	this.id=id;
	this.name=name;
	}

	public String getId(){
		return id;
	}

	public String getName(){
		return name;
	}
	
	public double calculateGrossSalary(double workinghours){
	
	}

	public double calculateTax(double grosssalary){
		return  grosssalary * taxrate;
	}

	public double calcualteNetSalary(double grosssalary,double tax){
		return grosssalary - tax;
	}


}
class Supervisor implements Employee{
	private String id;
	private String name;
	public  double hourlyrate= 300;
	public double taxrate=0.20;

 Supervisor(String id, String name){
	this.id=id;
	this.name=name;
	}

	public String getId(){
		return id;
	}

	public String getName(){
		return name;
	}
	
	public double calculateGrossSalary( double workinghours){
		
	}

	public double calculateTax(double grosssalary){
		return  grosssalary * taxrate;
	}

	public double calcualteNetSalary(double grosssalary,double tax){
		
		return grosssalary - tax; 
	}


}

class Worker implements Employee{
	private String id;
	private String name;
	public  double hourlyrate= 200;
	public double taxrate= 0.10;

 Worker(String id, String name){
	this.id=id;
	this.name=name;
	}

	public String getId(){
		return id;
	}

	public String getName(){
		return name;
	}
	
	public double calculateGrossSalary(double workinghours){
		
	}

	public double calculateTax(double grosssalary){
		return  grosssalary * taxrate;
	}

	public double calcualteNetSalary(double grosssalary,double tax){
		
		return  grosssalary - tax;
	}


}
public class Exam2{
public static void main(String[] args){
	List<Employee> e= new ArrayList<>();
	 Exam2(){
		e.add(new Manager("SP63","Prakash sir"));
		e.add(new Supervisor("HN76","Arjun kumar"));
		e.add(new Employee("HR74","Trupti"));
		e.add(new  Employee("JK74","kirti"));
		e.add(new  Employee("WQ74","kavya"));
		e.add(new  Employee("GS74","shivani"));
		e.add(new  Employee("BN74","priya"));
		e.add(new  Employee("LK74","neha"));
		e.add(new  Employee("JS74","saloni"));
		e.add(new  Employee("CX74","pragati"));
		e.add(new  Employee("BV74","sonu"));
		e.add(new  Employee("RE74","gayatri"));
	
	}

	private static double calculateCost(List<Employee>e){

    double totalCost = 0;

        for (Employee employee : e) {
            double  hoursWorked = 45; 
            double grossSalary = employee.calculateGrossSalary(workinghours);
            double tax = employee.calculateTax(grosssalary);
            double NetSalary = employee.calculateNetSalary(grosssalary, tax);
	
	
	
	}
}