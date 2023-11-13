interface Employee{
	
	double getCalculateGrossSalary();
	double getCalculateNateSalary();
	double getCalculateTax();
}

class Manager implements Employee {

	private float numberOfWorkingHours;
	private int id;
	private String name;
	
	
	Manager(float numberOfWorkingHours,int id,String name){
		this.numberOfWorkingHours = numberOfWorkingHours;
		this.id = id;
		this.name = name;
	}
	
	public float getNumberOfWorkingHours(){
		return numberOfWorkingHours;
	}
	


	@Override 
	public double getCalculateGrossSalary(){
		
		if (getNumberOfWorkingHours() > 60){
			double grossSalary = 60 * 500;
			//System.out.println(" OverTime is more than 60 hours");
			return grossSalary;
			
		}else {
			double grossSalary = getNumberOfWorkingHours() * 500;
			return grossSalary;
		}
		
	}

	@Override
	public double getCalculateTax(){
		double tax = getCalculateGrossSalary() *.30;
		return tax;
	}

	@Override
	public double getCalculateNateSalary(){
		double netSalary = getCalculateGrossSalary() - getCalculateTax();
		return netSalary;
	}

	
}
class Supervisor implements Employee {

	private float numberOfWorkingHours;
	private int id;
	private String name;
	
	
	Supervisor(float numberOfWorkingHours,int id,String name){
		this.numberOfWorkingHours = numberOfWorkingHours;
		this.id = id;
		this.name = name;
	}
	
	public float getNumberOfWorkingHours(){
		return numberOfWorkingHours;
	}
	


	@Override 
	public double getCalculateGrossSalary(){
		if (getNumberOfWorkingHours() > 60){
			double grossSalary = 40 * 300 + 20 * 450;
			//System.out.println(" OverTime is morethan 60 hours");
			return grossSalary;
		} else {
			double grossSalary = 40 * 300 + getNumberOfWorkingHours() - 40 * 450 ;
			return grossSalary;
		}
	}

	@Override
	public double getCalculateTax(){
		double tax = getCalculateGrossSalary() *.30;
		return tax;
	}

	@Override
	public double getCalculateNateSalary(){
		double netSalary = getCalculateGrossSalary() - getCalculateTax();
		return netSalary;
	}

	
}

class Worker implements Employee {

	private float numberOfWorkingHours;
	private int id;
	private String name;
	
	
	Worker(float numberOfWorkingHours,int id,String name){
		this.numberOfWorkingHours = numberOfWorkingHours;
		this.id = id;
		this.name = name;
	}
	
	public float getNumberOfWorkingHours(){
		return numberOfWorkingHours;
	}
	


	@Override 
	public double getCalculateGrossSalary(){
		if (getNumberOfWorkingHours() > 60){
			double grossSalary = 40 * 200 + 20 * 300;
			//System.out.println(" OverTime is more than 60 hours");
			return grossSalary;
		} else {
			double grossSalary = 40 * 200 + getNumberOfWorkingHours() - 40 * 300 ;
			return grossSalary;
		}
	}

	@Override
	public double getCalculateTax(){
		double tax = getCalculateGrossSalary() *.30;
		return tax;
	}

	@Override
	public double getCalculateNateSalary(){
		double netSalary = getCalculateGrossSalary() - getCalculateTax();
		return netSalary;
	}

	
}

public class Exam2{
	public static void main(String[] args){
		
		Manager detail1 = new Manager(61f , 4 ,"Nia");
		
		System.out.println("Gross Salary :- " + detail1.getCalculateGrossSalary());
		System.out.println("Tax out go :- " + detail1.getCalculateTax());
		System.out.println("Net Salary :- " + detail1.getCalculateNateSalary());
	}
}	