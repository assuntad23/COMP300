package adesanto.SandQ;

public class EmptyStructureException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmptyStructureException() {
		super("Empty Structure");
	}

}
