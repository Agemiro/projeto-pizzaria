package view;

public class CPFRepetidoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CPFRepetidoException() {
		super("Já existe alguém cadastrado com este mesmo CPF.");
	}

}
