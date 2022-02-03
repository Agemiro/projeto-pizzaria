package view;

public class FuncionarioNaoExisteException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FuncionarioNaoExisteException() {
		super("Funcionário não existe!");
	}
	
}
