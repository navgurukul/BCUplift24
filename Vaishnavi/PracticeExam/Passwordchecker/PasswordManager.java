
//package PasswordChecker;


public class PasswordManager{

	public static void main(String[] args){

	String password = "abcd";
	
	PasswordChecker checker = new PasswordCheckerImpl(password);



	try
	{
		if(checker.check())
		{
			System.out.println("Strong password");
		}

	}
	catch(MinLengthException e)
	{
		System.out.println("Password length isn't enough" + e.getMessage());
	}
	catch(NoSpecialCharsException e)
	{
		System.out.println("Password doesn't have special character " + e.getMessage());

	}
	catch(InvalidPasswordException e)
	{
		System.out.println("Password isn't valid :"+e.getMessage());	
	}
	finally
	{
		System.out.println("Thank you for your input");
	}
}

}




interface PasswordChecker{

	public boolean check() throws InvalidPasswordException;


}



class PasswordCheckerImpl implements PasswordChecker{

	private String password;

	PasswordCheckerImpl(String password)
	{
		this.password = password;
	}
	

	public boolean check() throws InvalidPasswordException{
		return checkMinLength() && checkSpecialChars();
	}

	boolean checkMinLength() throws MinLengthException
	{
		if(password.length() < 8)
		{
			throw new MinLengthException("Password length should be minimum 8 characters");
		}

		return true;
	}

	boolean checkSpecialChars() throws NoSpecialCharsException
	{
		String specialChars = "!@#$%^&*:" ;
		
		for(char c : password.toCharArray())
		{
			if(specialChars.contains(""+c))
			return true;
		}

		throw new NoSpecialCharsException("Password should contain at least 1 special character");
	}

}

abstract class InvalidPasswordException extends Exception{
	InvalidPasswordException(String message)
	{
		super(message);
	}
}
	

class MinLengthException extends InvalidPasswordException{

	MinLengthException(String message)
	{
		
		super(message);
	}

}


class NoSpecialCharsException extends InvalidPasswordException{

	NoSpecialCharsException(String message)
	{
		
		super(message);
	}

}









