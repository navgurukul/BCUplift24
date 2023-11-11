interface Employee{
	public double GrossSalary();
	//public double NetSalary();
	//public double Tax();
}

class calculatedGrossSalary implements Employee{
	private String designation;
	private double numberOfWorkingHours;

	calculatedGrossSalary(String designationOfEmployee, double employeeWorkingHours){
		this.designation = designationOfEmployee;
		this.numberOfWorkingHours = employeeWorkingHours;
	}

	public double GrossSalary(){
		double grossSal = 0;
		if(designation == "Supervisor"){
			if(numberOfWorkingHours < 160){
				grossSal = numberOfWorkingHours*300;
			}
			else{
				double extraHours = numberOfWorkingHours - 160;
				double hours = numberOfWorkingHours - extraHours;
				grossSal = hours*300 + extraHours*450;
			}
		}
		else if(designation == "Worker"){
			if(numberOfWorkingHours < 160){
				grossSal = numberOfWorkingHours*200;
			}
			else{
				double extraHours = numberOfWorkingHours - 160;
				double hours = numberOfWorkingHours - extraHours;
				grossSal = hours*200 + extraHours*300;
			}

		}
		else if(designation == "Manager"){
			if(numberOfWorkingHours < 160){
				grossSal = numberOfWorkingHours*500;
			}
			else{
				double extraHours = numberOfWorkingHours - 160;
				double hours = numberOfWorkingHours - extraHours;
				grossSal = hours*500 + extraHours*0;
			}

		}
		else{
			System.out.println("This post is not in this company");
		}

		return grossSal;
	}

}

/*class calculatedTax implements Employee{
	private String designation;
	private double numberOfWorkingHours;
	private double grossSalary;

	calculatedTax(String designationOfEmployee, double employeeWorkingHours, double grossSalary){
		this.designation = designationOfEmployee;
		this.numberOfWorkingHours = employeeWorkingHours;
		this.grossSalary = grossSalary;
	}

	public double Tax(){
		double taxOutgo = 0;
		if(designation == "Supervisor"){
			taxOutgo = grossSalary *0.20;
		}
		return taxOutgo;
	}
	
}

class calculatedNetSalary implements Employee{
	
}*/

public class EmployeeData{
	public static void main(String[] args){
		Employee emp = new calculatedGrossSalary("Supervisor", 170);
		Employee emp1 = new calculatedGrossSalary("Worker", 180);
		Employee emp2 = new calculatedGrossSalary("Supervisor", 170);
	
		System.out.println(emp.GrossSalary());
		System.out.println(emp1.GrossSalary());
		System.out.println(emp2.GrossSalary());
	}
}