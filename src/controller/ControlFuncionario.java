package controller;

import java.util.ArrayList;

import model.Funcionario;
import model.UsuarioLogado;
import view.IDRepetidoException;

/* o controlador é apenas um intermediário,
 * um leva e trás, o carteiro.
 * E o carteiro não precisa saber nada além do endereço e de como transportar as mensagens.
 * O controlador não sabe NADA sobre eventos da view ou sobre eventos do model.
 */

public class ControlFuncionario {

    private Funcionario funcionario;
    
    public ControlFuncionario() {
    	funcionario = new Funcionario();//iniciei
    }
            
    public String fazerLogin(int id, String senha){ //ALTEREI
		return funcionario.fazerLogin(id, senha);	
    }

	public void salvaUsuarioLogado(String nome) {
		UsuarioLogado.setUsuario(nome);
	}
	
	public String acessaUsuarioLogado() {
		return UsuarioLogado.getUsuario();
	}

    public void addFuncionario(int id, String nome, String cargo, String senha) throws IDRepetidoException {
    	this.funcionario.addFuncionario(id, nome, cargo, senha); //addFuncionario é da classe Funcionario
    }
    
    public ArrayList<String[]> acessaFuncionarios(){
    	return funcionario.acessaFuncionarios();
    }

    public boolean removerFuncionario(String id) {
        return funcionario.deletarFuncionario(id);
    }

    public String[] recuperarFuncionario(int id) {
        return funcionario.recuperarFuncionario(id);
    }

}
