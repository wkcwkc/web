package web.base;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 6131655788106365488L;

	public BusinessException (String msg){
		super(msg);
	}
}
