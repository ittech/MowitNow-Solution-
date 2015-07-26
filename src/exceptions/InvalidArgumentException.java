package exceptions;

public class InvalidArgumentException extends Exception {

	
	
	public InvalidArgumentException () {
		
		super();
	}
	
	public InvalidArgumentException (String raison) {
		
		super(raison);
	}
}
