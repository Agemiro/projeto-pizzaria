package model;

import java.util.ArrayList;

import dao.DAOSabores;
import dao.ISaboresDAO;

public class Sabores {
	
	ISaboresDAO saboresDAO = new DAOSabores();

	public boolean addSabor(String sabor, String ingredientes, String preparo) {
		
    	String[] dadosSabor = {sabor, ingredientes, preparo};
    	
    	saboresDAO.criar(dadosSabor);

		return true;
		
	}

	public ArrayList<String[]> acessaSabores() {
		
		return saboresDAO.listar();
		
	}

	public boolean removerSabor(String status) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
