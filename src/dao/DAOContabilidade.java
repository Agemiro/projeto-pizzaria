package dao;

import java.util.ArrayList;

public class DAOContabilidade implements IContabilidadeDAO{
	
	private ConexaoXML conexao = new ConexaoXML("xml/contabilidade.xml");

	@Override
	public void criar(String[] dados) {
		conexao.recuperarLista().add(dados);
		conexao.salvarLista();
	}

	@Override
	public ArrayList<String[]> listar() {
		return conexao.recuperarLista();

	}
	
}
