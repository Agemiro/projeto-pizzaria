package model;

import java.util.ArrayList;

import dao.DAOFuncionario;
import dao.IFuncionarioDAO;
import view.IDRepetidoException;

public class Funcionario extends Pessoa{
	
	private IFuncionarioDAO funcionarioDAO = new DAOFuncionario();
	private int id;
	private String cargo;
	private String senha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String fazerLogin(int id, String senha) {
		String[] funcionarioEncontrado = recuperarFuncionario(id);
		
		if(funcionarioEncontrado != null && funcionarioEncontrado[3].equals(senha)) {
			return funcionarioEncontrado[2];//cargo
		}
         
        if(id == 0 && senha.equals("0")) {
            return "Administrador";
        }
 
        return null;
    }

	public void addFuncionario(int id, String nome, String cargo, String senha) throws IDRepetidoException{
		
		String[] arrayInformacoesDoFuncionario = {Integer.toString(id), nome, cargo, senha};//VETOR
		
		if(funcionarioDAO.buscar(id) == null) {

			if(cargo.equals("Gerente")) {
			
				funcionarioDAO.criar(arrayInformacoesDoFuncionario); //PEGO OS DADOS DO VETOR (QUE RECEBE OS DADOS NATIVOS) E CRIO SEU VETOR NO NA CAMADA DAO. 
			
			}
			else if(cargo.equals("Atendente")) {
				
				funcionarioDAO.criar(arrayInformacoesDoFuncionario);

			}
			else if(cargo.equals("Motoboy")) {
			
				funcionarioDAO.criar(arrayInformacoesDoFuncionario);


			}
			else if(cargo.equals("Pizzaiolo")) {
			
				funcionarioDAO.criar(arrayInformacoesDoFuncionario);


			}
			else if(cargo.equals("Serviços Gerais")) {
				funcionarioDAO.criar(arrayInformacoesDoFuncionario);

			}
			
		}else {
			throw new IDRepetidoException();
		}
		
	}
	
	public boolean deletarFuncionario(String id) {  

		for(String[] dados: funcionarioDAO.listar()){
			if(dados[0].equals(id)) {
		    	return funcionarioDAO.remover(id);
			}
		}
		return false;
    	
	}

	public String[] recuperarFuncionario(int id) {

		String[] funcionarioEncontrado = funcionarioDAO.buscar(id);
             
        return funcionarioEncontrado;
       
	}
	
	public ArrayList<String[]> acessaFuncionarios() {
		
		return funcionarioDAO.listar();//RETORNA O ARRAYLIST DE VETORES COM FUNCIONARIOS
		
	}

}

