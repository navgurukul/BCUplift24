package passwordchecker.exception;

abstract class InvalidPasswordException extends Exception{
	InvalidPasswordException(String message)
	{
		super(message);
	}
}
	
