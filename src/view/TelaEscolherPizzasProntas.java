package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.ControlPizza;

public class TelaEscolherPizzasProntas extends TelaDadosPadrao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel modelo;
	private JTable tabela;
	
	public TelaEscolherPizzasProntas() {
		
		setTitle("Escolha qualquer uma");
		
		tabelaPizzasAVenda();
		barraMenu();
		
		this.setVisible(true);
		
	}
	
	public void tabelaPizzasAVenda() {
		
		modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		
		modelo.addColumn("Sabores");
		modelo.addColumn("Tamanho");
		modelo.addColumn("Nº de Fatias");
		modelo.addColumn("Preço");
		modelo.addColumn("Status");
		modelo.addColumn("Data/Horário");
		modelo.addColumn("ID");
		
		ControlPizza control = new ControlPizza();
		
		for(int i = 0; i < control.acessaPizzas().size(); i++) {
			
			if(control.acessaPizzas().get(i)[4].equals("Pronta")) {
			
				Object[] linha = new Object[modelo.getColumnCount()];
			
				linha[0] = control.acessaPizzas().get(i)[0];
				linha[1] = control.acessaPizzas().get(i)[1];
				linha[2] = control.acessaPizzas().get(i)[2];
				linha[3] = control.acessaPizzas().get(i)[3];
				linha[4] = control.acessaPizzas().get(i)[4];
				linha[5] = control.acessaPizzas().get(i)[5];
				linha[6] = control.acessaPizzas().get(i)[6];
							
				modelo.addRow(linha);
			
			}
				
		}
		
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(0, 30, 750, 541);
		
		add(painel);
		
	}
	
	private void barraMenu() {
		
		JMenuBar barraDeMenu = new JMenuBar();
		setJMenuBar(barraDeMenu);
		
		JMenu opcoes = new JMenu("Opções");

		JMenuItem fazer = new JMenuItem("Escolher pizza");
				
		fazer.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = tabela.getSelectedRow();
				int colunaSelecionada = 6;  
				
				if (linhaSelecionada == -1) {
					
					JOptionPane.showMessageDialog(null, "Nenhuma pizza foi selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {		
					
						ControlPizza controlp = new ControlPizza();		
					
						String id = (String) tabela.getValueAt(linhaSelecionada, colunaSelecionada);  
												
						if(controlp.mudarStatusPizzaVendida(id)) {
													
							JOptionPane.showMessageDialog(null, "Pizza adicionada com sucesso!", "Pizza adicionada", JOptionPane.INFORMATION_MESSAGE);
							
							modelo.removeRow(linhaSelecionada);

						}
						
				}
				
			}
			
		});
		
		opcoes.add(fazer);
		barraDeMenu.add(opcoes);
		
	}

}
