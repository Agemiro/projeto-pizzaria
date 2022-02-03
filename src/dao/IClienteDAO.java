package dao;

import java.util.ArrayList;

public interface IClienteDAO {
	
	public void criar(String[] dados);
	
	public boolean remover(String cpf);
	
	public String[] buscar(String cpf);
	
	public ArrayList<String[]> listar();
	
}
