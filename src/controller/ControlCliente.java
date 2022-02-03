package controller;

import java.util.ArrayList;

import model.Cliente;
import view.CPFRepetidoException;

public class ControlCliente {

    private Cliente cliente;

    public ControlCliente() {
    	cliente = new Cliente();
    }

    public boolean addCliente(String nome, String cpf, String endereco, String telefone) throws CPFRepetidoException {
    	return cliente.addCliente(nome, cpf, endereco, telefone);
    }
    
    public ArrayList<String[]> acessaClientes() {
		return cliente.acessaClientes();
    	
    }
    
    public String[] procurar(String cpf) {
    	return cliente.procurar(cpf);
    }

    public boolean removerCliente(String cPF) {
        return cliente.removerCliente(cPF);
    }

   /* public String[] recuperarCliente(String cPF) {
        return cliente.recuperarCliente(cPF);
    }*/

}
