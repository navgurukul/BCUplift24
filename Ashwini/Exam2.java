interface Employee {
	double calculateGrossSalary();

    	double calculateTax(double grossSalary);

    	double calculateNetSalary(double grossSalary, double tax);
}

class Manager implements Employee {
    	protected int hoursWorked;
	protected int id;
	protected String name;
	protected String designation;

    	public Manager(int id,String name,String designation, int hoursWorked) {
		this.id = id;
		this.name = name;
		this.designation = designation;
     		this.hoursWorked = hoursWrked;
		
    	}
    	double calculateGrossSalary(){
		if (hourworked <=40){
			return hourworked * 500;
		}
		else{
			return 40*500;
		}
	
	}
	public double getGrossSalary(){
		this.grossSalary = calculateGrossSalary();
	}
	
	double calculateTax(double grossSalary){
		return grossSalary*0.3;
	}
	double calculateNetSalary(double grossSalary, double tax){
		return grossSalary-tax;
	}
}

class Supervisor implements Employee {
    
    	protected int hoursWorked;
	protected int id;
	protected String name;
	protected string designation;

    	public Supervisor(int id,String name,String designation, int hourWorked) {
		this.id = id;
		this.name = name;
		this.designation = designation;
       		this.hoursWorked = hoursWrked;
	}
	double calculateGrossSalary(){
		if (hoursWorked<=40){
			return hoursWorked*300;
		}
		else{
			return (40*300)+(hoursWorked-40*450);
		}
	}
	
	double calculateTax(double grossSalary){
		return grossSalary*0.2;
	}
	double calculateNetSalary(double grossSalary, double tax){
		return grossSalary-tax;
	}


	

}

class Worker implements Employee {
    	protected int hoursWorked;
	protected int iD;
	protected String name;
	protected string designation;

    	public Worker(int id,String name,String designation, int hoursWorked) {
		this.id = id;
		this.name = name;
		this.designation = designation;
        	this.hoursWorked = hoursWrked;
		
    	}
	double calculateGrossSalary(){
		if (hoursWorked<=40){
			return hoursWorked*300;
		}
		else{
			return (40*300)+(hoursWorked-40*450);
		}
	}
	
	double calculateTax(double grossSalary){
		return grossSalary*0.2;
	}
	double calculateNetSalary(double grossSalary, double tax){
		return grossSalary-tax;
	}
}

class PayrollSystem {
    	private ArrayList<> employees;
    	private List<String> labourDeptViolationReport;

    	public PayrollSystem() {
        	this.employees = new ArrayList<>();
        	this.labourDeptViolationReport = new ArrayList<>();
     
    	}

    	private void initializeEmployees() {
        	employees.add(new Manager(2, "Ram","Manager", 38));
        	employees.add(new Supervisor(5, "Radha","Supervisor",45));
		employees.add(new Supervisor(6, "Raj","Supervisor",53));
		employees.add(new Worker(10, "Mohit","Worker",58 ));
		employees.add(new Worker(1, "Ashwini","Worker",65 ));
		employees.add(new Worker(2, "Rukshana","Worker",58 ));
		employees.add(new Worker(3, "sunny","Worker",58 ));
		employees.add(new Worker(4, "Sreekanay","Worker",58 ));
		employees.add(new Worker(5, "Rohit","Worker",58 ));
		employees.add(new Worker(6, "Shreshta","Worker",58 ));
		employees.add(new Worker(7, "Deepak","Worker",58 ));
		employees.add(new Worker(8, "Harsha","Worker",58 ));
		employees.add(new Worker(9, "Dipti","Worker",58 ));
	}
	for(int i=0; i<employee.size(); i++){
		if (employee.get(i).hoursWorked > 60){
			labourDeptViolationReport.add(employee.get(i));
		}
	}
}





class Exam2{
	public static void main(String[] args){
		//private List<String> labourDeptViolationReport=new ArrayList<>();
		Manager m1 = new Manager(2, "Samir","Manager", 38 );
		System.out.println(m1.calculateGrossSalary());
	}
}    