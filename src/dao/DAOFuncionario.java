package dao;

import java.util.ArrayList;

public class DAOFuncionario implements IFuncionarioDAO {

	private ConexaoXML conexao = new ConexaoXML("xml/funcionarios.xml");

	@Override
	public void criar(String[] dados) {
		conexao.recuperarLista().add(dados); //PEGO O VETOR COM DADOS NATIVOS DE UM FUNCIONARIO E ADICIONO NO ARRAY GERAL(xml).
		conexao.salvarLista();
	}

	@Override
	public String[] buscar(int id) {
		for (String[] funcionario : conexao.recuperarLista()) {
			if (funcionario[0].equals(Integer.toString(id))) {
				return funcionario;
			}
		}
		return null;
	}

	@Override
	public ArrayList<String[]> listar() { 
		return conexao.recuperarLista();
	}

	@Override
	public boolean remover(String id) {
		for (String[] dados : conexao.recuperarLista()) {

			if (dados[0].equals(id)) {
				conexao.recuperarLista().remove(dados);
				conexao.salvarLista();
				return true;

			}

		}

		return false;
	}

}
