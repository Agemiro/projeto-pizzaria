package dao;

import java.util.ArrayList;

public class DAOPedido implements IPedidoDAO{
	
	private ConexaoXML conexao = new ConexaoXML("xml/pedidos.xml");

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
	public String[] buscar(String cpf) {
		for (String[] dados : conexao.recuperarLista()) {
			if(dados[0].equals(cpf)) {
				return dados;
			}
		}
		return null;
	}

	@Override
	public ArrayList<String[]> listar() {
		
		return conexao.recuperarLista();

	}

}
