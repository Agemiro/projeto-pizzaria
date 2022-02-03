package dao;

import java.util.ArrayList;

public interface IFuncionarioDAO {
	
	public void criar(String[] dados); //CRIA UM FUNCIONARIO
	
	public boolean remover(String id);
	
	public String[] buscar(int id);
	
	public ArrayList<String[]> listar();
	
}
