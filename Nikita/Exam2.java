import java.util.ArrayList;
interface Employee{
    
    public double calGrossSalary();
    public double calculateTax();
    public double calculateNetSalary();
}

class Maneger implements Employee{
    private int id;
    private String name;
    private int  workingHourWeekly;
    private ArrayList<String> labourDeptViolationReport;
    
    Maneger(int id,String name,int workingHourWeekly,ArrayList<String> moreThanMaxHourWorkers){
        this.id=id;
        this.name=name;
        this.workingHourWeekly=workingHourWeekly;
        this.labourDeptViolationReport=labourDeptViolationReport;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    public int getWorkingHourWeekly(){
        return workingHourWeekly;
    }
    public double calGrossSalary(){
        
        if(workingHourWeekly >60){
            labourDeptViolationReport.add(name);
            return 40*500;                 
        }
        else if(workingHourWeekly>40)
        {
            return 40*500;

        }
        else{
            return 500*workingHourWeekly;
        }
       
    }
    public double calculateTax(){
        return calGrossSalary()*0.30;
        
    }
    public double calculateNetSalary(){
        return calGrossSalary()-calculateTax();
    }
    
    public String toString(){
        return "The Maneger "+getName()+" ID "+getId()+" Got "+" GrossSalary: "+calGrossSalary()+" deduct tax "+calculateTax()+" Total Net salary: " +calculateNetSalary()+" in this week.";
    }

    
}

class Supervisior implements Employee{
    private int id;
    private String name;
    private int  workingHourWeekly;
    private ArrayList<String> labourDeptViolationReport;
   
    
    Supervisior(int id,String name,int workingHourWeekly,ArrayList<String> moreThanMaxHourWorkers){
        this.id=id;
        this.name=name;
        this.workingHourWeekly=workingHourWeekly;
        this.labourDeptViolationReport=labourDeptViolationReport;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public double calGrossSalary(){
        
        if(workingHourWeekly >60){
            labourDeptViolationReport.add(name);
            return 60*300;                 
        }
        else if(workingHourWeekly>40)
        {
            return (40*300)+(60-workingHourWeekly)*450;

        }
        else{
            return 300*workingHourWeekly;
        }
        
        
    }
    public double calculateTax(){
        return calGrossSalary()*0.20;
        
    }
    public double calculateNetSalary(){
        return calGrossSalary()-calculateTax();
    }
    
    public String toString(){
        return "The Supervisior "+getName()+" ID "+getId()+" Got "+" GrossSalary: "+calGrossSalary()+" deduct tax "+calculateTax()+" Total Net salary: " +calculateNetSalary()+" in this week.";
    }
}

class Worker implements Employee{
    private int id;
    private String name;
    private int  workingHourWeekly;
    private ArrayList<String> labourDeptViolationReport;
    
    Worker(int id,String name,int workingHourWeekly,ArrayList<String> moreThanMaxHourWorkers){
        this.id=id;
        this.name=name;
        this.workingHourWeekly=workingHourWeekly;
        this.labourDeptViolationReport=labourDeptViolationReport;

    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
     public double calGrossSalary(){
        
        if(workingHourWeekly >60){
            labourDeptViolationReport.add(name);
            return 60*200;                 
        }
        else if(workingHourWeekly>40)
        {
            return (40*200)+(60-workingHourWeekly)*300;

        }
        else{
            return 200*workingHourWeekly;
        }
        
        
    }
    public double calculateTax(){
        return calGrossSalary()*0.10;
        
    }
    public double calculateNetSalary(){
        return calGrossSalary()-calculateTax();
    }
    
    public String toString(){
        return "The Supervisior "+getName()+" ID "+getId()+" Got "+" GrossSalary: "+calGrossSalary()+" deduct tax "+calculateTax()+" Total Net salary: " +calculateNetSalary()+" in this week. ";
    }

    
}
public class Exam2
{
	public static void main(String[] args) {
		
		ArrayList<String> al=new ArrayList<>();
		Maneger m=new Maneger(25,"Nikita",45,al);
		System.out.println(m.toString());
		
		Supervisior s=new Supervisior(25,"prajkta",60,al);
		System.out.println(s.toString());
		
		Worker w=new Worker(25,"pranav",24,al);
		System.out.println(w.toString());
		
	}
}
