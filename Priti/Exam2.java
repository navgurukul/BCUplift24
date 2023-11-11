interface Employee {
	double calculateGrossSalary(int workingHour);
    	double calculateNetSalary();
    	double tax();
}

class Manager implements Employee {
    	private int id;
    	private String name;
	private double grocessSalary;
    	Manager(int id, String name) {
        	this.id = id;
        	this.name = name;
   	}

    	@Override
    	public double calculateGrossSalary(int workingHour) {
			
        	if (workingHour > 40 && workingHour <= 60) {
			this.grocessSalary = grocessSalary + 40* 500;;
			Company.addSalary(grocessSalary);
            		return grocessSalary;
        	}
        	return 0; 
    	}

   	 @Override
    	public double calculateNetSalary() {
        	return grocessSalary - tax(); 
    	}

   	 @Override
    	public double tax() {
        	return grocessSalary * 0.30; 
    	}
}

class Supervisor implements Employee {
    	private int id;
    	private String name;
	private double grocessSalary;
    	Supervisor(int id, String name) {
        	this.id = id;
        	this.name = name;
    	}

    	@Override
    	public double calculateGrossSalary(int workingHour) {
        	if (workingHour > 40 && workingHour <= 60) {
			this.grocessSalary = grocessSalary+((workingHour - (workingHour - 40) * 300) + ((workingHour - 40) * 450));
            		Company.addSalary(grocessSalary);
            		return grocessSalary;
        	}
        	return 0; 
    	}

    	@Override
    	public double tax() {
        	return grocessSalary* 0.20;
    	}

    	@Override
    	public double calculateNetSalary() {
        	return grocessSalary - tax();
    	}
}

class Worker implements Employee {
    	private int id;
    	private String name;
    	private double salaryPerHour = 200.0;
    	private double grocessSalary;

    	Worker(int id, String name) {
        	this.id = id;
        	this.name = name;
    	}

    	@Override
    	public double calculateGrossSalary(int workingHour) {
        	if (workingHour >= 40 && workingHour <= 60) {
			this.grocessSalary = grocessSalary + (workingHour - (workingHour - 40) * 200) + (workingHour - 40) * 300;
			Company.addSalary(grocessSalary);
            		return grocessSalary;
        	}
        	return 0; 
    	}

    	@Override
    	public double calculateNetSalary() {

		Company.addSalary(grocessSalary - tax());
        	return grocessSalary - tax(); 
    	}

    	@Override
    	public double tax() {
		Company.addSalary(grocessSalary * 10);
        	return grocessSalary  * 10; 
    	}
	
	
	
}
class Company{
	private static double totalSalary = 0;
	public static void addSalary(double salary){
		totalSalary += salary;
	}
	public static double getTotalSalary(){
		return totalSalary;
	}

}

public class Exam2 {
	
    	public static void main(String[] args){
		Manager emp1 = new Manager(101 , "Em1");
		emp1.calculateGrossSalary(43);
		emp1.calculateNetSalary();
		emp1.tax();
		

		Supervisor emp2 = new Supervisor(102 , "Emp2");
		emp2.calculateGrossSalary(43);
		emp2.calculateNetSalary();
		emp2.tax();

		Supervisor emp3 = new Supervisor(102 , "Emp3");
		emp3.calculateGrossSalary(43);
		emp3.calculateNetSalary();
		emp3.tax();

		
		Worker emp4 = new Worker (102 , "Emp4");
		emp4.calculateGrossSalary(43);
		emp4.calculateNetSalary();
		emp4.tax();

		
		Worker emp5 = new Worker(102 , "Emp5");
		emp5.calculateGrossSalary(43);
		emp5.calculateNetSalary();
		emp5.tax();
		
		
		Worker emp6 = new Worker (102 , "Emp6");
		emp6.calculateGrossSalary(43);
		emp6.calculateNetSalary();
		emp6.tax();
		
		Worker emp7 = new Worker (102 , "Emp7");
		emp7.calculateGrossSalary(43);
		emp7.calculateNetSalary();
		emp7.tax();
	
				
		Worker emp8 = new Worker (102 , "Emp8");
		emp8.calculateGrossSalary(43);
		emp8.calculateNetSalary();
		emp8.tax();

		Worker emp9 = new Worker (102 , "Emp9");
		emp9.calculateGrossSalary(43);
		emp9.calculateNetSalary();
		emp9.tax();
	
		Worker emp10 = new Worker (102 , "Emp10");
		emp10.calculateGrossSalary(43);
		emp10.calculateNetSalary();
		emp10.tax();

		Worker emp11 = new Worker (102 , "Emp11");
		emp11.calculateGrossSalary(43);
		emp11.calculateNetSalary();
		emp11.tax();

		Worker emp12 = new Worker (102 , "Emp12");
		emp12.calculateGrossSalary(43);
		emp12.calculateNetSalary();
		emp12.tax();

		Worker emp13 = new Worker (102 , "Emp13");
		emp13.calculateGrossSalary(43);
		emp13.calculateNetSalary();
		emp13.tax();

		System.out.println("Total Salary outgo from Company to pay all its employees"+" "+Company.getTotalSalary());
		

		
		


		
	}
}
