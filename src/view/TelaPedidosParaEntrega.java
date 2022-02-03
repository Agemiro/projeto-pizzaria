package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

import controller.ControlCliente;
import controller.ControlPedido;
import controller.ControlPizza;

public class TelaPedidosParaEntrega extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DefaultTableModel modelo;
	private JTable tabela;
	
	public TelaPedidosParaEntrega() {
		
		setTitle("Pedidos para Entrega");
		setSize(750,541);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		tabelaVerPedidosCliente();
        barraMenu();
        
        this.setVisible(true);
        
	}

	public void tabelaVerPedidosCliente() {
		
		modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		
		modelo.addColumn("Sabor");
		modelo.addColumn("Tamanho");
		modelo.addColumn("Número de Fatias");
		modelo.addColumn("Status");
		modelo.addColumn("ID");
		
		ControlPizza control = new ControlPizza();
		
		for(int i = 0; i < control.acessaPizzas().size(); i++) {
			
			Object[] linha = new Object[modelo.getColumnCount()];
			
			if(control.acessaPizzas().get(i)[4].equals("Pedido Concluído")) { //SÓ APARECE SE TODAS AS PIZZAS ESTIVEREM CONCLUÍDAS
				
				linha[0] = control.acessaPizzas().get(i)[0];
				linha[1] = control.acessaPizzas().get(i)[1];
				linha[2] = control.acessaPizzas().get(i)[2];
//				linha[3] = control.acessaPizzas().get(i)[];
				linha[3] = control.acessaPizzas().get(i)[4];
					
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

		JMenuItem entregar = new JMenuItem("Entregar Pedido(s)"); 
						
		entregar.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = tabela.getSelectedRow();
				
				if (linhaSelecionada == -1) {
					
					JOptionPane.showMessageDialog(null, "Nenhum pedido foi selecionado!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {		
						
						/*ControlPizza control1 = new ControlPizza();	
						ControlPedido control2 = new ControlPedido();	
						
						int id = (int) tabela.getValueAt(linhaSelecionada, 4);  
						String status = (String) tabela.getValueAt(linhaSelecionada, 3);  

						String cpf = "";
						
						for(int i = 0; i < control2.acessaPedido().size(); i++) {
							if(id == control2.acessaPedido().get(i)) {
								cpf = control2.acessaPedido().get(i).getCpf();
							}
						}
						
						control2.removerPedido(cpf);
													
						if(control1.mudarStatusPizzaEntregue(status)) {
																						
						//	JOptionPane.showMessageDialog(null, "status entregue!", "Pedidos", JOptionPane.INFORMATION_MESSAGE);
					
						//}
						
						///if(control1.removerPizza(status)) {
						//	
							JOptionPane.showMessageDialog(null, "Pedidos do cliente de CPF " + cpf +  " entregue com sucesso!", "Pedidos entregue", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							new TelaPedidosParaEntrega();
							
						}*/
												
				}
				
			}
			
		});
		
		JMenuItem verCliente = new JMenuItem("Ver informações de Pedido");
		
		verCliente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = tabela.getSelectedRow();
				
				if (linhaSelecionada == -1) {
					
					JOptionPane.showMessageDialog(null, "Nenhum pedido foi selecionado!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {		
					
						ControlPedido control = new ControlPedido();	
						ControlCliente controlc = new ControlCliente();	
						ControlPizza controlp = new ControlPizza();	
						
						//int id = controlp.acessaPizzas().get(linhaSelecionada).getId();
						int id = (int) tabela.getValueAt(linhaSelecionada, 4);  
																	
						String nome = "";
						String cpf_cliente = "";
						String cpf_pedido = "";
						String endereco = "";
						String telefone = "";
						float valorAPagar = 0;
						
						/*for(int i = 0; i < control.acessaPedido().size(); i++) {

							if(id == control.acessaPedido().get(i).getId()) {
								cpf_pedido = control.acessaPedido().get(i).getCpf();
								valorAPagar += controlp.acessaPizzas().get(i).getCusto();

							}
							
						}*/
						
						for(int i = 0; i < controlc.acessaClientes().size(); i++) {
							
							if(controlc.acessaClientes().get(i)[1].equals(cpf_pedido)) {
								
								nome = controlc.acessaClientes().get(i)[0];
								cpf_cliente = controlc.acessaClientes().get(i)[1];
								endereco = controlc.acessaClientes().get(i)[2];
								telefone = controlc.acessaClientes().get(i)[3];
								
							}
							
						}
				        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", Font.LAYOUT_LEFT_TO_RIGHT, 20)));	
				        JOptionPane.showMessageDialog(null, "Nome: " + nome + 
								"\nCPF: " + cpf_cliente + "\nEndereço: " + endereco +
								"\nTelefone: " + telefone +"\nCusto: " + valorAPagar + " R$", "Dados entrega", 
								JOptionPane.INFORMATION_MESSAGE);
						
				}
				
			}
		});
		
		opcoes.add(verCliente);
		opcoes.add(entregar);
		barraDeMenu.add(opcoes);
		
	}
	
}
