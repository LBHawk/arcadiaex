public class InvalidSearchTypeException extends Exception{
	
	public InvalidSearchTypeException(){

	}

	public InvalidSearchTypeException(String message){
		super(message);
	}

	public InvalidSearchTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidSearchTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}