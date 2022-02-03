package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControlPizza;
import controller.ControlSabores;

public class TelaPizzas extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel modelo;
	private JTable tabela;

	public TelaPizzas(){
		
		setTitle("Pizzas à Fazer");
		setSize(850,541);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
        tabelaPizzas();
        barraMenu();
        
        this.setVisible(true);
		
	}
	
	public void tabelaPizzas() {
		
		modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		
		modelo.addColumn("Sabores");
		modelo.addColumn("Tamanho");
		modelo.addColumn("Nº de Fatias");
		modelo.addColumn("Status");
		modelo.addColumn("Data/Horário");
		modelo.addColumn("ID");
		
		ControlPizza control = new ControlPizza();
		
		for(int i = 0; i < control.acessaPizzas().size(); i++) {
			
			if(control.acessaPizzas().get(i)[4].equals("Em andamento")) {
			
				Object[] linha = new Object[modelo.getColumnCount()];
			
				linha[0] = control.acessaPizzas().get(i)[0];
				linha[1] = control.acessaPizzas().get(i)[1];
				linha[2] = control.acessaPizzas().get(i)[2];
				linha[3] = control.acessaPizzas().get(i)[4];
				linha[4] = control.acessaPizzas().get(i)[5];
				linha[5] = control.acessaPizzas().get(i)[6];
							
				modelo.addRow(linha);
				
			}

		}
		
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(0, 30, 850, 541);
		
		add(painel);
		
	}
	
	private String data() {
		Date data = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String formatada = dateFormat.format(data);
		return formatada;
	}
	
	private void barraMenu() {
		
		JMenuBar barraDeMenu = new JMenuBar();
		setJMenuBar(barraDeMenu);
		
		JMenu opcoes = new JMenu("Opções");

		JMenuItem fazer = new JMenuItem("Fazer pizza");
		
		JMenuItem ingredientes = new JMenuItem("Ver ingredientes");
		
		JMenuItem preparo = new JMenuItem("Ver forma de preparo");
				
		fazer.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = tabela.getSelectedRow();
				int colunaSelecionada = /*tabela.getSelectedColumn()*/ 4;  
				
				if (linhaSelecionada == -1) {
					
					JOptionPane.showMessageDialog(null, "Nenhuma pizza foi selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {		
					
						ControlPizza control = new ControlPizza();		
					
						String data = (String) tabela.getValueAt(linhaSelecionada, colunaSelecionada);  
						String id = (String) tabela.getValueAt(linhaSelecionada, 5);  
																		
						if(control.mudarStatusPizzaNaoConcluida(data)) {
													
							JOptionPane.showMessageDialog(null, "Pizza feita com sucesso(Tem dono)!", "Pizza pronta", JOptionPane.INFORMATION_MESSAGE);
							
							modelo.removeRow(linhaSelecionada);

						}
						
						else if(control.mudarStatusPizzaOk(id, data)) {
							
							JOptionPane.showMessageDialog(null, "Pizza feita com sucesso(Não tem dono ainda)!", "Pizza pronta", JOptionPane.INFORMATION_MESSAGE);
							
							modelo.removeRow(linhaSelecionada);

						}
						
				}
				
			}
			
		});
		
		ingredientes.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = tabela.getSelectedRow();
				int colunaSelecionada = /*tabela.getSelectedColumn()*/ 0;  
				
				if (linhaSelecionada == -1) {
					
					JOptionPane.showMessageDialog(null, "Nenhuma pizza foi selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {		
					
						ControlSabores control = new ControlSabores();		
					
						String sabor = (String) tabela.getValueAt(linhaSelecionada, colunaSelecionada);  
																		
						String ingredientes = "";
					    
					    String[] quebra = sabor.split(", ");
						
					    boolean maisDEUm = true;
					    
						for(int i = 0; i < control.acessaSabores().size(); i++) {
							
							if(quebra.length == 1){
								if(control.acessaSabores().get(i)[0].equals(quebra[0])) {
									ingredientes += quebra[0] + ": " + control.acessaSabores().get(i)[1];
									maisDEUm = false;
									break;
								}
							}
						}
						if(maisDEUm) {
							for(int i = 0; i < control.acessaSabores().size(); i++) {
								if(control.acessaSabores().get(i)[0].equals(quebra[i])) {
									ingredientes += quebra[i] + ": " + control.acessaSabores().get(i)[1] + "\n\n";								
								}
							}
						}
				        JOptionPane.showMessageDialog(null, ingredientes, "Ingredientes", JOptionPane.INFORMATION_MESSAGE);	
				}
				
			}
			
		});
		
		preparo.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = tabela.getSelectedRow();
				int colunaSelecionada = /*tabela.getSelectedColumn()*/ 0;  
				
				if (linhaSelecionada == -1) {
					
					JOptionPane.showMessageDialog(null, "Nenhuma pizza foi selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {		
					
						ControlSabores control = new ControlSabores();		
					
						String sabor = (String) tabela.getValueAt(linhaSelecionada, colunaSelecionada);  
																		
					    String preparo = "";
					    
					    String[] quebra = sabor.split(", ");
						
					    boolean maisDEUm = true;
					    
						for(int i = 0; i < control.acessaSabores().size(); i++) {
							
							if(quebra.length == 1){
								if(control.acessaSabores().get(i)[0].equals(quebra[0])) {
									preparo += quebra[0] + ": " + control.acessaSabores().get(i)[2];
									maisDEUm = false;
									break;
								}
							}
						}
						if(maisDEUm) {
							for(int i = 0; i < control.acessaSabores().size(); i++) {
								if(control.acessaSabores().get(i)[0].equals(quebra[i])) {
									preparo += quebra[i] + ": " + control.acessaSabores().get(i)[2] + "\n\n";								
								}
							}
						}
				        JOptionPane.showMessageDialog(null, preparo, "Forma de preparo", JOptionPane.INFORMATION_MESSAGE);	
				}
				
			}
			
		});
		
		opcoes.add(fazer);
		opcoes.add(ingredientes);
		opcoes.add(preparo);
		barraDeMenu.add(opcoes);
		
	}

}
