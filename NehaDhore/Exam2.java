/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.ArrayList;
import java.text.IllegalArgumentException;


public class Exam2{
    public static void main(String[] args){
        
      
        Manager manager = new Manager(1,"Neha");
        
        manager.calculateNetSalary();
        manager.calculateNetSalary()
        
        
        Supervisor supervisor = new Supervisor(2,"Harsha");
        
        supervisor.calculateNetSalary();
        supervisor.calculateNetSalary()
        
        Supervisor supervisor1 = new Supervisor(3, "Priyanka");
        
        supervisor.calculateNetSalary();
        supervisor.calculateNetSalary()
        
        Worker worker = Worker(4,"nikita");
        
        worker.calculateNetSalary();
        worker.calculateNetSalary()
        
        
        ArrayList <Employee> HW = new ArrayList<>();
        
       try{
           if( hours + extraHours <= 60){
           
           manager.calculateGrossSalary(50,5);       
           supervisor.calculateGrossSalary(50,16);
           supervisor.calculateGrossSalary(60,10);
           worker.calculateGrossSalary(40,10);
           
          
        
           }
       }
       catch(IllegalArgumentException E){
          HW.add()=manager.name;
       }
       return String[] array = strList. toArray(new String[0]);
    }
}
interface Employee{
   Employee[] (int empoyeeId, String name);
   
   double calculateGrossSalary();
   double calculateNetSalary();
   double calculateTax();
}

class Manager implements Employee{
    
     public Manager(int empoyeeId, String name){
           this.employeeId = employeId;
           this.name = name;
       }
       public int getEmployeeId(){
           return employeeId;
       }
       public String getName(){
           return name;
       }
    @Override
    public double calculateGrossSalary(int hours, int extraHours){
    
        calculateGrossSalary(int hours, int extraHours){
            this.hours = hours;
            this.extraHours = extraHours;
        }
        
        int t =(hours*300) +(extraHours*450);
        return t;
    }
   
    public double tax(){
        
        double  Tax=t*20;
        return Tax;
    }
    
     public double calculateNetSalary(){
        
        return t-Tax;
    }
    
        
    }
}

class Supervisor implements Employee{
    
    
     public Supervisor (int empoyeeId, String name){
           this.employeeId = employeId;
           this.name = name;
       }
       
    public int getEmployeeId(){
           return employeeId;
       }
    public String getName(){
           return name;
       }
    
     @Override
    public double calculateGrossSalary(int hours, int extraHours){
    
       calculateNetSalary(int hours, int extraHours){
            this.hours = hours;
            this.extraHours = extraHours;
        }
        
        int t =(hours*300) +(extraHours*450);
        return t;
    }
   
    public double tax(){
        
        double  Tax=t*20;
        return Tax;
    }
    
     public double calculateNetSalarySalary(){
        
        return t-Tax;
    }
    
        
    }
    
}

class Worker implements Employee{
    
     public Worker(int empoyeeId, String name){
           this.employeeId = employeId;
           this.name = name;
       }
       
    public int getEmployeeId(){
           return employeeId;
       }
    public String getName(){
           return name;
       }
    
     @Override
    public double calculateGrossSalary(int hours, int extraHours){
    
        calculateGrossSalary(int hours, int extraHours){
            this.hours = hours;
            this.extraHours = extraHours;
        }
        
        int t =(hours*300) +(extraHours*450);
        return t;
    }
   
    public double tax(){
        Worker tax = new Worker()
        double  Tax=t*20;
        return Tax;
    }
    
     public double calculateNetSalarySalary(){
        
        return t-Tax;
    }
    
        
    }