package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControlCliente;

public class TelaClientes extends TelaDadosPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel modelo;
	private JTable tabela;
	
	public TelaClientes() {
		
		setTitle("Clientes");
		
        tabela();
        barraMenu();
        
        this.setVisible(true);
        
	}
	
	public void tabela() {

		modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Endereço");
		modelo.addColumn("Telefone");
		
		ControlCliente control = new ControlCliente ();
		
		for(int i = 0; i < control.acessaClientes().size(); i++) { //RECEBE UM ARRAY COM VETORES DE STRING
			
			Object[] linha = new Object[modelo.getColumnCount()];
			
			linha[0] = control.acessaClientes().get(i)[0];
			linha[1] = control.acessaClientes().get(i)[1];
			linha[2] = control.acessaClientes().get(i)[2];
			linha[3] = control.acessaClientes().get(i)[3];
			
			modelo.addRow(linha);

		}
		
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(0, 30, 750,541);
		
		add(painel);
		
	}
	
	private void barraMenu() {
		
		JMenuBar barraDeMenu = new JMenuBar();
		setJMenuBar(barraDeMenu);
		
		JMenu opcoes = new JMenu("Opções");
						
		/*JMenuItem editar = new JMenuItem("Editar");
				
		editar.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = tabela.getSelectedRow();
				int colunaSelecionada = 1; 
				
				if (linhaSelecionada == -1) {
					
					JOptionPane.showMessageDialog(null, "Nenhuma pizza foi selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {	
					
						ControlCliente control = new ControlCliente();		
					
						String cpf = (String) tabela.getValueAt(linhaSelecionada, colunaSelecionada);  
												
						if(control.editarCliente(cpf)) {
													
							JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!", "Cliente removido", JOptionPane.INFORMATION_MESSAGE);
							
						}
						
				}
				
			}
			
		});*/
		
		JMenuItem excluir = new JMenuItem("Excluir");
				
		excluir.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = tabela.getSelectedRow();
				int colunaSelecionada = 1; 
				
				if (linhaSelecionada == -1) {
					
					JOptionPane.showMessageDialog(null, "Nenhuma pizza foi selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {	
					
						ControlCliente control = new ControlCliente();		
					
						String cpf = (String) tabela.getValueAt(linhaSelecionada, colunaSelecionada);  
												
						if(control.removerCliente(cpf)) {
													
							JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!", "Cliente removido", JOptionPane.INFORMATION_MESSAGE);
							
							modelo.removeRow(linhaSelecionada);

						}
						
				}
				
			}
			
		});
		
		//opcoes.add(editar);
		opcoes.add(excluir);
		barraDeMenu.add(opcoes);
		
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}
	public static void main(String[] args) {
		new TelaClientes();
	}
}
