public class Exam2{
	public static void main(String[] args){
	Manager m1=New Manager("20029", "vipin", 23);
	System.out.println(m1.calculateGrossSalary());
	
	

	}
}


interface Employee{
	

	double calculateGrossSalary(String id, String name, int workingHours);
	double calculateNetSalary(String id, String name, int workingHours);
	double calculateTax(String id, String name,int workingHours)

	//public String getId();

	
	//public String getName();

	String toString();


}


class Manager impliments Employee{
	double calculateGrossSalary(String id, String name, int workingHours ){
		grossSalary=0;

		if (workingHours>40){
			grosssalary=workingHours*500;
			return grossSalary

		}
		else if(workingHours>40 && workingHours<60){
			

		}
		
		
	}
	double calculateNetSalary(String id, String name, int workingHours){
		tax_outgo=(workingHours*500)*30;
		return tax_outgo;
		
		
	}
	double calculateTax(String id, String name, int workingHours){
		Net_Salary =(workingHours*500) -(workingHours*500)*30
	
	}

	//public String toString(){
	//	return 
	//}
	
	
}


class Supervisor impliments Employee{
	
	double calculateGrossSalary(String id, String name,int workingHours, double extraTimeWork){
		int grossSalary=0;
		
		if (workingHours>40){
			grossSalary=workingHours*300;
			return grossSAlary;

			
		}
		else if(workingHours>40 && workingHours<60){
			grossSalary=(workingHours*300)+(double extraTimeWork*450);
			return grossSAlary;
		}
		
	}
	double calculateNetSalary(String id, String name,int workingHours,double extraTimeWork){
		tax_outgo=((workingHours*300)+(double extraTimeWork*450))*20;
		return tax_outgo;
	}
	double calculateTax(String id, String name,int workingHours){
		netSalary=(workingHours*300)+(double extraTimeWork*450)-((workingHours*300)+(double extraTimeWork*450))*20;
		return netSalary;
		
	}
	
	
}


class Worker impliments Employee{
	double calculateGrossSalary(String id, String name,int workingHours,double extraTimeWork){
		int grossSalary=0;
		
		if (workingHours>40){
			grossSalary=workingHours*200;
			return grossSAlary;

			
		}
		else if(workingHours>40 && workingHours<60){
			grossSalary=(workingHours*200)+(double extraTimeWork*300);
			return grossSAlary;
		}
		
	}
	double calculateNetSalary(String id, String name,int workingHours,double extraTimeWork){
		tax_outgo=((workingHours*200)+(double extraTimeWork*300))*10;
		return tax_outgo;
	}
	double calculateTax(String id, String name,int workingHours,double extraTimeWork){
		netSalary=(workingHours*200)+(double extraTimeWork*300)-((workingHours*200)+(double extraTimeWork*300))*10;
		return netSalary;
		
	}
	
	
}


