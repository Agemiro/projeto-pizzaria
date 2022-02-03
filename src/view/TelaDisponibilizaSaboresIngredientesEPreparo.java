package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ControlSabores;

public class TelaDisponibilizaSaboresIngredientesEPreparo extends TelaCadastroPadrao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField sabor;
	private JTextArea ingredientes;
	private JTextArea preparo;
	private JButton finalizar;
	
	public TelaDisponibilizaSaboresIngredientesEPreparo() {
		
		setTitle("Disponibilizar Sabores, Ingredientes e Preparo");
		
		labels();
		campoDigito();
		botoes();
		
		this.setVisible(true);
		
	}
	
	private void labels() {
		
		JLabel sabor = new JLabel("Sabor"); 
		sabor.setBounds(50, 40, 100, 15);
		sabor.setFont(new Font("Arial", Font.BOLD, 15));
		sabor.setForeground(Color.BLACK);
		
		JLabel ingredientes = new JLabel("Ingredientes"); 
		ingredientes.setBounds(50, 120, 100, 15);
		ingredientes.setFont(new Font("Arial", Font.BOLD, 15));
		ingredientes.setForeground(Color.BLACK);
		
		JLabel preparo = new JLabel("Forma de preparar"); 
		preparo.setBounds(50, 220, 150, 15);
		preparo.setFont(new Font("Arial", Font.BOLD, 15));
		preparo.setForeground(Color.BLACK);
		
		add(sabor);
		add(preparo);
		add(ingredientes);

	}
	
	private void campoDigito() {
		
		sabor = new JTextField();
		sabor.setBounds(50, 60, 220, 35);
		sabor.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		sabor.setToolTipText("Digite um sabor");
		
		ingredientes = new JTextArea();
		ingredientes.setLineWrap(true);
		ingredientes.setWrapStyleWord(true);
		ingredientes.setBounds(50, 140, 340, 60);
		ingredientes.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		ingredientes.setToolTipText("Digite os ingredientes");
		
		preparo = new JTextArea();
		preparo.setLineWrap(true);
		preparo.setWrapStyleWord(true);
		preparo.setBounds(50, 250, 340, 150);
		preparo.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		preparo.setToolTipText("Digite a forma de preparo");
		
		add(sabor);
		add(ingredientes);
		add(preparo);
		
	}
	
	public void botoes() {
		
		finalizar = new JButton("FINALIZAR", Icones.OK);
		finalizar.setBounds(140, 430, 180, 35);
		finalizar.setToolTipText("Clique para cadastrar o sabor");
		
		OuvinteInternoFinalizar ouvinte = new OuvinteInternoFinalizar();
		
		finalizar.addActionListener(ouvinte);
		
		add(finalizar);
		
	}
	
	private class OuvinteInternoFinalizar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			boolean confere = true;
						
			if(sabor.getText().equals("")) {	
				confere = false;
			}
			if(ingredientes.getText().equals("")) {
				confere = false;
			}
			if(preparo.getText().equals("")) {
				confere = false;
			}
			
			if(confere) {
				
				ControlSabores control = new ControlSabores();
				
				control.addSabor(sabor.getText(), ingredientes.getText(), preparo.getText());
				
				JOptionPane.showMessageDialog(null, "Sabor cadastrado com sucesso!", "Sabor cadastrado", JOptionPane.INFORMATION_MESSAGE);
				
				dispose();
				new TelaDisponibilizaSaboresIngredientesEPreparo();
				
			}else {
				JOptionPane.showMessageDialog(null, "Preenchimento de dados inválido!", "Falha", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}

}
