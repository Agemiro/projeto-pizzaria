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

import controller.ControlFuncionario;

public class TelaFuncionarios extends TelaDadosPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel modelo;
	private JTable tabela;
	
	public TelaFuncionarios() {
		
		setTitle("Funcionários");

        tabela();
        barraMenu();
        
        this.setVisible(true);
		
	}

	public void tabela() {		
		
		modelo = new DefaultTableModel();
		tabela = new JTable(modelo);

		modelo.addColumn("Nome");
		modelo.addColumn("Cargo");
		modelo.addColumn("Senha");
		modelo.addColumn("ID");
		
		ControlFuncionario control = new ControlFuncionario();
					
		for(int i = 0; i < control.acessaFuncionarios().size(); i++) {

			Object[] linha = new Object[modelo.getColumnCount()];
			
			linha[0] = control.acessaFuncionarios().get(i)[1];
			linha[1] = control.acessaFuncionarios().get(i)[2];
			linha[2] = control.acessaFuncionarios().get(i)[3];
			linha[3] = control.acessaFuncionarios().get(i)[0];
			
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
						
		//JMenuItem editar = new JMenuItem("Editar");
		
		JMenuItem excluir = new JMenuItem("Excluir");
				
		excluir.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = tabela.getSelectedRow();
				int colunaSelecionada = 3; 
				
				//int id = (int) tabela.getValueAt(linhaSelecionada, colunaSelecionada);  
				
				//System.out.println(id);
				
				if (linhaSelecionada == -1) {
					
					JOptionPane.showMessageDialog(null, "Nenhuma pizza foi selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {	
					
						ControlFuncionario control = new ControlFuncionario();		
					
						String id = (String) tabela.getValueAt(linhaSelecionada, colunaSelecionada);  
																		
						if(control.removerFuncionario(id)) {
													
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
	
}
