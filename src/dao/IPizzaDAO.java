package dao;

import java.util.ArrayList;

public interface IPizzaDAO {
	
	public void criar(String[] dados);
	
	public String[] buscar(String cpf);
	
	public ArrayList<String[]> listar();

	public void remover(ArrayList<String[]> p);

	public boolean mudarPraOK(String id, String data);
	
	public boolean mudarStatusPizzaNaoConcluida(String data);
	
	public boolean mudarStatusPizzaConcluida(String data);
	
	public boolean mudarPraVendida(String id);
	
	public void mudarPraEntregue(ArrayList<String[]> pizzas);
	
}
