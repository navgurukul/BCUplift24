import java.util.Scanner;
import PasswordChecker;

public class PasswordCheck2{
	public static void main(String args[]){
		//String pwd="duihguhvyv@";
		Scanner input=new Scanner(System.in);
		boolean flag=false;
		while(flag==false){
			System.out.println("Enter password");
			String pwd=input.nextLine();
			PasswordChecker checker=new PasswordCheckImpl(pwd);
			try{
				checker.check();
				System.out.println("Strong password!");
				flag=true;
			}catch(MinLengthException e){
				System.out.println("Password length in not enough "+e.getMessage());
			}catch(NoSpecialCharsException e){
				System.out.println(e.getMessage());
			}catch(NoNumberException e){
				System.out.println(e.getMessage());
			}catch(InvalidPasswordException e){
				System.out.println("Invalid Password: "+e.getMessage());
			}finally{
				System.out.println("Thank You for your Input!");
			}
		}
		
		
	}

}


class PasswordCheckImpl implements PasswordChecker{
	private String password;
	
	PasswordCheckImpl(String password){
		this.password=password;
	}

	public boolean check() throws InvalidPasswordException   {
		return checkMinLen() && checkSpecialCharac() && checkNumber();
	}

	public boolean checkMinLen() throws MinLengthException {
		if(password.length()<8){
			throw new MinLengthException ("Password length should be minimum 8 charac");
		}
		return true;
	}

	public boolean checkSpecialCharac() throws NoSpecialCharsException {
		String special="!£$%^&*()_+-={}[]~#:;@'<,>.?/";
		for(char c:password.toCharArray()){
			if(special.contains(""+c)) return true;
		}
		throw new NoSpecialCharsException("Password should contain 1 special charac");
	}

	public boolean checkNumber() throws NoNumberException{
		String num="1234567890";
		for(char c:password.toCharArray()){
			if(num.contains(""+c)) return true;
		}
		throw new NoNumberException("Password should contain at least 1 number");
	}
}

abstract class InvalidPasswordException extends Exception{
	InvalidPasswordException(String messg){
		super(messg);
	}

}

class MinLengthException extends InvalidPasswordException {
	MinLengthException(String messg){
		super(messg);
	}
}

class NoSpecialCharsException extends InvalidPasswordException {
	NoSpecialCharsException(String messg){
		super(messg);
	}
}

class NoNumberException extends InvalidPasswordException {
	NoNumberException(String messg){
		super(messg);
	}

}
