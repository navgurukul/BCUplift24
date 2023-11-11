public class Exam2{
	public static void main(String[] args){
		Manager m1 = new Manager("1234","Alka Noor");
		m1.calculateGrossSalary(50);
		Manager m2 = new Manager("12345","Kanika");
		m2.calculateGrossSalary(60);
		Manager m3 = new Manager("12346","Ram");
		m3.calculateGrossSalary(70);	

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
	}

}

// x is number of hours in a day
interface Employee{

	double calculateGrossSalary(double x);

	double calculateNetSalary(double x);

	double calculateTax(double x);
	
}


//@override         
class Manager implements Employee{
	
	private String id;
	private String name;
	
	String getName(){
		return name;
	}

	String  getId(){
		return id;
	}

	Manager(String id , String name){
		this.id = id;
		this.name=name;
	}

	public double calculateGrossSalary(double x){
		double grossSalary = x * 500;
		return grossSalary;
	}

	public double calculateTax(double x){
		double grossSalary = calculateGrossSalary(x);
		double taxOutGo = grossSalary * (20);
		return taxOutGo;
	}

	public double calculateNetSalary(double x){
		double grossSalary = calculateGrossSalary(x);
		double taxOutGo = calculateTax(x);
		double netSalary = grossSalary - taxOutGo;
		return netSalary;
	}

}



//@override         
class Supervisor implements Employee{

	private String id;
	private String name;

	Supervisor(String id , String name){
		this.id = id;
		this.name=name;
	}

	String getName(){
		return name;
	}

	String  getId(){
		return id;
	}

	public double calculateGrossSalary(double x){
		
		double grossSalary = (x*300)+(x-40)*450; 
		//(x-40) is extra time work hours
		return grossSalary;		
	}

	public double calculateTax(double x){
		if (x>60){
			double grossSalary = calculateGrossSalary(60);
			double taxOutGo = grossSalary*(0.20);    
			return taxOutGo;
		}
		double grossSalary = calculateGrossSalary(x);
		double taxOutGo = grossSalary*20;
		return taxOutGo;
	}

	public double calculateNetSalary(double x){
		if(x>60){
			double netSalary = calculateGrossSalary(60) - calculateTax(60);
			return netSalary;
		}
		double netSalary = calculateGrossSalary(x) - calculateTax(x);
		return netSalary;
	}


}



//@override         
class Worker implements Employee{
	
	private String id;
	private String name;

	String getName(){
		return name;
	}

	String  getId(){
		return id;
	}

	Worker(String id , String name){
		this.id = id;
		this.name=name;
	}

	public double calculateGrossSalary(double x){
		double grossSalary = x * 200+(x-40)*300;
		return grossSalary;
		
	}

	public double calculateTax(double x){
		double grossSalary = calculateGrossSalary(x);
		double taxOutGo = grossSalary*10;
		return taxOutGo;
	}
	
	public double calculateNetSalary(double x){
		double netSalary = grossSalary-taxOutGo;
		double taxOutGo = calculateTax(x);
		double netSalary = grossSalary - taxOutGo;
		return netSalary ;
	}

}


/*class ViolationReport{
	ArrayList<Employee> reportlist = new ArrayList<Employee>();
	
	
}*/
