package model;

import java.util.ArrayList;

import dao.DAOContabilidade;
import dao.DAOPedido;
import dao.IContabilidadeDAO;
import dao.IPedidoDAO;
import dao.IPizzaDAO;
import dao.DAOPizza;

public class Pizza {
	
	private IPizzaDAO pizzaDAO = new DAOPizza();
	private IPedidoDAO pedidoDAO = new DAOPedido();
	private IContabilidadeDAO contabilDAO = new DAOContabilidade();

	private ArrayList<String> sabores;
	private String tamanho;
	private int quantidadeFatias;
	private String formaPreparo;
	private String ingredientes;
	private float custo;
	private String status = "Em andamento";
	
    public int geraID() {
    	
    	if(pizzaDAO.listar().size() < 1) {
    		return 1;
    	}
    	String ultimoID = pizzaDAO.listar().get(pizzaDAO.listar().size()-1)[6];
		int id = Integer.parseInt(ultimoID);
		return id+=1;
    	
    }
	
	public ArrayList<String> getSabores() {
		return sabores;
	}
	public void setSabores(ArrayList<String> sabores) {
		this.sabores = sabores;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public int getQuantidadeFatias() {
		return quantidadeFatias;
	}
	public void setQuantidadeFatias(int quantidadeFatias) {
		this.quantidadeFatias = quantidadeFatias;
	}
	public String getFormaPreparo() {
		return formaPreparo;
	}
	public void setFormaPreparo(String formaPreparo) {
		this.formaPreparo = formaPreparo;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	public float getCusto() {
		return custo;
	}
	public void setCusto(float custo) {
		this.custo = custo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean addPizza(ArrayList<String> sabores, String tamanho, int fatias, float preco2, String data) {
		
        String fatias2 = Integer.toString(fatias);
        String preco = Float.toString(preco2);
        
        String todosSabores = "";
        
        for(int y = 0; y < sabores.size(); y++) {
        		todosSabores += sabores.get(y) + ", ";
        }
        	        
    	String[] dadosPedido = {todosSabores, tamanho, fatias2, preco, status, data, Integer.toString(geraID())};
		
        pizzaDAO.criar(dadosPedido);
        
        return true;
		
	}
	
	public ArrayList<String[]> acessaPizzas() {
		
		return pizzaDAO.listar();
		
	}
	
	public boolean mudarStatusPizzaOK(String id, String data) {
		
	//	for (String[] pizza : pizzaDAO.listar()) {
			for(String[] pedido : pedidoDAO.listar()) {
				if (!pedido[1].equals(data)){ 
				//	JOptionPane.showMessageDialog(null, "Pizza feita com sucesso(NAO Tem dono)!", "Pizza pronta", JOptionPane.INFORMATION_MESSAGE);
					return pizzaDAO.mudarPraOK(id, data); //PRONTA (NAO TEM DONO) TRUE OR FALSE
				}
			}
	//	}
		return false;
		
	}
	
	public boolean mudarStatusPizzaNaoConcluida(String data) {

		//for (String[] pizza : pizzaDAO.listar()) {
			for(String[] pedido : pedidoDAO.listar()) {
				if(pedido[1].equals(data)) {
					return pizzaDAO.mudarStatusPizzaNaoConcluida(data);
				}
			}
			
		//	boolean todos = true;
			for (String[] pizza : pizzaDAO.listar()) { 
				for(String[] pedido : pedidoDAO.listar()) {
					if(pizza[4].equals("Pedido Não Concluído") && pizza[5].equals(pedido[1])) { //DATA PIZZA E DATA PEDIDO
						System.out.println("Passou aqui");
						//todos = false;
					//}if(todos) {
						//for(String[] pedido : pedidoDAO.listar()) {
							//if(pizza[5].equals(pedido[1])) {
								pizzaDAO.mudarStatusPizzaConcluida(data);
							//}
					}
				}
			}
		/*	if(todos) {
				for (String[] pizza : pizzaDAO.listar()) { //SE NÃO EXISTIR MAIS NENHUMA PIZZA(PIZZAS) COM MESMA DATA DE PEDIDO(PEDIDOS)
					for(String[] pedido : pedidoDAO.listar()) {
						if(pizza[5].equals(pedido[1])) {
							pizzaDAO.mudarStatusPizzaConcluida(data);
						}
					}
				
				}

			}*/
										
		return false;
	}
	
	//public boolean mudarStatusPizzaConcluida(String data) { //TEM DONO TRUE OR FALSE

		//for (String[] pizza : pizzaDAO.listar()) {
			//for(String[] pizza : pizzaDAO.listar()) {
			//	if (pizza[4].equals("Pedido Não Concluído")){ // PORQUE EU NÃO QUERO PEGAR PIZZA QUE ESTÃO A VENDA, INDEPENTES DE CLIENTES.
				//	JOptionPane.showMessageDialog(null, "Pizza feita com sucesso(Tem dono)!", "Pizza pronta", JOptionPane.INFORMATION_MESSAGE);
				//	return pizzaDAO.mudarStatusPizzaConcluida(data);
			//	}
		//	}
	//	}
										
		//return false;
		
//	}
	
	public boolean mudarStatusPizzaVendida(String id) {
						
		int quantidadeVendida = 0;
		float valorVenda = 0;
		//String sabores;
		
		//ArrayList<String[]> pizzas = new ArrayList<String[]>();

		for (String[] dados : pizzaDAO.listar()) {
			if(dados[6].equals(id)) {
				//pizzas.add(dados);
				//removerPizza(dados[6]);
				quantidadeVendida ++;
				valorVenda += Float.parseFloat(dados[3]);
				return pizzaDAO.mudarPraVendida(id);
				//sabores.add(dados[0]);
			}
		}
				
		String[] dadosContabil = {Integer.toString(quantidadeVendida), Float.toString(valorVenda)};
		
		contabilDAO.criar(dadosContabil);
				
		return false;
		
	}
	
	/*public boolean removerPizza(String Status) {
		
		//int quantidadeVendida = 0;
		//float valorVenda = 0;
		
		ArrayList<String[]> pizzas = new ArrayList<String[]>();

		for (String[] dados : pizzaDAO.listar()) {
			if(dados[7].equals(status)) {
				pizzas.add(dados);
				//quantidadeVendida ++;
				//valorVenda += Float.parseFloat(dados[5]);
			}
		}
		
		pizzaDAO.remover(pizzas);
				
		String[] dadosContabil = {Integer.toString(quantidadeVendida), Float.toString(valorVenda)};
		
		contabilDAO.criar(dadosContabil);
		
		//c2.setQuantidadeVendidaNoMes(quantidadeVendida);
		
		//c2.setLucroMes(valorVenda);
		
		//xml2.salvarDados(c2, "contabilidade.xml");
		
        //xml.salvarDados(c, "pizzas.xml");	
		
		return true;

	}*/
	
}
