package model;

import java.util.ArrayList;

import dao.DAOContabilidade;
import dao.IContabilidadeDAO;

public class Contabilidade {
	
	private IContabilidadeDAO contabilDAO = new DAOContabilidade();
	
	private int quantidadeVendidaNoMes;
	private float lucroMes;
	private ArrayList<String> saboresMaisVendidosNoMes;
	
	public int getQuantidadeVendidaNoMes() {
		return quantidadeVendidaNoMes;
	}
	public void setQuantidadeVendidaNoMes(int quantidadeVendidaNoMes) {
		this.quantidadeVendidaNoMes = quantidadeVendidaNoMes;
	}
	public float getLucroMes() {
		return lucroMes;
	}
	public void setLucroMes(float lucroMes) {
		this.lucroMes = lucroMes;
	}
	public ArrayList<String> getSaboresMaisVendidosNoMes() {
		return saboresMaisVendidosNoMes;
	}
	public void setSaboresMaisVendidosNoMes(ArrayList<String> saboresMaisVendidosNoMes) {
		this.saboresMaisVendidosNoMes = saboresMaisVendidosNoMes;
	}
	
	public Contabilidade acessarContabilidade() {
		
		ArrayList<Contabilidade> listaPedidos = new ArrayList<Contabilidade>();
		
		for (String[] dados : contabilDAO.listar()) {
			Contabilidade contabil = converterParaContabil(dados);
			listaPedidos.add(contabil);
		}
		
		return listaPedidos.get(listaPedidos.size()-1);
		
	}
	
	private Contabilidade converterParaContabil(String[] dados) {
		
		Contabilidade obj = new Contabilidade();
		
		obj.setQuantidadeVendidaNoMes(Integer.parseInt(dados[0]));
		obj.setLucroMes(Float.parseFloat(dados[1]));
		//obj.setSaboresMaisVendidosNoMes(dados[]);
	
		return obj;
		
	}
	
}
