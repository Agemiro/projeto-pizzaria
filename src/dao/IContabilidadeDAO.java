package dao;

import java.util.ArrayList;

public interface IContabilidadeDAO {
	
	public void criar(String[] dados);
				
	public ArrayList<String[]> listar();

}
