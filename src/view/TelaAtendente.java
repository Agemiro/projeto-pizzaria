package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControlPizza;

public class TelaAtendente extends TelaPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel modelo;
	private JTable tabela;
	private JButton anotarPedido;
	
	public TelaAtendente() {
		
		setTitle(controlFuncionario.acessaUsuarioLogado() + " (Atendente)");
        
		botoes();
		
		Panel painel = new Panel();
		add(painel);
		
		this.setVisible(true);
		
	}
	
	public class Panel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		ImageIcon fundo =  new ImageIcon(getClass().getResource("imagem_fundo.jpg"));;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image imagem = fundo.getImage();
			g.drawImage(imagem, 0,0,this);
		}
		
	}
		
	public void botoes() {
		
		anotarPedido = new BotaoPadrao("CADASTRAR PEDIDO", 12, 126, 240, 35, Icones.ADDPEDIDO);
		anotarPedido.setToolTipText("Clique para anotar pedidos");

		anotarPedido.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroPedido();
			}
			
		});
		/*atenderCliente = new JButton("ATENDER", Icones.ATENDER);
		atenderCliente.setBounds(45, 200, 140, 35);
		atenderCliente.setToolTipText("Clique para atender o cliente");
	
		atenderCliente.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
								
				int linhaSelecionada = tabela.getSelectedRow();
								 						
				if (linhaSelecionada == -1) {
					JOptionPane.showMessageDialog(null, "Ninguém selecionado!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {	
						
					
						//Cliente  cliente = controlfunc.getClientesASeremAtendidos().get(linhaSelecionada);
						
						//campoCpf.setText(cliente.getCpf()); 
																																																																																																																																				
				}
			}
		});
		
		finalizarAtendimento = new JButton("FINALIZAR", Icones.FINALIZAR);
		finalizarAtendimento.setBounds(45, 250, 140, 35);
		finalizarAtendimento.setToolTipText("Clique para finalizar o atendimento");
		
		finalizarAtendimento.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
								
				int linhaSelecionada = tabela.getSelectedRow();
								 						
				if (linhaSelecionada == -1) {
					JOptionPane.showMessageDialog(null, "Ninguém selecionado!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {		
					
						//Cliente  cliente = cliente.getClientesASeremAtendidos().get(linhaSelecionada);
						
						//cc.getClientesASeremAtendidos().remove(cliente); 
																		
						//cc.adicionarClientesEsperandoEntrega(cliente);
																																																																																																						
						modelo.removeRow(linhaSelecionada);
						
						//pc.salvarDados(cc, "clientes.xml");		
						
						dispose();
						new TelaAtendente();
																														
				}
			}
		});*/
		
		//add(atenderCliente);
		add(anotarPedido);
		//(finalizarAtendimento);
		
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

	public JButton getAnotarPedido() {
		return anotarPedido;
	}
	public void setAnotarPedido(JButton anotarPedido) {
		this.anotarPedido = anotarPedido;
	}
	
}
