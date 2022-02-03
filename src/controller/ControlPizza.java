package controller;

import java.util.ArrayList;

import model.Pizza;

public class ControlPizza {
	
    private Pizza pizza;
    
    public ControlPizza() {
    	pizza = new Pizza();
    }
    
    public boolean addPizza(ArrayList<String> sabores, String tamanho, int fatias, float preco, String data){
    	return pizza.addPizza(sabores, tamanho, fatias, preco, data);
    }
    
    public ArrayList<String[]> acessaPizzas() {
		return pizza.acessaPizzas();
    }

   /* public boolean removerPizza(String status) {
		return pizza.removerPizza(status);
	}*/
	
	public boolean mudarStatusPizzaOk(String id, String data) {
		return pizza.mudarStatusPizzaOK(id, data);
	}

	public boolean mudarStatusPizzaNaoConcluida(String data) {
		return pizza.mudarStatusPizzaNaoConcluida(data);
	}

	/*public boolean mudarStatusPizzaConcluida(String data) {
		return pizza.mudarStatusPizzaConcluida(data);
	}*/

	public boolean mudarStatusPizzaVendida(String id) {
		return pizza.mudarStatusPizzaVendida(id);
	}

}
