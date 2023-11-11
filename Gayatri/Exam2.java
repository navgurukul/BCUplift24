import java.util.ArrayList;
import java.util.List;

interface Employee{
  public double calculateGrossSalary();
  public double calculateTax();
  public double calculateNetSalary();
}

class Manager implements Employee{
  private int workingHour;
  private int extraTime;
  private int employeeId; 
 // public static final int hourPayManager=500;

   Manager(int employeeId, int workingHour, int ExtraTime){
      this.employeeId=employeeId;
      this.workingHour=workingHour;
      this.extraTime=extraTime;
   }
  public int getWorkingHour(){
     return workingHour;
   }
  public int getExtraTime(){
   return extraTime;
 }
 public int geEmployeeId(){
   return employeeId;
 }

 public double calculateGrossSalary(){
   return getWorkingHour()*500;
 }

 public double calculateTax(){
   return calculateGrossSalary()*0.30;
  }
 public double calculateNetSalary(){
  return calculateGrossSalary()-calculateTax();
 }

}

class Supervisor implements Employee{
 private int workingHour;
  private int extraTime;
  private int employeeId;
  private List<Worker> supervisors; 
 // public static final int hourPaySupervisor=300;

  Supervisor(int employeeId,int workingHour, int ExtraTime){
      this.employeeId=employeeId;
      this.workingHour=workingHour;
      this.extraTime=extraTime;
      supervisors = new ArrayList<>();
   }
  public int getWorkingHour(){
     return workingHour;
   }
  public int getExtraTime(){
   return extraTime;
 }
 public int geEmployeeId(){
   return employeeId;
 }

 public double calculateGrossSalary(){
  int grossSalary= getWorkingHour()*300 + getExtraTime()*450;
   if(getWorkingHour()+getExtraTime()>60){
   int a= (getWorkingHour()-60)*300;
   return grossSalary-a;
   }
   else{
    return grossSalary;
   }
 }

 public double calculateTax(){
   return calculateGrossSalary()*0.20;
  }
 public double calculateNetSalary(){
  return calculateGrossSalary()-calculateTax();
 }

}

class Worker implements Employee{
  private int workingHour;
  private int extraTime;
  private int employeeId;
  private List<Worker> workers; 
  private List<Worker> reportWorker;
 // public static final int hourPayWorker = 200;

   Worker( int employeeId,int workingHour, int ExtraTime){
      this.employeeId=employeeId;
      this.workingHour=workingHour;
      this.extraTime=extraTime;
      workers= new ArrayList<>();
      reportWorker = new ArrayList<>();
   }
  public int getWorkingHour(){
     return workingHour;
   }
  public int getExtraTime(){
   return extraTime;
 }
  public int getEmployeeId(){
   return employeeId;
 }

 public double calculateGrossSalary(){
   double grossSalary= getWorkingHour()*200 + getExtraTime()*450;
   if(getWorkingHour()+getExtraTime()>60){
   double a= (getWorkingHour()-60)*200;
   reportWorker.add(this);
   return grossSalary-a;
   }
   else{
    return grossSalary;
   }
 }

 public double calculateTax(){
   return calculateGrossSalary()*0.10;
  }
 public double calculateNetSalary(){
  return calculateGrossSalary()-calculateTax();
 }

}

public class Exam2{
  public static void main(String[] args){
  Manager m1= new Manager(101,40,10);
  System.out.println("Manager GrossSalary is"+m1.calculateGrossSalary());
  System.out.println("Manager Tax is"+m1.calculateTax());
  System.out.println("Manager Net Salary is"+m1.calculateNetSalary());

  Supervisor s1= new Supervisor(102,20,20);
  Supervisor s2 = new Supervisor(103,30,20);
  System.out.println("Supervisor GrossSalary is"+s1.calculateGrossSalary());
  System.out.println("Supervisor Tax is"+s1.calculateTax());
  System.out.println("Supervisor Net Salary is"+s1.calculateNetSalary());

  System.out.println("Supervisor GrossSalary is"+s2.calculateGrossSalary());
  System.out.println("Supervisor Tax is"+s2.calculateTax());
  System.out.println("Supervisor Net Salary is"+s2.calculateNetSalary());
   
  Worker w1= new Worker(104,10,20);
  System.out.println("Worker GrossSalary is"+w1.calculateGrossSalary());
  System.out.println("Worker Tax is"+w1.calculateTax());
  System.out.println("Worker Net Salary is"+w1.calculateNetSalary());

  Worker w2= new Worker(105,11,30);
  System.out.println("Worker GrossSalary is"+w1.calculateGrossSalary());
  System.out.println("Worker Tax is"+w1.calculateTax());
  System.out.println("Worker Net Salary is"+w1.calculateNetSalary());

  Worker w3= new Worker(106,10,20);
  System.out.println("Worker GrossSalary is"+w3.calculateGrossSalary());
  System.out.println("Worker Tax is"+w3.calculateTax());
  System.out.println("Worker Net Salary is"+w3.calculateNetSalary());
  }
}



