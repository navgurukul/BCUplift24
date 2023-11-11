import java.util.ArrayList;

public class Exam2{
	public static void main(String main[]){
	




	Employee workerobj = new Workers();
	System.out.println("Worker's gross salary is: "+workerobj.calculateGrossSalary(5,"sam","Worker",25));
	System.out.println("Worker's Calculated tax is: "+workerobj.calculateTax(5,"sam","Worker",25));	
	System.out.println("Worker's Net salary  is: "+workerobj.calculateNetSalary(5,"sam","Worker",25));
		
	Employee supervisor_object = new Supervisor();
	System.out.println("Supervisor's gross salary is: "+supervisor_object.calculateGrossSalary(6,"john","Worker",45));
	System.out.println("Supervisor's gross salary is: "+supervisor_object.calculateTax(6,"john","Worker",65));
	System.out.println("Supervisor's gross salary is: "+supervisor_object.calculateNetSalary(6,"john","Worker",45));

	Employee manager_object = new Manager();
	System.out.println("Manager's gross salary is: "+manager_object.calculateGrossSalary(7,"Alice","Worker",65));
	System.out.println("Manager's gross salary is: "+manager_object.calculateTax(7,"Alice","Worker",65));
	System.out.println("Manager's gross salary is: "+manager_object.calculateNetSalary(7,"Alice","Worker",65));
	
	}

}



interface Employee{

	public int calculateGrossSalary(int employeeId, String name , String designation,int workinghours);
	public double calculateTax(int employeeId, String name , String designation,int workinghours);
	public double calculateNetSalary(int employeeId, String name , String designation,int workinghours);
	

}



class Workers implements Employee{
	@Override
	public int calculateGrossSalary(int employeeId, String name , String designation,int workinghours){
		int gross_salary=0;
		if(workinghours<=40){
			gross_salary = workinghours*200;

		}else if(workinghours>40 && workinghours<=60){
			gross_salary = 40*200+(workinghours-40)*250;


		}else{
			gross_salary = 40*200+20*250;
	
						

		}
		return gross_salary;
		
	}

	
	@Override
	public double calculateTax(int employeeId, String name , String designation,int workinghours){
		double temp = calculateGrossSalary(employeeId,name ,designation,workinghours);
		return temp*0.10;
	}



	@Override
	public double calculateNetSalary(int employeeId, String name , String designation,int workinghours){
		double temp = calculateGrossSalary(employeeId,name ,designation,workinghours)-calculateTax(employeeId,name ,designation,workinghours);
		return temp;
	}

}




class Supervisor implements Employee{
	

	@Override
	public int calculateGrossSalary(int employeeId, String name , String designation,int workinghours){
		int gross_salary=0;
		if(workinghours<=40){
			gross_salary = workinghours*300;

		}else if(workinghours>40 && workinghours<=60){
			gross_salary = 40*300+(workinghours-40)*450;


		}else{
			gross_salary = 40*300+20*450;
		}
		return gross_salary;
		
	}

	
	@Override
	public double calculateTax(int employeeId, String name , String designation,int workinghours){
		double temp = calculateGrossSalary(employeeId,name ,designation,workinghours);
		return temp*0.20;
	}



	@Override
	public double calculateNetSalary(int employeeId, String name , String designation,int workinghours){
		double temp = calculateGrossSalary(employeeId,name ,designation,workinghours)-calculateTax(employeeId,name ,designation,workinghours);
		return temp;
	}

}



class Manager implements Employee{
	

	@Override
	public int calculateGrossSalary(int employeeId, String name , String designation,int workinghours){
		int gross_salary=0;
		gross_salary = 500*workinghours;
		return gross_salary;
		
	}

	
	@Override
	public double calculateTax(int employeeId, String name , String designation,int workinghours){
		double temp = calculateGrossSalary(employeeId,name ,designation,workinghours);
		return temp*0.30;
	}



	@Override
	public double calculateNetSalary(int employeeId, String name , String designation,int workinghours){
		double temp = calculateGrossSalary(employeeId,name ,designation,workinghours)-calculateTax(employeeId,name ,designation,workinghours);
		return temp;
	}

}


class EmployeeDetails{
	private String name;
	private String designation;
	private int id;

	public EmployeeDetails(int employeeid, String name,String designation){
		this.id = employeeid;
		this.name = name;
		this.designation = designation;
	}


	public String getId(){
		String employeeid = String.valueOf(id);
		return employeeid;
	}

	public String getName(){
		return name;
	}

	public String getDesignation(){
		return designation;
	}

}




