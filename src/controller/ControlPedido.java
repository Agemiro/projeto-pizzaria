package controller;

import java.util.ArrayList;

import model.Pedido;

public class ControlPedido {
	
	private Pedido pedido;

    public ControlPedido() {
    	pedido = new Pedido();
    }

    public boolean addPedido(String cpf, String data){
    	return pedido.addPedido(cpf, data);
    }
    
    public ArrayList<String[]> acessaPedido(){
    	return pedido.acessaPedido();
    }

	public boolean removerPedido(String cpf) {
		return pedido.removerPedido(cpf);
	}
    
}
