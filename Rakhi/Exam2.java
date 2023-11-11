import java.util.ArrayList;
import java.util.Scanner; 

public class Exam2{
	public static void main(String args[]){
		double companyPay=0;
		Manager m1=new Manager("m1","Rohan",50,"Manager");
		companyPay=companyPay+(m1.calculateGrossSalary());


		Supervisor s1=new Supervisor("s1","Sohan",80,"Supervisor");
		companyPay=companyPay+(s1.calculateGrossSalary());
		Supervisor s2=new Supervisor("s1","Mohan",40,"Supervisor");
		companyPay=companyPay+(s2.calculateGrossSalary());
		
		for(int i=0;i<10;i++){
			Scanner input=new Scanner(System.in);
			System.out.println("Enter worker id");
			String id=input.nextLine();
			System.out.println("Enter worker name");
			String name=input.nextLine();
			System.out.println("Enter worker working noOfHours");
			int numberOfHours=input.nextInt();
			Worker w1=new Worker(id,name,numberOfHours,"Worker");
			companyPay=companyPay+(w1.calculateGrossSalary());
		}
		
		Worker w1=new Worker("w1","Anuj",30,"Worker");

		System.out.println(m1.calculateGrossSalary());
		System.out.println(m1.calculateNetSalary());
		System.out.println(m1.calculateTax());

		System.out.println(s1.calculateGrossSalary());
		System.out.println(s1.calculateNetSalary());
		System.out.println(s1.calculateTax());

		System.out.println(w1.calculateGrossSalary());
		System.out.println(w1.calculateNetSalary());
		System.out.println(w1.calculateTax());

		System.out.println("total cost to the comapny to pay Weekly: "+companyPay);


	}

}

interface Employee{
	public double calculateGrossSalary();
	public double calculateNetSalary();
	public double calculateTax();

}

abstract class Default implements Employee{
	private String id;
	private String name;
	private int numberOfHours;
	private String designation;
	public ArrayList<String> labourDeptViolationList=new ArrayList<String>();

	Default(String id,String name,int numberOfHours,String designation){
		this.id=id;
		this.name=name;
		this.numberOfHours=numberOfHours;
		this.designation=designation;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id=id;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public int getNumberOfHours(){
		return numberOfHours;
	}
	
	public void setNumberOfHours(int numberOfHours){
		this.numberOfHours=numberOfHours;
	}

	public void setDesignation(String designation){
		this.designation=designation;
	}

	public double calculateGrossSalary(){
		return 0.0;
	}
	public  double calculateNetSalary(){
		return 0.0;

	}
	public double calculateTax(){
		return 0.0;

	}


}

class Manager extends Default implements Employee{
	
	Manager(String id,String name,int numberOfHours,String designation){
		super(id,name,numberOfHours,designation);
	}


	public double calculateGrossSalary(){
		return getNumberOfHours()*500;
	}

	public double calculateNetSalary(){
		return calculateGrossSalary()-calculateTax();

	}
	public double calculateTax(){
		return calculateGrossSalary()*0.30;
	}
}


class Supervisor extends Default implements Employee{

	Supervisor (String id,String name,int numberOfHours,String designation){
		super(id,name,numberOfHours,designation);
	}
	
	public double calculateGrossSalary(){
		if(getNumberOfHours()<=60){
			return getNumberOfHours()*300+((getNumberOfHours()-40)*450);
		}
		else{
			labourDeptViolationList.add(getName());
			return 60*300+((60-40)*450);
		}
	}

	public double calculateNetSalary(){
		return calculateGrossSalary()-calculateTax();

	}
	public double calculateTax(){
		return calculateGrossSalary()*0.20;
	}
}



class Worker extends Default implements Employee{

	Worker(String id,String name,int numberOfHours,String designation){
		super(id,name,numberOfHours,designation);
	}
	
	public double calculateGrossSalary(){
		if(getNumberOfHours()<=60){
			return getNumberOfHours()*200+((getNumberOfHours()-40)*300);
		}
		else{
			labourDeptViolationList.add(getName());
			return 60*200+((60-40)*300);
		}
	}

	public double calculateNetSalary(){
		return calculateGrossSalary()-calculateTax();
	}
	public double calculateTax(){
		return calculateGrossSalary()*0.10;
	}
}

