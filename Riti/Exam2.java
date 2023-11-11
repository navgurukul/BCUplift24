public class Exam2{
	public static void main(String[] args){
	ArrayList<Manager> Managers();
	ArrayList<Manager>m1=new Managers();
	m1.add(new calculateGrossSalary()));
	m1.add(new calculateTax(m1.calculateGrossSalary())));
	m1.add(new calculateNetSalary(m1.calculateGrossSalary(),m1.calculateTax(m1.calculateGrossSalary()))));
	System.out.println(M1);
	}
}
interface Employee {
    String getId();

    void setId(String Id);

    void setName(String Name);

    String getName();

    double calculateGrossSalary();

    double calculateTax(double grossSalary);

    double calculateNetSalary(double grossSalary, double tax);
}

class Manager implements Employee {
    private String Id;
    private String Name;
    public double WorkingHours;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    Manager(String Id, String Name, double WorkingHours) {
        this.Id = Id;
        this.Name = Name;
        this.WorkingHours = WorkingHours;
    }

    public double calculateGrossSalary() {
        double GrossSalary = 0;
        if (WorkingHours <= 60) {
            if (WorkingHours <= 40) {
                GrossSalary = WorkingHours * 500;
            }
        }
        return GrossSalary;
    }

    public double calculateTax(double GrossSalary) {
        double Tax = GrossSalary * 0.3; 
        return Tax;
    }

    public double calculateNetSalary(double GrossSalary, double Tax) {
        double NetSalary = GrossSalary - Tax;
        return NetSalary;
    }
    public String toString(){
	return this.Id+" "+this.Name+" "+public double calculateGrossSalary()+" "+ublic double calculateTax(double GrossSalary)+public double calculateNetSalary(double GrossSalary, double Tax);
	}
}


class Supervisor implements Employee {
    private String Id;
    private String Name;
    public double WorkingHours;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    Supervisor(String Id, String Name, double WorkingHours) {
        this.Id = Id;
        this.Name = Name;
        this.WorkingHours = WorkingHours;
    }

    public double calculateGrossSalary() {
        double GrossSalary = 0;
        if (WorkingHours <= 60) {
            if (WorkingHours <= 40) {
                GrossSalary = WorkingHours * 500;
            }else{
			GrossSalary = ((40 * 300)+(WorkingHours*450));
		}
        }
        return GrossSalary;
    }

    public double calculateTax(double GrossSalary) {
        double Tax = GrossSalary * 0.2; 
        return Tax;
    }

    public double calculateNetSalary(double GrossSalary, double Tax) {
        double NetSalary = GrossSalary - Tax;
        return NetSalary;
    }
}





class Worker implements Employee {
    private String Id;
    private String Name;
    public double WorkingHours;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    Worker(String Id, String Name, double WorkingHours) {
        this.Id = Id;
        this.Name = Name;
        this.WorkingHours = WorkingHours;
    }

    public double calculateGrossSalary() {
        double GrossSalary = 0;
        if (WorkingHours <= 60) {
            if (WorkingHours <= 40) {
                GrossSalary = WorkingHours * 200;
            }else{
			GrossSalary = ((40 * 200)+(WorkingHours*300));
		}
        }
        return GrossSalary;
    }

    public double calculateTax(double GrossSalary) {
        double Tax = GrossSalary * 0.1; 
        return Tax;
    }

    public double calculateNetSalary(double GrossSalary, double Tax) {
        double NetSalary = GrossSalary - Tax;
        return NetSalary;
    }
}












