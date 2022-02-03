package dao;

import java.util.ArrayList;

public interface IPedidoDAO {
	
	public void criar(String[] dados);
	
	public void remover(ArrayList<String[]> pedidos);
		
	public String[] buscar(String cpf);
	
	public ArrayList<String[]> listar();
	
}
