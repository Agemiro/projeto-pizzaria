package controller;

import model.Contabilidade;

public class ControlContabilidade {
	
	private Contabilidade contabil;
	
	public ControlContabilidade() {
		contabil = new Contabilidade();
    }
	
	public Contabilidade acessarContabilidade(){
    	return contabil.acessarContabilidade();
    }
	
}
