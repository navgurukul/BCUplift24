
import java.util.*;
import java.util.ArrayList;

interface Employee{
	double calculateGrossSalary();
	double calculateNetSalary();
	double calculateTax();
        
}

class Manager implements Employee{

	private int id;
	private String name;
	private int workingHrs;
		

	public Manager(int id, String name,int workingHrs)
	{
	  this.id = id;
	  this.name = name;
	  this.workingHrs = workingHrs;
	 
	}

	public double calculateGrossSalary()
	{
	 
	   double grossSalary = workingHrs * 500;
	    return grossSalary;
	}



	public double calculateNetSalary()
	{
          double netSalary = calculateGrossSalary() - calculateTax();
	   return netSalary;

	}

	public double calculateTax()
	{
	  double taxOutgo =  calculateGrossSalary() * 30/100;
	  return taxOutgo;
	}

	public void isAddInViolation(ArrayList<String> labourDeptViolationReportList )
	{
	  if(workingHrs > 60)
	  {
	     labourDeptViolationReportList.add(name);
	  }
	  
	}
	

	

}




class Supervisor implements Employee{

	private int id;
	private String name;
	private int workingHrs;
	private int extraTimeWorkingHrs;
	
	public Supervisor(int id, String name,int workingHrs,int extraTimeWorkingHrs)
	{
	  this.id = id;
	  this.name = name;
	  this.workingHrs = workingHrs;
	  this.extraTimeWorkingHrs = extraTimeWorkingHrs;
	}


	public double calculateGrossSalary()
	{
	   double GrossSalary = (workingHrs * 300)+ (extraTimeWorkingHrs * 450);
	   return GrossSalary;
	}

	public double calculateNetSalary()
	{
	   double netSalary = calculateGrossSalary() - calculateTax();
	   return netSalary;
	}

	public double calculateTax()
	{
	   double taxOutgo = calculateGrossSalary() * 20/100;
	   return taxOutgo;
	}

	public void isAddInViolation(ArrayList<String> labourDeptViolationReportList )
	{
	  if(workingHrs > 60)
	  {
	     labourDeptViolationReportList.add(name);
	  }
	  
	}
	
		

}






class Worker implements Employee{

	private int id;
	private String name;
	private int workingHrs;
	private int extraTimeWorkingHrs;

	public Worker(int id, String name,int workingHrs,int extraTimeWorkigHrs)
	{
	  this.id = id;
	  this.name = name;
	  this.workingHrs = workingHrs;
	  this.extraTimeWorkingHrs = extraTimeWorkingHrs;
	}

	public double calculateGrossSalary()
	{
	     double grossSalary = (workingHrs * 200)+ (extraTimeWorkingHrs * 300);
	   return grossSalary;

	}

	public double calculateNetSalary()
	{
	   double netSalary = calculateGrossSalary() - calculateTax();
	   return netSalary;

	}

	public double calculateTax()
	{
	  double taxOutgo = calculateGrossSalary() * 10/100;
	  return taxOutgo;
	}

	public void isAddInViolation(ArrayList<String> labourDeptViolationReportList )
	{
	  if(workingHrs > 60)
	  {
	     labourDeptViolationReportList.add(name);
	  }
	 
	}
		
}



public class Exam2{

	public static void main(String[] args)
	{

	  ArrayList<String> labourDeptViolationReportList = new ArrayList<String>();


	  Manager m1 = new Manager(101,"John",30);
	  Manager m2 = new Manager(102,"Alen",40);

	  Supervisor s1 = new Supervisor(201,"Vaishnavi",45,6);
	  Supervisor s2 = new Supervisor(201,"Jhanavi",40,5);

	  Worker w1  = new Worker(301,"Riya",15,0);
	  Worker w2  = new Worker(302,"Sakshi",33,5);
	  Worker w3  = new Worker(303,"Yamini",25,0);
	  Worker w4  = new Worker(304,"Nikita",29,4);
	  Worker w5  = new Worker(305,"Sayali",50,15);
	  Worker w6  = new Worker(306,"Harsha",45,8);
	  Worker w7  = new Worker(307,"Neha",30,7);
	  Worker w8  = new Worker(308,"Pranjali",38,3);
	  Worker w9  = new Worker(309,"Rani",28,4);
	  Worker w10  = new Worker(310,"Aishwary",42,20);


	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Manager m1 is : ");

	
	  System.out.println( m1.calculateGrossSalary());
	  System.out.println( m1.calculateTax());
	  System.out.println( m1.calculateNetSalary());
	  m1.isAddInViolation(labourDeptViolationReportList);
	  

	  
	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Manager m2 is : ");

	
	  System.out.println( m2.calculateGrossSalary());
	  System.out.println( m2.calculateTax());
	  System.out.println( m2.calculateNetSalary());
	  m2.isAddInViolation(labourDeptViolationReportList);

	 
	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Supervisor s1 is : ");

	
	  System.out.println( s1.calculateGrossSalary());
	  System.out.println( s1.calculateTax());
	  System.out.println( s1.calculateNetSalary());
	  s1.isAddInViolation(labourDeptViolationReportList);


	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Supervisor s2 is : ");

	  System.out.println( s2.calculateGrossSalary());
	  System.out.println( s2.calculateTax());
	  System.out.println( s2.calculateNetSalary());
	  s2.isAddInViolation(labourDeptViolationReportList);

	 	
          System.out.println("Gross Salary, TaxOutgo and NetSalary of Worker w1 is : ");

	  System.out.println( w1.calculateGrossSalary());
	  System.out.println( w1.calculateTax());
	  System.out.println( w1.calculateNetSalary());
	  w1.isAddInViolation(labourDeptViolationReportList);

	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Worker w2 is : ");

	  System.out.println( w2.calculateGrossSalary());
	  System.out.println( w2.calculateTax());
	  System.out.println( w2.calculateNetSalary());
	  w2.isAddInViolation(labourDeptViolationReportList);

	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Worker w3 is : ");

	  System.out.println( w3.calculateGrossSalary());
	  System.out.println( w3.calculateTax());
	  System.out.println( w3.calculateNetSalary());
	  w3.isAddInViolation(labourDeptViolationReportList);

	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Worker w4 is : ");

	  System.out.println( w4.calculateGrossSalary());
	  System.out.println( w4.calculateTax());
	  System.out.println( w4.calculateNetSalary());
	  w4.isAddInViolation(labourDeptViolationReportList);

	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Worker w5 is : ");

	  System.out.println( w5.calculateGrossSalary());
	  System.out.println( w5.calculateTax());
	  System.out.println( w5.calculateNetSalary());
	  w5.isAddInViolation(labourDeptViolationReportList);

	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Worker w6 is : ");

	  System.out.println( w6.calculateGrossSalary());
	  System.out.println( w6.calculateTax());
	  System.out.println( w6.calculateNetSalary());
	  w6.isAddInViolation(labourDeptViolationReportList);

	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Worker w7 is : ");

	  System.out.println( w7.calculateGrossSalary());
	  System.out.println( w7.calculateTax());
	  System.out.println( w7.calculateNetSalary());
	  w7.isAddInViolation(labourDeptViolationReportList);

	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Worker w8 is : ");

	  System.out.println( w8.calculateGrossSalary());
	  System.out.println( w8.calculateTax());
	  System.out.println( w8.calculateNetSalary());
	  w8.isAddInViolation(labourDeptViolationReportList);

	
	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Worker w9 is : ");

	  System.out.println( w9.calculateGrossSalary());
	  System.out.println( w9.calculateTax());
	  System.out.println( w9.calculateNetSalary());
	  w9.isAddInViolation(labourDeptViolationReportList);

	  
	  System.out.println("Gross Salary, TaxOutgo and NetSalary of Worker w10 is : ");

	  System.out.println( w10.calculateGrossSalary());
	  System.out.println( w10.calculateTax());
	  System.out.println( w10.calculateNetSalary());
	  w10.isAddInViolation(labourDeptViolationReportList);

	/*
	
	  System.out.println("Total cost of Company give to the employee");

	  double total = System.out.println( m1.calculateNetSalary()) + System.out.println( m2.calculateNetSalary()) +  System.out.println( s1.calculateNetSalary()) +  System.out.println( s2.calculateNetSalary()) + System.out.println( w1.calculateNetSalary())  + System.out.println( w2.calculateNetSalary()) + System.out.println( w3.calculateNetSalary()) +  System.out.println( w4.calculateNetSalary()) +  System.out.println( w5.calculateNetSalary()) + System.out.println( w6.calculateNetSalary()) +   System.out.println( w7.calculateNetSalary()) + System.out.println( w8.calculateNetSalary())+System.out.println( w9.calculateNetSalary()) + System.out.println( w10.calculateNetSalary()) ;

	 
	*/


	 
	 
	
	}
	
}

