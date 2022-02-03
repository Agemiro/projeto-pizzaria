package dao;

import java.util.ArrayList;

public interface ISaboresDAO {
	
	public void criar(String[] dados);
	
	public String[] buscar(String nome);
	
	public ArrayList<String[]> listar();

	public void remover(String nome);

}
