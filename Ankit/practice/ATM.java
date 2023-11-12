import java.util.Scanner;

class ATMFeatures {
    double Balance ;
    int PIN = 8448 ;

    public void CheckPin(){
        System.out.println("Enter your PIN :- ");
        Scanner sc = new Scanner (System.in);
        int userpin = sc.nextInt() ;
        sc.close();
        if(userpin==PIN){
            menu() ;
        }
        else{
            System.out.println("Enter a valid PIN..");
            CheckPin();
        }
    }
    public void menu(){
        System.out.println("Choose an option to proceed:- ");
        System.out.println("1) check A/c Balance ");
        System.out.println("2) Deposit money ");
        System.out.println("3) Withdraw money ");
        System.out.println("4) Exit ");

        Scanner sc = new Scanner(System.in);
        int options = sc.nextInt() ;
        sc.close();
        
        if (options ==1 ){
            CheckBalance() ;

        }
        else if (options == 2){
            Deposit() ;

        }
        else if (options == 3){
            Withdraw();
        }
        else if(options == 4){
            System.out.println("Getting you outside as per your request .. ");
            return ;

        }
        else{
            System.out.println("Choose a valid option ");
            menu();
        }
    }
    public void CheckBalance(){
        System.out.println("Balance :" + Balance);
        menu();
    }
    public void Deposit(){
        System.out.println("Enter the amount to deposit..");
        Scanner sc = new Scanner(System.in) ;
        double amount = sc.nextDouble() ;
        Balance= Balance + amount ;
        System.out.println("Amount added successfully..");
        menu();
        sc.close();
    }
    public void Withdraw(){
        System.out.println("Enter the amount to withdraw..");
        Scanner sc = new Scanner(System.in) ;
        double amount = sc.nextDouble() ;
        if (amount<=Balance){
            Balance = Balance - amount ;
            System.out.println("Amount withdrawn successfully..");

        }
        else{
            System.out.println("Sorry, Insufficient Balance to Withdraw ");

        }
        menu();
        sc.close();

    }
    
}

public class ATM {
    public static void main(String input[]){
        ATMFeatures obj = new ATMFeatures() ;
        obj.CheckPin();

    }
}




