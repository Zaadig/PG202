package tec;

public class TecException extends Exception {
	
	public TecException (String msg){ 
		super(msg);
	}
	
	public TecException (Exception e){
		super(e);
	}
	
}