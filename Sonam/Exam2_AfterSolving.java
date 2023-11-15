import java.util.ArrayList;

public class Exam2 {
    public static void main(String[] args) {

        Manager manager = new Manager(40, 10, 1234, "Sonam");

        Supervisor supervisor1 = new Supervisor(50, 65, 5678, "Monika");
        Supervisor supervisor2 = new Supervisor(45, 5, 6789, "John");

        ArrayList<Worker> workers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Worker worker = new Worker(45, 15, 1000 + i, "Worker" + i);
            workers.add(worker);
        }

        ArrayList<Employee> labourDeptViolationReportList = new ArrayList<>();

        // Check if employees violated the 60-hour rule
        if (manager.hasViolatedMaxHours()) {
            labourDeptViolationReportList.add(manager);
        }
        if (supervisor1.hasViolatedMaxHours()) {
            labourDeptViolationReportList.add(supervisor1);
        }
        if (supervisor2.hasViolatedMaxHours()) {
            labourDeptViolationReportList.add(supervisor2);
        }
        for (Worker worker : workers) {
            if (worker.hasViolatedMaxHours()) {
                labourDeptViolationReportList.add(worker);
            }
        }

        // Print details
        System.out.println("Manager Details--------------------------------------");
        System.out.println("Gross Salary: " + manager.calculateGrossSalary());
        System.out.println("Tax: " + manager.calculateTax());
        System.out.println("Net Salary: " + manager.calculateNetSalary());

        System.out.println("Supervisor 1 Details--------------------------------");
        System.out.println("Gross Salary: " + supervisor1.calculateGrossSalary());
        System.out.println("Tax: " + supervisor1.calculateTax());
        System.out.println("Net Salary: " + supervisor1.calculateNetSalary());

        System.out.println("Supervisor 2 Details--------------------------------");
        System.out.println("Gross Salary: " + supervisor2.calculateGrossSalary());
        System.out.println("Tax: " + supervisor2.calculateTax());
        System.out.println("Net Salary: " + supervisor2.calculateNetSalary());

        System.out.println("Worker Details-------------------------------------");
        for (Worker worker : workers) {
            System.out.println("Worker ID: " + worker.Id);
            System.out.println("Worker name: " + worker.name);
            System.out.println("Gross Salary: " + worker.calculateGrossSalary());
            System.out.println("Tax: " + worker.calculateTax());
            System.out.println("Net Salary: " + worker.calculateNetSalary());
            System.out.println("--------------------------------");
        }

        System.out.println("Employees who violated the 60-hour rule: " + labourDeptViolationReportList);

        double totalCost = manager.calculateNetSalary() + supervisor1.calculateNetSalary() + supervisor2.calculateNetSalary();
        for (Worker worker : workers) {
            totalCost += worker.calculateNetSalary();
        }
        System.out.println("Total cost of the company: " + totalCost);
    }
}

interface Employee {
    double calculateGrossSalary();

    double calculateNetSalary();

    double calculateTax();

    boolean hasViolatedMaxHours();
}

class Manager implements Employee {
    public double Id;
    public String name;
    public static final double hoursRate = 500;
    public static final double maxHours = 40;
    public static final double taxRate = 0.30;
    public double workingHours;
    public double overHours;

    private double grossSalary;
    private double texOutGo;
    private double netSalary;

    Manager(double workingHours, double overHours, double Id, String name) {
        this.workingHours = workingHours;
        this.overHours = overHours;
        this.Id = Id;
        this.name = name;
    }

    public double calculateGrossSalary() {
        grossSalary = workingHours * 500;
        return grossSalary;
    }

    public double calculateNetSalary() {
        texOutGo = grossSalary * taxRate;
        netSalary = grossSalary - texOutGo;
        return netSalary;
    }

    public double calculateTax() {
        return texOutGo;
    }

    public boolean hasViolatedMaxHours() {
        return (workingHours + overHours) > 60;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getTax() {
        return texOutGo;
    }

    public double getNetSalary() {
        return netSalary;
    }
}

class Supervisor implements Employee {
    public static final double hoursRate = 300;
    public static final double maxHours = 60;
    public static final double taxRate = 0.20;
    public static final double maxWeeklyHour = 60;
    public static final double overtimeRate = 1.5;

    public double Id;
    public String name;
    public double workingHours;
    public double overHours;

    private double grossSalary;
    private double texOutGo;
    private double netSalary;

    Supervisor(double workingHours, double overHours, double Id, String name) {
        this.workingHours = workingHours;
        this.overHours = overHours;
        this.Id = Id;
        this.name = name;
    }

    public double calculateGrossSalary() {
        grossSalary = (workingHours * 300) + (overHours * 450);
        return grossSalary;
    }

    public double calculateNetSalary() {
        texOutGo = grossSalary * taxRate;
        return texOutGo;
    }

    public double calculateTax() {
        netSalary = grossSalary - texOutGo;
        return netSalary;
    }

    public boolean hasViolatedMaxHours() {
        return (workingHours + overHours) > 60;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getTax() {
        return texOutGo;
    }

    public double getNetSalary() {
        return netSalary;
    }
}

class Worker implements Employee {
    public static final double hoursRate = 200;
    public static final double maxHours = 60;
    public static final double taxRate = 0.10;
    public static final double maxWeeklyHour = 60;
    public static final double overtimeRate = 1.5;

    public double Id;
    public String name;
    public double workingHours;
    public double overHours;

    private double grossSalary;
    private double texOutGo;
    private double netSalary;

    Worker(double workingHours, double overHours, double Id, String name) {
        this.workingHours = workingHours;
        this.overHours = overHours;
        this.Id = Id;
        this.name = name;
    }

    public double calculateGrossSalary() {
        grossSalary = (workingHours * 200) + (overHours * 300);
        return grossSalary;
    }

    public double calculateNetSalary() {
        texOutGo = grossSalary * taxRate;
        return texOutGo;
    }

    public double calculateTax() {
        netSalary = grossSalary - texOutGo;
        return netSalary;
    }

    public boolean hasViolatedMaxHours() {
        return (workingHours + overHours) > 60;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getTax() {
        return texOutGo;
    }

    public double getNetSalary() {
        return netSalary;
    }
}
