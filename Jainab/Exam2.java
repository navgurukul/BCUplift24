class Exam2{
	public static void main(String [] args){
		Manager m1=new Manager("M101", "jainab", 40);
		System.out.println(m1.calculateGrossSalary());
		System.out.println(m1.calculateNetSalary());
		System.out.println(m1.calculateTaxOutgo());
		
		//SuperVisor s1= new SuperVisor("S101","Kashvi", 10, 30);
		//System.out.println(s1.calculateGrossSalary());
	}

}
interface Employee{


	public double calculateGrossSalary();
	public double calculateNetSalary();
	public double calculateTaxOutgo();

}
class Manager implements Employee{
	private String employeeId;
	private String name;
	
	private int workingHours;

	Manager(String employeeId, String name,  int workingHours){
		this.name=name;
		this.employeeId=employeeId;
		
		this.workingHours=workingHours;

	public double calculateGrossSalary(){
		
		return workingHours*500;
		
	}
	public double calculateTaxOutgo(){
		return calculateGrossSalary()*30/100;
	}
	public double calculateNetSalary(){
		return calculateGrossSalary()-calculateTaxOutgo();
	}

}
class SuperVisor implements Employee{
	private String employeeId;
	private String name;
	
	private int workingHours;

	SuperVisor(String employeeId, String name,  int workingHours){
		this.name=name;
		this.employeeId=employeeId;
		
		this.workingHours=workingHours;
	}
	public double calculateGrossSalary(){
		if(workingHours>40){
			int extraHours=workingHours-40;
			return workingHours*300 + extraHours*450;
		}else{
			return workingHours*450;
		}
	}
	public double calculateTaxOutgo(){
		return calculateGrossSalary()*20/100 + extraHours*450;
	}
	public double calculateNetSalary(){
		return calculateGrossSalary()-calculateTaxOutgo();
	}


}
class Worker implements Employee{
	private String employeeId;
	private String name;
	
	private int workingHours;

	Worker(String employeeId, String name,  int workingHours){
		this.name=name;
		this.employeeId=employeeId;
		
		this.workingHours=workingHours;
	}
	public double calculateGrossSalary(){
		if(workingHours>40){
			int extraHours=workingHours-40;
			return workingHours*200 + extraHours*300;
		}else{
			return workingHours*200;
		}
	}
	public double calculateTaxOutgo(){
		return calculateGrossSalary()*10/100 + extraHours*300;
	}
	public double calculateNetSalary(){
		return calculateGrossSalary()-calculateTaxOutgo();
	}

}
