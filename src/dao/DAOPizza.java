package dao;

import java.util.ArrayList;

public class DAOPizza implements IPizzaDAO{
	
	private ConexaoXML conexao = new ConexaoXML("xml/pizzas.xml");

	@Override
	public void criar(String[] dados) {
		
		conexao.recuperarLista().add(dados);
		conexao.salvarLista();
		
	}
	
	public void remover(ArrayList<String[]> dados) {
		conexao.recuperarLista().removeAll(dados);
		conexao.salvarLista();
	}


	@Override
	public String[] buscar(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String[]> listar() {
		return conexao.recuperarLista();
	}

	@Override
	public boolean mudarPraOK(String id, String data) {
		
		for (String[] dados : conexao.recuperarLista()) {
			if(dados[6].equals(id)) {
				dados[4] = "Pronta";
				dados[5] = data;
				conexao.salvarLista();
				return true;
			}
		}
		return false;
		
	}

	@Override
	public void mudarPraEntregue(ArrayList<String[]> pizzas) {
		
		for (String[] dados : conexao.recuperarLista()) {
			dados[7] = "Entregue";		
		}
		conexao.salvarLista();
		
	}

	@Override
	public boolean mudarPraVendida(String id) {
		for (String[] dados : conexao.recuperarLista()) {
			if(dados[6].equals(id)) {
				dados[4] = "Vendida";
				//dados[5] = data;
				conexao.salvarLista();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean mudarStatusPizzaNaoConcluida(String data) {
		for (String[] dados : conexao.recuperarLista()) {
			if(dados[5].equals(data)) {
				dados[4] = "Pedido Não Concluído";
				conexao.salvarLista();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean mudarStatusPizzaConcluida(String data) {
		for (String[] dados : conexao.recuperarLista()) {
			if(dados[5].equals(data)) {
				dados[4] = "Pedido Concluído";
				conexao.salvarLista();
				return true;
			}
		}
		return false;
	}

}
