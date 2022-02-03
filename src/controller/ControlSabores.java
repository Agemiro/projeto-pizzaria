package controller;

import java.util.ArrayList;

import model.Sabores;

public class ControlSabores {
	
	   private Sabores sabores;
	    
	   public ControlSabores() {
		   sabores = new Sabores();
	   }
	    
	   public boolean addSabor(String sabor, String ingredientes, String preparo){
		   return sabores.addSabor(sabor, ingredientes, preparo);
	   }
	    
	   public ArrayList<String[]> acessaSabores() {
		   return sabores.acessaSabores();
	   }

	   public boolean removerSabor(String status) {
		   return sabores.removerSabor(status);
	   }

}
