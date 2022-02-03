package dao;

import java.util.ArrayList;

public class DAOSabores implements ISaboresDAO{
	
	private ConexaoXML conexao = new ConexaoXML("xml/sabores.xml");

	@Override
	public void criar(String[] dados) {
		
		conexao.recuperarLista().add(dados);
		conexao.salvarLista();
		
	}

	@Override
	public String[] buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String[]> listar() {
		
		return conexao.recuperarLista();

	}

	@Override
	public void remover(String nome) {
		// TODO Auto-generated method stub
		
	}

}
