package view;

public class CPFRepetidoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CPFRepetidoException() {
		super("J� existe algu�m cadastrado com este mesmo CPF.");
	}

}
