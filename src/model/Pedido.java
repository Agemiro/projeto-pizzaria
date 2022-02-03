package model;

import java.util.ArrayList;

import dao.IPedidoDAO;
import dao.DAOPedido;

public class Pedido {
	
	private IPedidoDAO pedidoDAO = new DAOPedido();
	private String cpf;
	private String status = "Em andamento";

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean addPedido(String cpf, String data) {
        
		//String[] vetor = (String[]) sabores.toArray(new String[sabores.size()]);  

		String[] dadosPedido = {cpf, data};

        pedidoDAO.criar(dadosPedido);
        
        return true;
        
	}

	public ArrayList<String[]> acessaPedido() {
		
		return pedidoDAO.listar();//RETORNA O ARRAYLIST DE VETORES COM PEDIDOS
		
	}

	public boolean removerPedido(String cpf) {
		
		ArrayList<String[]> pedidos = new ArrayList<String[]>();
						
		for (String[] dados : pedidoDAO.listar()) {
			if(dados[0].equals(cpf)) {
				pedidos.add(dados);
			}
		}
		
		pedidoDAO.remover(pedidos);

		return true;
		
	}

	/*public boolean mudarStatusPedido(String cpf) {
				
		for (Pedido ped: c.getPedidos()) {
			if(ped.getCpf().equals(cpf)) {
				
				ped.setStatus("ok");
				
		        xml.salvarDados(c, "pedidos.xml");	
		        break;
				
			}
		}

		return true;
		
	}*/
	
}
 