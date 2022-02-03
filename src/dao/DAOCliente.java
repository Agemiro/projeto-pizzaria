package dao;

import java.util.ArrayList;

public class DAOCliente implements IClienteDAO {
	
	private ConexaoXML conexao = new ConexaoXML("xml/clientes.xml");

	@Override
	public void criar(String[] dados) {
		
		conexao.recuperarLista().add(dados);
		conexao.salvarLista();
		
	}

	@Override
	public String[] buscar(String cpf) {
		for (String[] dados : conexao.recuperarLista()) {
			if(dados[1].equals(cpf)) {
				return dados;
			}
		}
		return null;
	}

	@Override
	public ArrayList<String[]> listar() {
		return conexao.recuperarLista();
	}

	//@Override
	/*public String[] buscarPeloNome(String nome) {
		
		for (String[] dados : conexao.recuperarLista()) {
			if(dados[0].equals(nome)) {
				return dados;
			}
		}
		
		return null;
	}*/

	@Override
	public boolean remover(String cpf) {
		
		for (String[] dados : conexao.recuperarLista()) {
			if(dados[1].equals(cpf)) {
				conexao.recuperarLista().remove(dados);
				conexao.salvarLista();
				break;
			}
			
		}

		return true;
 		
	}

}
