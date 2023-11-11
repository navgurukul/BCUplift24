import java.util.ArrayList;
//import java.util.Math;
class Employee{
	private int id;
	private String name;
	//private  String designation;
	//private  int workingHours;
	//private String extraWorkHours;
	public Employee(int id, String name){
		this.id=id;
		this.name=name;
		//this.designation=designation;
		//this.workingHours=workingHours;
		//this.extraWorkHours=extraWorkHours;
	}

}

class  Manager extends Employee{
	private  String designation;
	private  int workingHours;
	private int extraWorkHours;


	public Manager(int id, String name,String designation, int workingHours, int extraWorkHours){
		super(id,name);
		this.designation=designation;

		this.workingHours=workingHours;
		this.extraWorkHours=extraWorkHours;
	}

//Gross salary = number of working hours * 500 (salary only based on 40 hours, no pay for overtime)
//Tax outgo = Gross salary *.30
//Net salary = Gross salary - tax outgo
	public int getcalculateGrossSalary(){
		//int result=workingHours*500;
		//return ((workingHours)*int(500));
		return workingHours*500;

	}
	public int  getcalculateNetSalary(){
		return workingHours;
		
	}
	

	public int getcalculateTax(){
		return workingHours;
		


	}


}

class Supervsior extends Employee{

	private  String designation;
	private  int workingHours;
	private int extraWorkHours;



	public Supervsior(int id, String name,String designation, int workingHours, int extraWorkHours){
		super(id,name);
		this.designation=designation;
		this.workingHours=workingHours;
		this.extraWorkHours=extraWorkHours;
	}

//Gross salary = number of working hours * 300 + extra time work hours * 450 (1.5 times base hourly salary)
//Tax outgo = Gross salary *.20
//Net salary = Gross salary - tax outgo
//extraWorkHours

	public int getcalculateGrossSalary(){
		//int result=workingHours*500;
		//return ((workingHours)*int(500));
		return workingHours*500;

	}
	public int  getcalculateNetSalary(){
		return workingHours;
		
	}
	

	public int getcalculateTax(){
		return workingHours;
		


	}
} 

class Worker extends Employee{

	private  String designation;
	private  int workingHours;
	private int extraWorkHours;


	public Worker(int id, String name,String designation, int workingHours, int  extraWorkHours){
		super(id,name);
		this.designation=designation;
		this.workingHours=workingHours;
		this.extraWorkHours=extraWorkHours;
	}

//Gross salary = number of working hours * 200 + extra time work hours * 300 (1.5 times base hourly salary)
//Tax outgo = Gross salary *.10
//Net salary = Gross salary - tax outgo
	public int getcalculateGrossSalary(){
		//int result=workingHours*500;
		//return ((workingHours)*int(500));
		return workingHours*500;

	}
	public int  getcalculateNetSalary(){
		return workingHours;
		
	}
	

	public int getcalculateTax(){
		return workingHours;
		


	}

} 
public class Exam2{
	public static void main(String[] args) {
		//int id, String name,String designation, int workingHours, int extraWorkHours
		Manager manager= new Manager(1,"head","lead",40,10);
		System.out.println(manager);
		//manager.getcalculateGrossSalary();
		System.out.println(("Manager GrossSalary"+" " +manager.getcalculateGrossSalary()*500));
		Supervsior supervsior = new Supervsior(101,"sub_head","sub_lead",40,10);
		System.out.println(supervsior);
		System.out.println(("Supervsior grossSalary"+" " +supervsior.getcalculateGrossSalary()*300));
		Worker  worker = new Worker(111,"worker1","work",35,5);
		System.out.println(worker);
		System.out.println(("worker grossSalary"+" "+worker.getcalculateGrossSalary()*200));

		
	}
}
