package model;

import java.util.ArrayList;

import dao.DAOCliente;
import dao.IClienteDAO;
import view.CPFRepetidoException;

public class Cliente extends Pessoa{

	private IClienteDAO clienteDAO = new DAOCliente();
    private String CPF;
    private String endereco;
    private String telefone;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

	public boolean addCliente(String nome, String cpf, String endereco, String telefone) throws CPFRepetidoException{
		
		String[] dadosCliente = {nome, cpf, endereco, telefone};
		
		if(clienteDAO.buscar(cpf) == null) {
			clienteDAO.criar(dadosCliente);
			return true;
		}
		
		throw new CPFRepetidoException();
		
    }

	public ArrayList<String[]> acessaClientes() {
		
		System.out.println(clienteDAO.listar());		
		
		return clienteDAO.listar();
		
	}

	public String[] procurar(String cpf){
		
		return clienteDAO.buscar(cpf);

	}

    public boolean removerCliente(String cPF) {
    	
    	return clienteDAO.remover(cPF);
		
    }

   /* public String[] recuperarCliente(String cPF) {
        return xml.recuperarCliente(cPF);
    }*/

}