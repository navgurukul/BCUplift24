public class Exam2{
	public static void main(String[] args){
		Manager m1 = new Manager("1234", "Vanshika");
		System.out.println("Gross salary: " + m1.calculateGrossSalary(70));
		System.out.println("Tax:" + m1.calculateTax(70));
		Supervisor s1 = new Supervisor("1235", "Sonam");
		System.out.println("Gross salary:" + s1.calculateGrossSalary(20));
		Worker w1 = new Worker("1236", "Alka");
		System.out.println("Gross salary: " + w1.calculateGrossSalary(20));
		System.out.println("Net salary: "+ w1.calculateNetSalary(20));
	}	
}

interface Employee{

	double calculateGrossSalary(double n);
	double calculateTax(double n);
	double calculateNetSalary(double n);
}

class Manager implements Employee{
	private String id;
	private String name;
	
	Manager(String id, String name){
		this.id = id;
		this.name = name;
	}

	String getName(){
		return name;
	}
	
	String getId(){
		return id;
	}	

	public double calculateGrossSalary(double n){   //n is number of hours of for which the gross salary is need to be calculated
		if (n>60){
			double grossSalary = 60 * 500;
			return grossSalary;
		}
		double grossSalary = n * 500;
		return grossSalary;
	}
	public double calculateTax(double n){
		if (n>60){
			double grossSalary = calculateGrossSalary(60);
			double taxOutgo = grossSalary * (0.20);
			return taxOutgo;
		}
		double grossSalary = calculateGrossSalary(n);
		double taxOutgo = grossSalary * (0.20);
		return taxOutgo;
	}
	public double calculateNetSalary(double n){
		if (n>60){
			double netSalary = calculateGrossSalary(60) - calculateTax(60);
			return netSalary;
		}
		double netSalary = calculateGrossSalary(n) - calculateTax(n);
		return netSalary;
	}
	
}

class Supervisor implements Employee{
	private String id;
	private String name;
	
	Supervisor(String id, String name){
		this.id = id;
		this.name = name;
	}

	String getName(){
		return name;
	}
	
	String getId(){
		return id;
	}

	public double calculateGrossSalary(double n){   //n is number of hours of for which the gross salary is need to be calculated
		if (n<=40){
			double grossSalary = n* 300;
			return grossSalary;
		}
		else if (n>40 && n<=60){
			double overtime = n-40;
			double grossSalary = (40 * 300) + (overtime * 450);
			return grossSalary;
		}
		else{
			double grossSalary = (40 * 300) + (20 * 450);
			return grossSalary;
		}
	}

	public double calculateTax(double n){
		if (n>60){
			double grossSalary = calculateGrossSalary(60);
			double taxOutgo = grossSalary * (0.20);
			return taxOutgo;
		}
		double grossSalary = calculateGrossSalary(n);
		double taxOutgo = grossSalary * (0.20);
		return taxOutgo;
	}
	public double calculateNetSalary(double n){
		if (n>60){
			double netSalary = calculateGrossSalary(60) - calculateTax(60);
			return netSalary;
		}
		double netSalary = calculateGrossSalary(n) - calculateTax(n);
		return netSalary;
	}

}

class Worker implements Employee{
	private String id;
	private String name;

	Worker(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	String getName(){
		return name;
	}
	
	String getId(){
		return id;
	}
	
	

	public double calculateGrossSalary(double n){   //n is number of hours of for which the gross salary is need to be calculated
		if (n<=40){
			double grossSalary = n* 200;
			return grossSalary;
		}
		else if (n>40 && n<=60){
			double overtime = n-40;
			double grossSalary = (40 * 200) + (overtime * 250);
			return grossSalary;
		}
		else{
			double grossSalary = (40 * 200) + (20 * 250);
			return grossSalary;
		}	
	}

	public double calculateTax(double n){
		if (n>60){
			double grossSalary = calculateGrossSalary(60);
			double taxOutgo = grossSalary * (0.20);
			return taxOutgo;
		}
		double grossSalary = calculateGrossSalary(n);
		double taxOutgo = grossSalary * (0.20);
		return taxOutgo;
	}
	public double calculateNetSalary(double n){
		if (n>60){
			double netSalary = calculateGrossSalary(60) - calculateTax(60);
			return netSalary;
		}
		double netSalary = calculateGrossSalary(n) - calculateTax(n);
		return netSalary;
	}

}
