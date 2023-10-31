import java.util.*;

class exam1{
public static void main(String[] args){
account a=new account("1234",2000);
}
}
abstract class account{
private String accountNumber;
int balance;
private List<Transaction> transactionList;
public account(int accountNumber,int balance){
this.accountNumber=accountNumber;
this.balance=balance;
this.transactionList=new ArrayList<>();
}
public void getaccountNumber(){
return accountNumber;
}
public String setaccountNumber(int accountNumber){
this.accountNumber=accountNumber;
}
public void addTransection(Transection transection){
transectionList.add(transection);
}
public List<Transection> getTransectionList(){
return transectionList;
}

public void deposit(int amount){
if (amount > 0) {
            balance += amount;
            Transaction transaction = new Transaction(transactionList.size() + 1, amount);
            transactionList.add(transaction);

}
}
public void withdraw(){
if (amount>0 && amount<=balance){
balance-=amount;
Transection transection=new Transection(transectionList.size()+1,-amount);
tarnsectionList.add(transection);
}

}
public void createTransection(){
Transection transection=new Transection(transectionList.size(),amount);
transectionList.add(transection);

}
public void printTransection(){

}

}
class currentAccount extends account{

int overdraftLimit;
public void withdraw(){

}
public void createTransection(){

}


}
class savingAccount extends account{
int interestRate;
public void endOfDayInterest(){

}

}
class customer{
String name;
String dob;
private String aadharNumber;
public Account account;
public int getAadharNumber(){
return this.aadharNumber;
}

}
class transection{
public static String generateRandomId(){
int length =8;
StringBuilder Id=new StringBuilder();
for(int i=0;i<length;i++){
int randomDigit=(int)(Math.random()*10);
Id.append(randomDigit);
}
//String Id=Id.toString();
return Id.toString();
}

Date date=new Date();

public transection(Date date){
this.date=date;
}


}
